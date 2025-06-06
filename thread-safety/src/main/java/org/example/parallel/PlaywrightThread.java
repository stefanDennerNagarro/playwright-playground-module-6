package org.example.parallel;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlaywrightThread extends Thread {
    private final String browserName;

    PlaywrightThread(String browserName) {
        this.browserName = browserName;
    }

    @Override
    public void run() {
        try (Playwright playwright = Playwright.create()) {
            System.out.println("Start execution in browser " + browserName);
            BrowserType browserType = getBrowserType(playwright, browserName);
            Browser browser = browserType.launch();
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            assertThat(page).hasTitle(Pattern.compile("Playwright"));
            System.out.println("Execution done in browser " + browserName);
        }
    }

    private static BrowserType getBrowserType(Playwright playwright, String browserName) {
        switch (browserName) {
            case "chromium":
                return playwright.chromium();
            case "webkit":
                return playwright.webkit();
            case "firefox":
                return playwright.firefox();
            default:
                throw new IllegalArgumentException();
        }
    }
}