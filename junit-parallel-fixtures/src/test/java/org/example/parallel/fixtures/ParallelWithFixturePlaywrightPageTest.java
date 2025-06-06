package org.example.parallel.fixtures;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
// You can also use JUnit Assertions as well...
// import static org.junit.jupiter.api.Assertions.*;

@UsePlaywright
public class ParallelWithFixturePlaywrightPageTest {
    @Test
    void shouldMatchPlaywrightTitle(Page page) {
        System.out.println("Start execution of test shouldMatchPlaywrightTitle");
        page.navigate("https://playwright.dev/");
        assertThat(page).hasTitle(Pattern.compile("Playwright"));
        System.out.println("Execution done for test shouldMatchPlaywrightTitle");
    }

    @Test
    void shouldContainPlaywrightContent(Page page) {
        System.out.println("Start execution of test shouldContainPlaywrightContent");
        page.navigate("https://playwright.dev/");
        assertThat(page.locator("body")).containsText("Playwright");
        System.out.println("Execution done for test shouldContainPlaywrightContent");
    }
}
