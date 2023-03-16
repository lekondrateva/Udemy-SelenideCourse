package common;

import com.codeborne.selenide.Configuration;

public class Config {
    /**
     * Specify the browser and platform for test:
     * CHROME_MAC
     * CHROME_WINDOWS
     * MOZILLA_MAC
     */
    public static final String BROWSER_AND_PLATFORM = "chrome";
    /*** Clean browser cookies after each iteration*/
    public static final Boolean CLEAR_COOKIES = true;
    /*** Keep browser open after all tests*/
    public static final Boolean HOLD_BROWSER_OPEN = false;
    /*** Clear the directory with screenshots*/
    public static final Boolean CLEAR_REPORT_DIR = true;

    static {
        Configuration.holdBrowserOpen = HOLD_BROWSER_OPEN;
        Configuration.reportsFolder = "build/reports/tests";
        Configuration.browser = BROWSER_AND_PLATFORM;
    }
}
