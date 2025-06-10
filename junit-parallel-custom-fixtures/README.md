# Playwright Playground
## Module 6 - Thread Safety and Parallel Execution
### JUnit parallel execution with custom fixtures
This example runs Playwright tests with JUnit5 in parallel. See configuration in the file [junit-platform.properties](/junit-parallel-custom-fixtures/src/test/resources/junit-platform.properties).

Example test classes are:
* [ParallelWithCustomFixtureJUnitPageTest](/junit-parallel-custom-fixtures/src/test/java/org/example/parallel/customfixtures/ParallelWithCustomFixtureJUnitPageTest.java)
* [ParallelWithCustomFixturePlaywrightPageTest](/junit-parallel-custom-fixtures/src/test/java/org/example/parallel/customfixtures/ParallelWithCustomFixturePlaywrightPageTest.java)

The setup is the same as in the [junit-parallel-fixtures example](../junit-parallel-fixtures/), but two custom options are implemented using the `OptionsFactory` to provide pre-configured Fixtures for test execution:

* [JUnitPageOptions](/junit-parallel-custom-fixtures/src/test/java/org/example/parallel/customfixtures/customoptions/JUnitPageOptions.java)
  * Run browser in headed mode (the browser window will be visible)
  * Use the URL https://junit.org/junit5 as base URL for the page in the test
* [PlaywrightPageOptions](/junit-parallel-custom-fixtures/src/test/java/org/example/parallel/customfixtures/customoptions/PlaywrightPageOptions.java)
  * Run browser in headed mode (the browser window will be visible)
  * Use the URL https://playwright.dev as base URL for the page in the test

The `@UsePlaywright()` annotation is used to apply the custom options to the test classes:

```
@UsePlaywright(JUnitPageOptions.class)
public class ParallelWithCustomFixtureJUnitPageTest { ... }
```
```
@UsePlaywright(PlaywrightPageOptions.class)
public class ParallelWithCustomFixturePlaywrightPageTest { ... }
```

The tests have been modified to only use relative URLs instead of the full URLs as in the [junit-parallel-fixtures example](../junit-parallel-fixtures/).
For example, instead of using `page.navigate("https://playwright.dev")`, the test now simply uses `page.navigate("/")`.

To execute the tests, go to the folder and run the following mvn command:
```
cd junit-parallel-custom-fixtures
mvn compile test
```

This will run the tests using Maven and the Surefire plugin. Instances of the Chromium browser will appear due to the custom option not using the headless mode.

The output will be like so:
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.examples.parallel.customfixtures.ParallelWithCustomFixturePlaywrightPageTest
[INFO] Running org.examples.parallel.customfixtures.ParallelWithCustomFixtureJUnitPageTest
Start execution of test shouldContainJUnit5Content
Start execution of test shouldContainPlaywrightContent
Execution done for test shouldContainPlaywrightContent
Start execution of test shouldMatchPlaywrightTitle
Execution done for test shouldMatchPlaywrightTitle
Execution done for test shouldContainJUnit5Content
Start execution of test shouldMatchJUnit5Title
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 26.40 s -- in org.examples.parallel.customfixtures.ParallelWithCustomFixturePlaywrightPageTest
Execution done for test shouldMatchJUnit5Title
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 27.53 s -- in org.examples.parallel.customfixtures.ParallelWithCustomFixtureJUnitPageTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
```

Note the two classes are executed parallelly and the "Start execution" and "Execution done" messages are out of order.

Of course, the output does vary due to the parallel test execution.