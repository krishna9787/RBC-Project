# Instructions and Notes

Package Layout
1. project-rbc > src/test/java >testcases package has all the test cases
2. commonFunctions package has generic methods which will be reused by all test cases. It includes reporting methods, driver handling methods
and listener class methods.
3. pages package has class files for each page functionality.

Reporting
1. Report folder(at project level) has report.html file which provides the status of the test run with all steps.

TestNG xml
1. Cross browser testing and parallel testing have been inplemented
2. File location: test-output>testng.xml
3. parameter tag has browser. browser values allowed "chrome" and "firefox"

Listner Class
1. onStart method invokes methods before running TestNG Suite
2. onFinish method invokes methods after running TestNG Suite

AbstractTest
@BeforeClass and @AfterClass handled

Please note
browser value is passed to all methods to support parallel testing on multiple browsers

# Changes to be made in the code before starting execution: below mentioned point to be followed
After you download the project, edit chromedriver and geckodriver path in setup.properties file

# How to start execution
Right click testng.xml file and Select RunAs>TestNG Suite.