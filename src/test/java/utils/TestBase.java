package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.GooglePOM;

public class TestBase {

    public WebDriver driver;
    public GooglePOM google;

    @BeforeSuite
    public void testSuiteSetup() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
    }

    @BeforeMethod
    public void startTestMethod() {
        driver = new FirefoxDriver();
        initGooglePages(driver);
    }

    private void initGooglePages(WebDriver driver) {
        google = new GooglePOM(driver);
    }

    @AfterMethod
    public void finishTestMethod() {
        driver.quit();
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("ALL TESTS ARE FINISHED");
    }
}
