package org.example;

import com.microsoft.playwright.*;

public class SingleThreadedExample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            System.out.println("Page title = " + page.title());
        }
    }
}