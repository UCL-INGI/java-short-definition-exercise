import json

# Opening JSON file
f = open('config19.json')

# returns JSON object as
# a dictionary
data = json.load(f)

file = open('Tests.java', 'r+')
fileEnd = open('ResultTest.java', 'w+')

# nbTest = 0
for line in file.readlines():

    # dataTest = data["tests"][nbTest]

    if "CONFIG_TESTS" in line:
        # for si plusieurs exos
        for test in data["tests"]:
            line = line.replace("CONFIG_TESTS", "tests" + "();")
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
        # ne marche pas pour plusieurs exos (boucle qui réécrit CONFIG_method_name ?)
        # appeller la methode tests?

        if "CONFIG_METHOD_NAME" in line:
            # écrire public void name(){\n
            line = line.replace("CONFIG_METHOD_NAME", "tests")

        """
        if "CONFIG_TEST_PARAMETERS" in line:
            nameTest = test["test"]
            parameters = nameTest[nameTest.find("(") + 1 : len(nameTest) - 1].split(",")

            parametersLine = ""
            nameParameter = 'a'
            for i in range(len(parameters)):
                if re.match("^((-)?\d\.\d)$", parameters[i]):
                    parametersLine += "double " + nameParameter
                    if i != len(parameters) - 1:
                        parametersLine += ", "
                nameParameter = chr(ord(nameParameter) + 1)
                # check le type + changer en double a, double b, ...

            line = line.replace("CONFIG_TEST_PARAMETERS", parametersLine)
        """
        if "ASSERTIONS" in line:
            i = 0
            assertions = ""
            for test in data["tests"]:
                assertions += "assertTrue("
                assertions += "Translator.translate(" + '"' + test["errorFeedback"] + '"' + ")" + ", "

                if isinstance(test["expected"], str):
                    assertions += '"' + test["expected"] + '"' + ".equals("
                else:
                    assertions += str(test["expected"]).lower() + " == "

                assertions += "Etudiant." + test["test"]

                if isinstance(test["expected"], str):
                    assertions += ")"

                assertions += ");"

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
    if pas de new & CAPS + lettres => type = List
    if ?[] => ?[]
    """
# Closing file
f.close()
file.close()
fileEnd.close()