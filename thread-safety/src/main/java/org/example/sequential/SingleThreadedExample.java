package org.example.sequential;

import com.microsoft.playwright.*;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SingleThreadedExample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            System.out.println("Start execution in browser Chrome");
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            assertThat(page).hasTitle(Pattern.compile("Playwright"));
            System.out.println("Execution done in browser Chrome");
        }
    }
}