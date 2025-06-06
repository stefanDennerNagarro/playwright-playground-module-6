package org.example.parallel;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
// You can also use JUnit Assertions as well...
// import static org.junit.jupiter.api.Assertions.*;

public class ParallelPlaywrightPageTest extends TestFixtures {
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
}
