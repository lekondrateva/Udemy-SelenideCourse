package tests.base;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;
import pages.loans.CarLoansPage;
import pages.telecomunications.MobilePhoneTopUpPage;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.Config.CLEAR_COOKIES;
import static common.Config.CLEAR_REPORT_DIR;

@ExtendWith(Listener.class)
//@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected BasePage basePage = new BasePage();
    protected CarLoansPage carLoansPage = new CarLoansPage();
    protected MobilePhoneTopUpPage mobilePhoneTopUpPage = new MobilePhoneTopUpPage();
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    static {
        LOGGER.info("START TIME:" + LocalTime.now());
        LOGGER.info("Start clear report dir: build/reports...");
        File allureResults = new File("allure-results");
        if (allureResults.isDirectory()) {
            for (File item : Objects.requireNonNull(allureResults.listFiles()))
                item.delete();
        }
        if (CLEAR_REPORT_DIR) {
            File allureScreenshots = new File("build/reports/tests");
            for (File item : Objects.requireNonNull(allureScreenshots.listFiles()))
                item.delete();
        }
    }

    @AfterEach
    void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES) {
            try {
                Selenide.clearBrowserCookies();
                Selenide.clearBrowserLocalStorage();
                Selenide.executeJavaScript("window.sessionStorage.clear()");
            } catch (Exception e) {
                LOGGER.error("Fail to clearCookiesAndLocalStorage() - {}" + e.getMessage());
            }
        }
    }
}
