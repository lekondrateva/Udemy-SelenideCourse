package tests.base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Listener implements TestWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        LOGGER.info("Test {} - FAILED", context.getTestMethod().get().getName());
        String screenshotName = context.getTestMethod().get().getName() +
                String.valueOf(System.currentTimeMillis()).substring(9, 13);
        LOGGER.info("Trying to trace screenshot...");
        Selenide.screenshot(screenshotName);
        attachScreenshotToAllure();
    }

    @Attachment
    public byte[] attachScreenshotToAllure() {
        if (WebDriverRunner.hasWebDriverStarted())
            return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        else return null;
    }
}