# Playwright Playground
## Module 6 - Thread Safety and Parallel Execution
### JUnit sequential execution
This example runs Playwright tests with JUnit5.
Example test class can be found in the class [JUnitSequentialTest](/junit-sequential/src/test/java/org/example/sequential/JUnitSequentialTest.java).

4 simple tests are implemented:
* shouldMatchPlaywrightTitle
  * Go to https://playwright.dev and check if the title contains "Playwright" 
* shouldContainPlaywrightContent
  * Go to https://playwright.dev and check if the text content of the page contains "Playwright"
* shouldMatchJUnit5Title
  * Go to https://junit.org/junit5 and check if the title contains "JUnit5"
* shouldContainJUnit5Content
  * Go to https://junit.org/junit5 and check if the text content of the page contains "JUnit5"

All tests are executed in the Chromium browser.

To execute the tests, go to the folder and run the following mvn command:
```
cd junit-sequential
mvn compile test
```

This will run the tests using Maven and the Surefire plugin. 

The output will be like so:
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.example.sequential.JUnitSequentialTest
Start execution of test shouldContainJUnit5Content
Execution done for test shouldContainJUnit5Content
Start execution of test shouldMatchJUnit5Title
Execution done for test shouldMatchJUnit5Title
Start execution of test shouldContainPlaywrightContent
Execution done for test shouldContainPlaywrightContent
Start execution of test shouldMatchPlaywrightTitle
Execution done for test shouldMatchPlaywrightTitle
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 28.49 s -- in org.example.sequential.JUnitSequentialTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
```

Note the "Start execution" and "Execution done" messages are in order and appear sequentially.