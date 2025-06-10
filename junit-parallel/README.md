# Playwright Playground
## Module 6 - Thread Safety and Parallel Execution
### JUnit parallel execution
This example runs Playwright tests with JUnit5 in parallel. See configuration in the file [junit-platform.properties](/junit-parallel/src/test/resources/junit-platform.properties).
Example test classes are:
 * [ParallelJUnitPageTest](/junit-parallel/src/test/java/org/example/parallel/ParallelJUnitPageTest.java)
 * [ParallelPlaywrightPageTest](/junit-parallel/src/test/java/org/example/parallel/ParallelPlaywrightPageTest.java)

Both classes use the same base class to share Playwright related resources called [TestFixtures](/junit-parallel/src/test/java/org/example/parallel/TestFixtures.java). 

The tests are the same as in the [junit-sequential example](../junit-sequential/), but split up in two classes.
Each class will be executed parallelly. The tests within a class will be executed sequentially.

All tests are executed in the Chromium browser.

To execute the tests, go to the folder and run the following mvn command:
```
cd junit-parallel
mvn compile test
```

This will run the tests using Maven and the Surefire plugin.

The output will be like so:
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.example.parallel.ParallelPlaywrightPageTest
[INFO] Running org.example.parallel.ParallelJUnitPageTest
Start execution of test shouldContainJUnit5Content
Start execution of test shouldContainPlaywrightContent
Execution done for test shouldContainPlaywrightContent
Start execution of test shouldMatchPlaywrightTitle
Execution done for test shouldMatchPlaywrightTitle
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 20.34 s -- in org.example.parallel.ParallelPlaywrightPageTest
Execution done for test shouldContainJUnit5Content
Start execution of test shouldMatchJUnit5Title
Execution done for test shouldMatchJUnit5Title
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 21.67 s -- in org.example.parallel.ParallelJUnitPageTest
[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
```

Note the two classes are executed parallelly and the "Start execution" and "Execution done" messages are out of order.

Of course, the output does vary due to the parallel test execution.