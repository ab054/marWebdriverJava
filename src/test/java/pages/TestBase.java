package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public WebDriver driver;

    @BeforeSuite
    public void testSuiteSetup() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
    }

    @BeforeMethod
    public void startTestMethod() {
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void finishTestMethod() {
        driver.quit();
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("ALL TESTS ARE FINISHED");
    }

    public WebElement waitForElement(By expectedElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        WebElement foundedElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(expectedElement));
        return foundedElement;
    }
}
