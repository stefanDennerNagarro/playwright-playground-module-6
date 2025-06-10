# Playwright Playground
## Module 6 - Thread Safety and Parallel Execution
### JUnit parallel execution with fixtures
This example runs Playwright tests with JUnit5 in parallel. See configuration in the file [junit-platform.properties](/junit-parallel-fixtures/src/test/resources/junit-platform.properties).

Example test classes are:
* [ParallelWithFixtureJUnitPageTest](/junit-parallel-fixtures/src/test/java/org/example/parallel/fixtures/ParallelWithFixtureJUnitPageTest.java)
* [ParallelWithFixturePlaywrightPageTest](/junit-parallel-fixtures/src/test/java/org/example/parallel/fixtures/ParallelWithFixturePlaywrightPageTest.java)

The tests and test classes are the same as in the [junit-parallel example](../junit-parallel/), but without the need of a TestFixture base class.
Instead, the `@Playwright` annotation is used to automate the handling of Playwright related resources and enabling the use of Fixtures.

To execute the tests, go to the folder and run the following mvn command:
```
cd junit-parallel-fixtures
mvn compile test
```

This will run the tests using Maven and the Surefire plugin.

The output will be like so:
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.example.parallel.fixtures.ParallelWithFixtureJUnitPageTest
[INFO] Running org.example.parallel.fixtures.ParallelWithFixturePlaywrightPageTest
Start execution of test shouldContainPlaywrightContent
Start execution of test shouldContainJUnit5Content
Execution done for test shouldContainPlaywrightContent
Start execution of test shouldMatchPlaywrightTitle
Execution done for test shouldMatchPlaywrightTitle
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 25.54 s -- in org.example.parallel.fixtures.ParallelWithFixturePlaywrightPageTest
Execution done for test shouldContainJUnit5Content
Start execution of test shouldMatchJUnit5Title
Execution done for test shouldMatchJUnit5Title
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 26.73 s -- in org.example.parallel.fixtures.ParallelWithFixtureJUnitPageTest
[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
```

Note the two classes are executed parallelly and the "Start execution" and "Execution done" messages are out of order.

Of course, the output does vary due to the parallel test execution.