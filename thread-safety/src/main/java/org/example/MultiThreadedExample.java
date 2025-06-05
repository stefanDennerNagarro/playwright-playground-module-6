package org.example;

import static java.util.Arrays.asList;

public class MultiThreadedExample {
    public static void main(String[] args) {
        // Create separate playwright thread for each browser.
        for (String browserName : asList("chromium", "webkit", "firefox")) {
            Thread thread = new PlaywrightThread(browserName);
            thread.start();
        }
    }
}