import json
import re

import jinja2

exerciseDefinition = open('config.json')
dataExercise = json.load(exerciseDefinition)

testFile = open('Tests.java', 'w+')

templateLoader = jinja2.FileSystemLoader("./")
templateEnv = jinja2.Environment(loader=templateLoader)
TEMPLATE_FILE = "TemplateTests.java"
template = templateEnv.get_template(TEMPLATE_FILE)

# IMPORTS
additionalImports = ""
for test in dataExercise["tests"]:
    if "Arrays" not in additionalImports and "expected" in test and str(test["expected"]).startswith("["):
        additionalImports += "import java.util.Arrays;\n"

    if "ByteArrayOutputStream" not in additionalImports and "checkConsole" in test:
        additionalImports += "import java.io.ByteArrayOutputStream;\n"
        additionalImports += "import java.io.PrintStream;\n"

if dataExercise["askFor"] == "class":
    additionalImports += "import java.lang.reflect.*;\n"

if "filesInExercise" in dataExercise and dataExercise["filesInExercise"]:
    additionalImports += "import java.io.*;\n"
# --------------------------------------------------------------------------------------------------------------

# Previous Code
previousCode = ""

if "filesInExercise" in dataExercise and dataExercise["filesInExercise"]:
    previousCode += "BufferedReader br = null;\n\t\t"
    previousCode += "try{\n\t\t\t"
    previousCode += "br = new BufferedReader(new FileReader(new File(\"./StudentCode/Etudiant.class\")));\n\t\t"
    previousCode += "} catch (Exception e){\n\t\t\t"
    previousCode += "fail(" + '"' + "Unexpected Exception" + '"' + ");\n\t\t"
    previousCode += "}\n\n\t\t"
    previousCode += "if (!br.lines().anyMatch(s -> s.trim().contains(\"BufferedReader\"))) { fail(\"BufferedReader expected\"); }\n\t\t"
    previousCode += "if (!br.lines().anyMatch(s -> s.trim().contains(\"close\"))) { fail(\"close() expected\"); }\n\n\t\t"

if "ByteArrayOutputStream" in additionalImports:
    previousCode += "PrintStream old = System.out;\n\t\t"
    previousCode += "String student_answer = \"\";\n\t\t"
# --------------------------------------------------------------------------------------------------------------

# INSTANCE
studentInstance = ""
instance = ""
classToCall = ""
instancesToCall = []
namesAsk = []
if "constructorWithParameters" not in dataExercise or not dataExercise["constructorWithParameters"]:
    if "nameAsk" not in dataExercise:
        studentInstance += "Etudiant etudiant = new Etudiant();"
        instance = "etudiant"
        classToCall = "Etudiant"
    else:
        studentInstance += dataExercise["nameAsk"] + " " + dataExercise["nameAsk"].lower() + " = new " + dataExercise["nameAsk"] + "();"
        instance = dataExercise["nameAsk"].lower()
        classToCall = dataExercise["nameAsk"]

    for test in range(len(dataExercise["tests"])):
        instancesToCall.append(instance)
        namesAsk.append(classToCall)

else:
    i = 0
    fieldToSelect = ""
    for test in dataExercise["tests"]:
        if ("hidden" not in test or not test["hidden"]) and "constructorParameters" in test and dataExercise["constructorWithParameters"]:

            if "classToCall" in test:
                fieldToSelect = test["classToCall"]

            else:
                fieldToSelect = dataExercise["nameAsk"]

            studentInstance += fieldToSelect + " " + fieldToSelect.lower() + str(i) + " = new " + fieldToSelect + "("
            instancesToCall.append(fieldToSelect.lower() + str(i))
            namesAsk.append(fieldToSelect)

            parametersList = str(test["constructorParameters"])[1:-1].split(", ")
            iParameter = 0

            for parameter in parametersList:
                if parameter[1:].startswith("new "):
                    studentInstance += str(parameter)[1:]
                else:
                    studentInstance += str(parameter).replace("'", "\"")

                if iParameter != len(parametersList) - 1:
                    studentInstance += ", "

                iParameter += 1

            i += 1
            studentInstance += ");\n\t\t"
        else:
            instancesToCall.append("")
            namesAsk.append("")

# --------------------------------------------------------------------------------------------------------------

# Assertion Test
assertionResult = ""
assertionsResults = []
errorsFeedbacks = []
testsName = []
i = 0

for test in dataExercise["tests"]:
    errorFeedback = ""
    nameTest = str(test["test"])[:str(test["test"]).find("(")]
    testsName.append(nameTest)

    if "hidden" not in test or not test["hidden"]:
        shouldCloseBrackets = False

        if "expected" in test and type(test["expected"]) == str:

            if str(test["expected"]).startswith("new"):
                assertionResult += test["expected"] + ".equals("
            else:
                assertionResult += '"' + test["expected"] + '"' + ".equals("

            shouldCloseBrackets = True
        elif "expected" in test and type(test["expected"]) == bool:
            assertionResult += str(test["expected"]).lower() + " == "

        elif "expected" in test and "[" in str(test["expected"]):
            if type(test["expected"][0]) == int:
                assertionResult += "Arrays.equals(new int[]" + str(test["expected"]).replace("[", "{").replace("]", "}") + ", "
            else:
                assertionResult += "Arrays.deepEquals(new "
                nbCrochet = 0
                elemExpected = test["expected"]
                while type(elemExpected) == list:
                    nbCrochet += 1
                    elemExpected = elemExpected[0]

                parsedExpected = str(test["expected"]).replace("[", "{").replace("]", "}") + ", "
                if type(elemExpected) == float:
                    assertionResult += "double" + "[]" * nbCrochet
                elif type(elemExpected) == bool:
                    assertionResult += "boolean" + "[]" * nbCrochet
                    parsedExpected = parsedExpected.replace("'", "").lower()
                elif str(elemExpected).startswith("new"):
                    elemExpected = str(elemExpected)[str(elemExpected).find(" ")+1:str(elemExpected).find("(")]
                    assertionResult += elemExpected + "[]" * nbCrochet
                    parsedExpected = parsedExpected.replace("'", "")
                elif type(elemExpected) == str:
                    assertionResult += "String" + "[]" * nbCrochet
                    parsedExpected = parsedExpected.replace("'", '"')
                elif type(elemExpected) == int:
                    assertionResult += "int" + "[]" * nbCrochet

                assertionResult += parsedExpected
            shouldCloseBrackets = True

        elif "expected" in test:
            assertionResult += str(test["expected"]) + " == "

        if "checkConsole" in test:
            assertionResult += "student_answer"
        else:
            while instancesToCall[i] == "":
                i += 1

            if "[" in test["test"]:
                nbCrochet = 1
                testParams = test["test"][test["test"].find("("):-1]
                print(testParams)

                while type(testParams) == list:
                    nbCrochet += 1
                    elemExpected = testParams[0]
                print(type(test["test"][test["test"].find("[")+1:test["test"].find(",")]))
                parsedTestParams = str(test["test"]).replace("[", "{").replace("]", "}")
                if type(testParams) == float or re.match("^.*\[\d.\d.*$", testParams):
                    parsedTestParams = "new double" + "[]" * nbCrochet + testParams.replace("(", "{").replace("[", "{").replace("]", "}") + "}"
                elif type(testParams) == bool or re.match("^.*\[(False|True){1}.*$", testParams):
                    parsedTestParams = "new boolean" + "[]" * nbCrochet + testParams.replace("(", "{").replace("[", "{").replace("]", "}") + "}"
                    parsedTestParams = parsedTestParams.replace("'", "").lower()
                elif str(testParams).startswith("new"):
                    testParams = str(testParams)[str(testParams).find(" ") + 1:str(testParams).find("(")]
                    parsedTestParams = "new " + testParams + "[]" * nbCrochet + testParams.replace("(", "{").replace("[", "{").replace("]", "}") + "}"
                    parsedTestParams = parsedTestParams.replace("'", "")
                elif type(testParams) == int or re.match("^.*\[\d.*$", testParams):
                    parsedTestParams = "new int" + "[]" * nbCrochet + testParams.replace("(", "{").replace("[", "{").replace("]", "}") + "}"
                elif type(testParams) == str:
                    parsedTestParams = "new String" + "[]" * nbCrochet + testParams.replace("(", "{").replace("[", "{").replace("]", "}") + "}"
                    parsedExpected = parsedTestParams.replace("'", '"')


                print(str(test["test"])[:str(test["test"]).find("(")+1] )
                print(parsedTestParams)
                assertionResult += instancesToCall[i] + "." + str(test["test"])[:str(test["test"]).find("(")+1] + parsedTestParams + ")"
            else:
                assertionResult += instancesToCall[i] + "." + test["test"]

        if shouldCloseBrackets:
            assertionResult += ")"

        # ERROR_FEEDBACK
        if "errorFeedback" in test:
            errorFeedback = '"' + test["errorFeedback"].replace('"', '\\' + '"') + '"'
        if "showStudentOutput" in test and test["showStudentOutput"]:
            errorFeedback += ' + ' + '"' + " | Your code returned : " + '" ' + ' + '
            if "checkConsole" in test and test["checkConsole"]:
                errorFeedback += "student_answer"

            elif "[" in test["test"]:
                errorFeedback += "Arrays.deepToString("

                # add transformation tableau de error
                nbCrochet = 1
                testParams = test["test"][test["test"].find("("):-1]
                print(testParams)

                while type(testParams) == list:
                    nbCrochet += 1
                    elemExpected = testParams[0]
                print(type(test["test"][test["test"].find("[") + 1:test["test"].find(",")]))
                parsedTestParams = str(test["test"]).replace("[", "{").replace("]", "}")
                if type(testParams) == float or re.match("^.*\[\d.\d.*$", testParams):
                    parsedTestParams = "new double" + "[]" * nbCrochet + testParams.replace("(", "{").replace("[",
                                                                                                              "{").replace(
                        "]", "}") + "}"
                elif type(testParams) == bool or re.match("^.*\[(False|True){1}.*$", testParams):
                    parsedTestParams = "new boolean" + "[]" * nbCrochet + testParams.replace("(", "{").replace("[",
                                                                                                               "{").replace(
                        "]", "}") + "}"
                    parsedTestParams = parsedTestParams.replace("'", "").lower()
                elif str(testParams).startswith("new"):
                    testParams = str(testParams)[str(testParams).find(" ") + 1:str(testParams).find("(")]
                    parsedTestParams = "new " + testParams + "[]" * nbCrochet + testParams.replace("(", "{").replace(
                        "[", "{").replace("]", "}") + "}"
                    parsedTestParams = parsedTestParams.replace("'", "")
                elif type(testParams) == int or re.match("^.*\[\d.*$", testParams):
                    parsedTestParams = "new int" + "[]" * nbCrochet + testParams.replace("(", "{").replace("[",
                                                                                                           "{").replace(
                        "]", "}") + "}"
                elif type(testParams) == str:
                    parsedTestParams = "new String" + "[]" * nbCrochet + testParams.replace("(", "{").replace("[",
                                                                                                              "{").replace(
                        "]", "}") + "}"
                    parsedExpected = parsedTestParams.replace("'", '"')

                print(str(test["test"])[:str(test["test"]).find("(") + 1])
                print(parsedTestParams)
                errorFeedback += instancesToCall[i] + "." + str(test["test"])[:str(test["test"]).find("(")+1] + parsedTestParams + ")"
                errorFeedback += ")"
            else:
                errorFeedback += instancesToCall[i] + "." + test["test"]

        i += 1

    assertionsResults.append(assertionResult)
    errorsFeedbacks.append(errorFeedback)
    assertionResult = ""

# --------------------------------------------------------------------------------------------------------------

dataTemplate = {
    "ADDITIONAL_IMPORTS":   additionalImports,
    "PREVIOUS_CODE":        previousCode,
    "STUDENT_INSTANCE":     studentInstance,
    "tests":                dataExercise["tests"],
    "askFor":               dataExercise["askFor"],
    "namesAsk":              namesAsk,
    "testsName":            testsName,
    "instancesToCall":      instancesToCall,
    "assertionsResults":    assertionsResults,
    "errorsFeedbacks":      errorsFeedbacks,
}

testFile.write(template.render(dataTemplate))

exerciseDefinition.close()
testFile.close()
