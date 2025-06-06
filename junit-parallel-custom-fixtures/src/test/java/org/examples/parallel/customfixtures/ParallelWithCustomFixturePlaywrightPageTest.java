package org.examples.parallel.customfixtures;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.examples.parallel.customfixtures.customoptions.PlaywrightPageOptions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
// You can also use JUnit Assertions as well...
// import static org.junit.jupiter.api.Assertions.*;

@UsePlaywright(PlaywrightPageOptions.class)
public class ParallelWithCustomFixturePlaywrightPageTest {
    @Test
    void shouldMatchPlaywrightTitle(Page page) {
        System.out.println("Start execution of test shouldMatchPlaywrightTitle");
        page.navigate("/");
        assertThat(page).hasTitle(Pattern.compile("Playwright"));
        System.out.println("Execution done for test shouldMatchPlaywrightTitle");
    }

    @Test
    void shouldContainPlaywrightContent(Page page) {
        System.out.println("Start execution of test shouldContainPlaywrightContent");
        page.navigate("/");
        assertThat(page.locator("body")).containsText("Playwright");
        System.out.println("Execution done for test shouldContainPlaywrightContent");
    }
}
