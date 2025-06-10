package org.example.parallel.customfixtures.customoptions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;

public class PlaywrightPageOptions implements OptionsFactory {
    @Override
    public Options getOptions() {
        return new Options()
                .setHeadless(false)
                .setContextOptions(new Browser.NewContextOptions()
                        .setBaseURL("https://playwright.dev/"));
    }
}
