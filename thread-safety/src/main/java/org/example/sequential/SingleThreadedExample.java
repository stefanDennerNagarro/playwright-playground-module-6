package org.example.sequential;

import com.microsoft.playwright.*;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SingleThreadedExample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            System.out.println("Page title = " + page.title());
            assertThat(page).hasTitle(Pattern.compile("Playwright"));
        }
    }
}