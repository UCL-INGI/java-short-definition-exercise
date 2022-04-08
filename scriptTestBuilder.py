import json
import re

exerciseDefinition = open('config.json')
data = json.load(exerciseDefinition)

templateTestsFile = open('TemplateTests.java', 'r+')
testsFile = open('Tests.java', 'w+')

for line in templateTestsFile.readlines():
    if "ADDITIONAL_IMPORTS" in line:
        additional_imports = ""
        for test in data["tests"]:
            if "Arrays" not in additional_imports and "expected" in test and str(test["expected"]).startswith("["):
                additional_imports += "import java.util.Arrays;\n"
            if "ByteArrayOutputStream" not in additional_imports and "checkConsole" in test:
                additional_imports += "import java.io.ByteArrayOutputStream;\n"
                additional_imports += "import java.io.PrintStream;\n"

        if data["askFor"] == "class":
            additional_imports += "import java.lang.reflect.*;\n"
        if "filesInExercise" in data and data["filesInExercise"]:
            additional_imports += "import java.io.*;\n"

        line = line.replace("ADDITIONAL_IMPORTS", additional_imports)
    if "CONFIG_TESTS" in line:
        line = line.replace("CONFIG_TESTS", "tests();")

    else:
        if "CONFIG_METHOD_NAME" in line:
            line = line.replace("CONFIG_METHOD_NAME", "tests")

        elif "ASSERTIONS" in line:
            i = 0
            iClass = 0
            assertions = ""
            distinctTests = []

            if "filesInExercise" in data and data["filesInExercise"]:
                assertions += "BufferedReader br = null;\n\t\t"
                assertions += "try{\n\t\t\t"
                assertions += "br = new BufferedReader(new FileReader(new File(\"./StudentCode/Etudiant.class\")));\n\t\t"
                assertions += "} catch (Exception e){\n\t\t\t"
                assertions += "fail(" + '"' + "Unexpected Exception" + '"' + ");\n\t\t"
                assertions += "}\n\n\t\t"
                assertions += "if (!br.lines().anyMatch(s -> s.trim().contains(\"BufferedReader\"))) { fail(\"BufferedReader expected\"); }\n\t\t"
                assertions += "if (!br.lines().anyMatch(s -> s.trim().contains(\"close\"))) { fail(\"close() expected\"); }\n\n\t\t"

            if data["askFor"] == "class":
                if not data["constructorWithParameters"]:
                    assertions += data["nameAsk"] + " " + data["nameAsk"].lower() + " = new " + data[
                        "nameAsk"] + "();\n\t\t"

            if data["askFor"] == "method":
                if "nameAsk" in data and "constructorWithParameters" in data and not data["constructorWithParameters"]:
                    assertions += data["nameAsk"] + " " + data["nameAsk"].lower() + " = new " + data[
                        "nameAsk"] + "();\n\t\t"
                elif "nameAsk" not in data:
                    assertions += "Etudiant etudiant = new Etudiant();\n\t\t"

            if i == 0 and "ByteArrayOutputStream" in additional_imports:
                assertions += "ByteArrayOutputStream baos;\n\t\t"
                assertions += "PrintStream ps;\n\t\t"
                assertions += "PrintStream old = System.out;\n\t\t"
                assertions += "String rep_student;\n\t\t"
                assertions += "\n\t\t"

            for test in data["tests"]:
                if "hidden" not in test or not test["hidden"]:
                    nameTest = test["test"].split("(")[0]

                    if "constructorParameters" in test:
                        if "classToCall" in test and test["classToCall"] in assertions:
                            assertions += test["classToCall"].lower() + " = new " + test["classToCall"] + "("
                        elif "classToCall" in test:
                            assertions += test["classToCall"] + " " + test["classToCall"].lower() + " = new " + test[
                                "classToCall"] + "("
                        elif data["nameAsk"] in assertions:
                            assertions += data["nameAsk"].lower() + " = new " + data["nameAsk"] + "("
                        else:
                            assertions += data["nameAsk"] + " " + data["nameAsk"].lower() + " = new " + data["nameAsk"] + "("

                        parametersList = str(test["constructorParameters"])[1:-1].split(", ")
                        iParameter = 0

                        for parameter in parametersList:
                            if parameter[1:].startswith("new "):
                                assertions += str(parameter)[1:-1]
                            else:
                                assertions += str(parameter).replace("'", "\"")

                            if iParameter != len(parametersList) - 1:
                                assertions += ", "

                            iParameter += 1

                        # assertions += str(str(test["constructorParameters"])[1:-1]).replace("'", "\"")
                        assertions += ");\n\t\t"

                    if data["askFor"] == "class" and nameTest not in distinctTests:
                        distinctTests.append(nameTest)

                        if i != 0:
                            assertions += "\n\t\t"

                        parameterValue = test["test"].split("(")[1].split(")")[0]
                        parameterType = ""
                        if re.match("^\".*\"$", parameterValue):
                            parameterType = "String"
                        elif re.match("^\d+$", parameterValue):
                            parameterType = "int"
                        elif re.match("^new [A-Z]{1}.*$", parameterValue):
                            parameterType = str(parameterValue).split("new ")[1].split("(")[0]
                        assertions += "Method " + nameTest + "Stud = null;\n\n\t\t"
                        assertions += "try {\n\t\t\t"

                        if "classToCall" in test:
                            assertions += nameTest + "Stud = " + test["classToCall"] + ".class.getDeclaredMethod("
                        else:
                            assertions += nameTest + "Stud = " + data["nameAsk"] + ".class.getDeclaredMethod("

                        assertions += '"' + nameTest + '"'

                        if parameterValue != "":
                            assertions += ", " + parameterType + ".class"

                        assertions += ");\n\t\t"
                        assertions += "} catch (NoSuchMethodException e){\n\t\t\t"
                        assertions += "fail(" + '"' + "il vous faut une méthode " + nameTest + '"' + ");\n\t\t"
                        assertions += "}\n\n\t\t"

                    if test["test"].startswith("test"):
                        assertions += "try {\n\t\t\t"
                        assertions += data["nameAsk"].lower() + "." + test["test"] + ";\n\t\t"
                        assertions += "} catch (AssertionError e){\n\t\t\t"
                        assertions += "fail(" + '"' + "vos tests pour " + nameTest + " ne passent pas" + '"' + ");\n\t\t"
                        assertions += "}\n\n\t\t"

                    if not test["test"].startswith("test"):
                        nomClasse = "Etudiant"

                        if data["askFor"] == "class" and "classToCall" in test:
                            nomClasse = test["classToCall"].lower()

                        elif "nameAsk" in data and data["nameAsk"] != "":
                            nomClasse = data["nameAsk"].lower()

                        if "previousCalls" in test:
                            assertions += nomClasse + "." + test["previousCalls"] + ";\n\t\t"

                        if "filesInExercise" in data and data["filesInExercise"]:
                            assertions += "try {\n\t\t\t"

                        if "checkConsole" in test and test["checkConsole"]:
                            assertions += "baos = new ByteArrayOutputStream();\n\t\t"
                            assertions += "ps = new PrintStream(baos);\n\t\t"
                            assertions += "System.setOut(ps);\n\t\t"
                            assertions += nomClasse + "." + test["test"] + ";\n\t\t"
                            assertions += "System.out.flush();\n\t\t"
                            assertions += "rep_student = baos.toString();\n\t\t"

                        if "exceptionExpected" not in test:
                            assertions += "assertTrue("
                            assertions += "Translator.translate(" + '"' + test["errorFeedback"].replace("\"", "\\\"") + '"'

                            if "showStudentOutput" in test and test["showStudentOutput"]:
                                assertions += " + \" | Your code returned : \" + "
                                if "expected" in test and "[" in str(test["expected"]):
                                    assertions += "Arrays.deepToString("

                                nomClasse = "Etudiant"

                                if "checkConsole" in test and test["checkConsole"]:
                                    assertions += "rep_student"

                                elif data["askFor"] == "class" and "classToCall" in test:
                                    nomClasse = test["classToCall"].lower()

                                elif "nameAsk" in data and data["nameAsk"] != "":
                                    nomClasse = data["nameAsk"].lower()

                                if "rep_student" not in assertions:
                                    assertions += nomClasse + "."

                                if "rep_student" not in assertions and "[" in test["test"]:
                                    strExpected = str(test["test"])
                                    parameters = strExpected[strExpected.find("[") + 1: len(strExpected) - 1].split(",")
                                    parameterType = ""
                                    # suppose que tous ont le même type
                                    if re.match("^((-)?\d\.\d)$", parameters[0]):
                                        parameterType = "double"
                                    elif re.match("^-?\d$", parameters[0]):
                                        parameterType = "int"
                                    elif re.match("^\[\d+$", parameters[0]):
                                        parameterType = "int[]"
                                    line2 = test["test"].replace("]", "}")
                                    line2 = line2.replace("[", "new " + parameterType + "[] {")
                                    line2 = line2.replace("{new " + parameterType + "[]", "{ new " + parameterType)
                                    assertions += line2
                                elif "checkConsole" not in test or not test["checkConsole"]:
                                    assertions += test["test"]

                                if "expected" in test and "[" in str(test["expected"]):
                                    assertions += ")"

                            assertions += ")" + ", "
                        else:
                            assertions += "try {\n\t\t\t"

                        if "expected" in test and isinstance(test["expected"], list):
                            strExpected = str(test["expected"])
                            parameters = strExpected[strExpected.find("[") + 1: len(strExpected) - 1].split(",")
                            parameterType = ""
                            # suppose que tous ont le même type
                            if re.match("^\[-?\d+$", parameters[0]):
                                parameterType = "int[]"
                            elif re.match("^-?\d+$", parameters[0]):
                                parameterType = "int"

                            line2 = str(test["expected"]).replace("]", "}")
                            line2 = line2.replace("[", "new int" + "[] {")
                            line2 = "new " + parameterType + "[] " + str(line2)[9:]

                            if parameterType == "int":
                                assertions += "Arrays.equals(" + str(line2) + ", "
                            else:
                                assertions += "Arrays.deepEquals(" + str(line2) + ", "
                        elif "expected" in test and str(test["expected"]).startswith("new"):
                            assertions += test["expected"] + ".equals("
                        elif "expected" in test and isinstance(test["expected"], str):
                            assertions += '"' + test["expected"] + '"' + ".equals("
                        elif "expected" in test:
                            assertions += str(test["expected"]).lower() + " == "

                        if "checkConsole" in test and test["checkConsole"]:
                            assertions += "rep_student"
                        else:
                            assertions += nomClasse.lower() + "."

                        if "rep_student" not in assertions and "[" in test["test"]:
                            strExpected = str(test["test"])
                            parameters = strExpected[strExpected.find("[") + 1: len(strExpected) - 1].split(",")
                            parameterType = ""
                            # suppose que tous ont le même type
                            if re.match("^((-)?\d\.\d)$", parameters[0]):
                                parameterType = "double"
                            elif re.match("^-?\d$", parameters[0]):
                                parameterType = "int"
                            elif re.match("^\[\d+$", parameters[0]):
                                parameterType = "int[]"
                            line2 = test["test"].replace("]", "}")
                            line2 = line2.replace("[", "new " + parameterType + "[] {")
                            line2 = line2.replace("{new " + parameterType + "[]", "{ new " + parameterType)
                            assertions += line2
                        elif "checkConsole" not in test or not test["checkConsole"]:
                            assertions += test["test"]

                        if "expected" in test and (isinstance(test["expected"], str) or isinstance(test["expected"], list)):
                            assertions += ")"

                        if "shouldFail" not in test:
                            assertions += ")"

                        assertions += ";\n\t\t"

                        if "shouldFail" in test:
                            assertions += "\tfail(" + '"' + test["errorFeedback"] + '"' + ");\n\t\t"
                            assertions += "} catch(" + test["exceptionExpected"] + " e){\n\t\t"
                            assertions += "} catch(Exception e){\n\t\t"
                            assertions += "\tfail(" + '"' + test["errorFeedback"] + '"' + ");\n\t\t"
                            assertions += "}"
                            # assertions += "fail(" + '"' + test["errorFeedback"] + '"' + ");\n\t\t"

                        if "filesInExercise" in data and data["filesInExercise"]:
                            assertions += "} catch(Exception e){\n\t\t\t"
                            assertions += "fail(" + '"' + "Unexpected Exception" + '"' + ");\n\t\t"
                            assertions += "}\n"

                        if i != len(data["tests"]) - 1:
                            assertions += "\n\t\t"

                i += 1

            line = line.replace("ASSERTIONS", assertions)
        # }
        # \n\n TEST_METHOD => si i == len(tests) - 1
    testsFile.write(line)
    """
    Mieux pour replace ?
    
    import re
    re.sub(pattern, repl, string, count=0, flags=0)
    
    
    ^((-)?\d\.\d)$ -> double
    ^'(\S|\s)'$ -> char
    ^".*"$ -> String
    ^\d+$ -> int
    ^(true|false)$ -> boolean
    if new ???() -> type = ??? (split entre " " et '(')
    if pas de new & CAPS + lettres => type = List ou import in imports
    if ?[] => ?[]
    """
# Closing file
exerciseDefinition.close()
templateTestsFile.close()
testsFile.close()
