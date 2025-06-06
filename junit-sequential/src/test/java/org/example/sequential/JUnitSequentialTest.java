package org.example.sequential;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
// You can also use JUnit Assertions as well...
// import static org.junit.jupiter.api.Assertions.*;

public class JUnitSequentialTest {
    // Shared between all tests in this class.
    // Note: They are static!
    static Playwright playwright;
    static Browser browser;

    // New instance for each test method.
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    void shouldMatchPlaywrightTitle() {
        System.out.println("Start execution of test shouldMatchPlaywrightTitle");
        page.navigate("https://playwright.dev/");
        assertThat(page).hasTitle(Pattern.compile("Playwright"));
        System.out.println("Execution done for test shouldMatchPlaywrightTitle");
    }

    @Test
    void shouldContainPlaywrightContent() {
        System.out.println("Start execution of test shouldContainPlaywrightContent");
        page.navigate("https://playwright.dev/");
        assertThat(page.locator("body")).containsText("Playwright");
        System.out.println("Execution done for test shouldContainPlaywrightContent");
    }

    @Test
    void shouldMatchJUnit5Title() {
        System.out.println("Start execution of test shouldMatchJUnit5Title");
        page.navigate("https://junit.org/junit5/");
        assertThat(page).hasTitle(Pattern.compile("JUnit 5"));
        System.out.println("Execution done for test shouldMatchJUnit5Title");
    }

    @Test
    void shouldContainJUnit5Content() {
        System.out.println("Start execution of test shouldContainJUnit5Content");
        page.navigate("https://junit.org/junit5/");
        assertThat(page.locator("body")).containsText("JUnit 5");
        System.out.println("Execution done for test shouldContainJUnit5Content");
    }
}