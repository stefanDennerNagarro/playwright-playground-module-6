# Playwright Playground
## Module 6 - Thread Safety and Parallel Execution
### Thread-safety
This example runs Playwright in different browsers in a java program.
There are 2 examples:
* [SingleThreadedExample](/thread-safety/src/main/java/org/example/sequential/SingleThreadedExample.java)
* [MulitThreadedExample](/thread-safety/src/main/java/org/example/parallel/MultiThreadedExample.java)

All examples open the Playwright homepage at https://playwright.dev using different browsers.

#### SingleThreadedExample
To execute the single-threaded example, go to the folder and run the following mvn command:
```
cd thread-safety
mvn compile exec:java -D exec.mainClass="org.example.sequential.SingleThreadedExample"
```

This will only run Playwright in the Chromium browser. The output will be like so:
```
Start execution in browser chromium
Execution done in browser chromium
```

#### MultiThreadedExample
To execute the multi-threaded example, go to this folder and run the following mvn command:
```
cd thread-safety
mvn compile exec:java -D exec.mainClass="org.example.parallel.MultiThreadedExample"
```

This will start 3 threads, where every thread runs Playwright in a different browser (Webkit, Chromium, Firefox).

The output will be like so:
```
Start execution in browser webkit
Start execution in browser chromium
Start execution in browser firefox
Execution done in browser webkit
Execution done in browser chromium
Execution done in browser firefox
```

Note that the order of the output can vary between runs due to the multi-threaded execution.