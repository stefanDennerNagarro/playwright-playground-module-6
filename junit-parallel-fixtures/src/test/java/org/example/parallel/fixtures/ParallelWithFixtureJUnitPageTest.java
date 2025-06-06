package org.example.parallel.fixtures;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
// You can also use JUnit Assertions as well...
// import static org.junit.jupiter.api.Assertions.*;

@UsePlaywright
public class ParallelWithFixtureJUnitPageTest {
    @Test
    void shouldMatchJUnit5Title(Page page) {
        System.out.println("Start execution of test shouldMatchJUnit5Title");
        page.navigate("https://junit.org/junit5/");
        assertThat(page).hasTitle(Pattern.compile("JUnit 5"));
        System.out.println("Execution done for test shouldMatchJUnit5Title");
    }

    @Test
    void shouldContainJUnit5Content(Page page) {
        System.out.println("Start execution of test shouldContainJUnit5Content");
        page.navigate("https://junit.org/junit5/");
        assertThat(page.locator("body")).containsText("JUnit 5");
        System.out.println("Execution done for test shouldContainJUnit5Content");
    }
}
