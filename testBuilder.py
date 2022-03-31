import json, re

# TODO : check si execption bien lancé + Mock ?
# check avec file (M6dem4 ? / M9Q3) -> exersise with files => true / false + si true -> try catch IOException
# check avec mocks (M6dem1) -> OK ? Exo pas assez poussé ?
# check output console ? (m5dem5 / m5Q8 / m5Q9 / M05Q12)

# Opening JSON file
f = open('configM5Output.json')

# returns JSON object as
# a dictionary
data = json.load(f)

file = open('Tests.java', 'r+')
fileEnd = open('ResultTest.java', 'w+')

# nbTest = 0
for line in file.readlines():

    # dataTest = data["tests"][nbTest]
    if "ADDITIONAL_IMPORTS" in line:
        additional_imports = ""
        for test in data["tests"]:
            if "expected" in test and str(test["expected"]).startswith("["):
                additional_imports += "import java.util.Arrays;\n"
        if data["askFor"] == "class":
            additional_imports += "import java.lang.reflect.*;\n"
        if "filesInExercise" in data and data["filesInExercise"]:
            additional_imports += "import java.io.*;\n"

        line = line.replace("ADDITIONAL_IMPORTS", additional_imports)
    if "CONFIG_TESTS" in line:
        # for si plusieurs exos ?
        line = line.replace("CONFIG_TESTS", "tests();")
        """
        tests = ""
        i = 0
        for test in data["tests"]:
            tests += test["test"] + ";"

            if i != len(data["tests"]) - 1:
                tests += "\n\t\t"
            i += 1

        line = line.replace("CONFIG_TESTS", tests)
        """
    else:
        if "CONFIG_METHOD_NAME" in line:
            # for di plusieurs exos ?
            line = line.replace("CONFIG_METHOD_NAME", "tests")

        elif "ASSERTIONS" in line:
            i = 0
            iClass = 0
            assertions = ""
            distinctTests = []

            if data["askFor"] == "class":
                if not data["constructorWithParameters"]:
                    assertions += data["nameAsk"] + " " + data["nameAsk"].lower() + "Student = new " + data[
                        "nameAsk"] + "();\n\t\t"

            if data["askFor"] == "method":
                if not data["constructorWithParameters"] and "nameAsk" in data:
                    assertions += data["nameAsk"] + " " + data["nameAsk"].lower() + " = new " + data[
                        "nameAsk"] + "();\n\t\t"

            for test in data["tests"]:
                nameTest = test["test"].split("(")[0]

                if "constructorParameters" in test:
                    if test["classToCall"] in assertions:
                        assertions += test["classToCall"].lower() + "Student = new " + test["classToCall"] + "("
                    elif "classToCall" in test:
                        assertions += test["classToCall"] + " " + test["classToCall"].lower() + "Student = new " + test[
                            "classToCall"] + "("
                    elif data["nameAsk"] in assertions:
                        assertions += data["nameAsk"].lower() + "Student = new " + data["nameAsk"] + "("
                    else:
                        assertions += data["nameAsk"] + " " + data["nameAsk"].lower() + "Student = new " + data[
                            "nameAsk"] + "("

                    parametersList = str(test["constructorParameters"])[1:-1].split(", ")
                    iParameter = 0
                    print(parametersList)
                    for parameter in parametersList:
                        print(parameter)
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
                    assertions += data["nameAsk"].lower() + "Student." + test["test"] + ";\n\t\t"
                    assertions += "} catch (AssertionError e){\n\t\t\t"
                    assertions += "fail(" + '"' + "vos tests pour " + nameTest + " ne passent pas" + '"' + ");\n\t\t"
                    assertions += "}\n\n\t\t"

                if not test["test"].startswith("test"):
                    nomClasse = "Etudiant"

                    if data["askFor"] == "class" and "classToCall" in test:
                        nomClasse = test["classToCall"].lower() + "Student"

                    elif "nameAsk" in data and data["nameAsk"] != "":
                        nomClasse = data["nameAsk"].lower() + "Student"

                    if "previousCalls" in test:
                        assertions += nomClasse + "." + test["previousCalls"] + ";\n\t\t"

                    if "shouldFail" in test and test["shouldFail"]:
                        assertions += "try {\n\t\t\t"

                    if "shouldFail" not in test:
                        assertions += "assertTrue("
                        assertions += "Translator.translate(" + '"' + test["errorFeedback"].replace("\"",
                                                                                                    "\\\"") + '"' + ")" + ", "

                    """
                    # marche pas ?
                    if data["askFor"] == "class" and data["constructorWithParameters"] and "expected" not in test:
                        print(iClass)
                        if isinstance(data["constructorParameters"][iClass][0], str):
                            assertions += '"' + str(data["constructorParameters"][iClass][0]) + '"' +".equals("

                        if iClass < len(data["constructorParameters"]) - 1:
                            iClass += 1
                        else:
                            iClass = 0
                        #assertions += str(data["constructorParameters"][iClass][0])
                    """

                    if "expected" in test and isinstance(test["expected"], list):
                        strExpected = str(test["expected"])
                        parameters = strExpected[strExpected.find("[") + 1: len(strExpected) - 1].split(",")
                        # parameters = str(test["expected"]).split("[")[1].split("]")[0].split(",")
                        print(parameters)
                        parameterType = ""
                        # suppose que tous ont le même type
                        if re.match("^\[-?\d+$", parameters[0]):
                            parameterType = "int[]"
                        elif re.match("^-?\d+$", parameters[0]):
                            parameterType = "int"

                        line2 = str(test["expected"]).replace("]", "}")
                        line2 = line2.replace("[", "new int" + "[] {")
                        line2 = "new " + parameterType + "[] " + str(line2)[9:]
                        print(line2)

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

                    assertions += nomClasse + "."

                    # déterminer type de tableau si passer en param (cf. M5_1)
                    if "[" in test["test"]:
                        strExpected = str(test["test"])
                        parameters = strExpected[strExpected.find("[") + 1: len(strExpected) - 1].split(",")
                        print(parameters)
                        parameterType = ""
                        # suppose que tous ont le même type
                        if re.match("^((-)?\d\.\d)$", parameters[0]):
                            parameterType = "double"
                        elif re.match("^-?\d$", parameters[0]):
                            parameterType = "int"
                        elif re.match("^\[\d+$", parameters[0]):
                            parameterType = "int[]"
                        print(test["test"])
                        line2 = test["test"].replace("]", "}")
                        line2 = line2.replace("[", "new " + parameterType + "[] {")
                        line2 = line2.replace("{new " + parameterType + "[]", "{ new " + parameterType)
                        assertions += line2
                    else:
                        assertions += test["test"]

                    if "expected" in test and (isinstance(test["expected"], str) or isinstance(test["expected"], list)):
                        assertions += ")"

                    if "shouldFail" not in test:
                        assertions += ")"

                    assertions += ";\n\t\t"

                    if "shouldFail" in test:
                        assertions += "\t"
                        assertions += "fail(" + '"' + test["errorFeedback"] + '"' + ");\n\t\t"

                    if "shouldFail" in test and test["shouldFail"]:
                        assertions += "} catch(Exception e){\n\t\t"

                        if "shouldFail" not in test:
                            assertions += "\t"
                            assertions += "fail(" + '"' + '"' + ");\n\t\t"

                        assertions += "}\n"

                    if i != len(data["tests"]) - 1:
                        assertions += "\n\t\t"

                i += 1

            line = line.replace("ASSERTIONS", assertions)
        # }
        # \n\n TEST_METHOD => si i == len(tests) - 1
    fileEnd.write(line)
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
f.close()
file.close()
fileEnd.close()