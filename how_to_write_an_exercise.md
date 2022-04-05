# How to write an exercise in java

You need to create a json file to define your exercise. Then your json should have the following fields :

- "askFor": "method/class" - the part that the student will complete is for the moment either a method or a class.


- "nameAsk": "NameClass" - (optional) The name of the class to instantiate in order to test (by default Etudiant). If you are asking for several classes, then you should not indicate this information. In this specific case, it will not instantiate an Etudiant class.


- "constructorWithParameters": true/false - (optional) If the askFor is set to class and the nameAsk class has initial parameters this line should be set to true (false by default).


- "filesInExercise": true/false - (optional) If you are writing an exercise where the students need to use files, you should set this to true (false by default). In case of true, this will add some tests to check that the file is correctly close and if a BufferedReader is used in the exercise. It also imports java.io.*


- "tests": [ {test1}, {test2}, ... ] - The array containing all the different tests of the exercise.

<br>
<br>

Then, once you have those fields, you need to precise what is a test.
<br>
A test should have the following fields :

- "test" : "testName(1,2,3)" - The name of the method to test with parameters.
For example, "average(10, 23, 2)". If you have " in your parameters,
then you should escape it with \\. 


- "expected" : (1 / 2.7 / "A text" / [1, 2, 3] / ...) - (optional)
The expected answer. 
Note that if you are expecting an array, java.util.Arrays will be imported 
and Arrays.deepEquals will be used in the test. If it is an array of integers,
then it will be compared with == as int cannot be casted to objects.
If you have " in your parameters, then you should escape it with \\.
This field is optional if you are expecting an exception to be thrown. 


- "errorFeedback" : "" : The error message if the assertion does not return the expected result.
This message can be translated by having the translation written in a MessageBundle.properties file (MessageBundle_fr.properties for French translations).


- "shouldFail" : true/false - (optional) If your test should raise an Exception, you should set this information to true (false by default).
This will surround the test with a try catch and the test will fail if no exception was thrown.


- "previousCalls" : "method_to_call(1,2,3)" - (optional) If you need to test a void method, you should write it here and then,
you should put in the ``test`` field a method that return the expected result. For example, if you want to test a
setter, you will put the setter in previousCalls and the test could be a getter to check that the setter is correct. 


- "checkConsole" : true/false - (optional) If you want to compare the output of the console with the expected result, 
you should set this to true (false by default).
This will add a ByteOutputStream to get the text in the console as a String.
In this case, the expected answer should be a String.


- "constructorParameters" : [1,2,3] - (optional) If you previously set the field ``constructorWithParameters`` to true,
you should indicate the parameters that will be use for this test. It means that by giving this information,
the constructor will be called and so create a new instance of the class to test. Each test can have different
parameters, but you can also use the same parameters in all the tests. The only condition is that the parameters
should be in an array.


- "classToCall": "nameOfTheClass" - (optional) If you are writing an exercise where the students need to write more than one class,
you should give the information on which class will be called. Of course, this information should only appear
if the filed askFor was set to "class". It will create a new instance of the class
and called the method in the assertion. If you have only one class,
then the class in ``nameAsk`` field will be used to call the test.


- "exceptionExpected": "nameOfTheException" -
If your method should throw a specific exception in your test,
you should indicate the exception you are expecting to be thrown.
Note that in addition to that, you should set shouldFail to true.
This will build a try catch block where only
when you throw the appropriate Exception will succeed.
If you did not throw anything or another Exception, the test will fail.


- "hidden" : true/false - (optional) If the test should be in the class or not.
This is useful if you want to hide some tests from the students and give an
incomplete test class.