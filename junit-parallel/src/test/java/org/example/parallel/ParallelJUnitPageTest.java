package org.example.parallel;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
// You can also use JUnit Assertions as well...
// import static org.junit.jupiter.api.Assertions.*;

public class ParallelJUnitPageTest extends TestFixtures {
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
