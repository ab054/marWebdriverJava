import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static java.lang.Thread.sleep;

public class WindowsHandlesTest {

    private static final String WINDOWS_MAIN_PAGE = "https://the-internet.herokuapp.com/windows";
    WebDriver driver;
    private String originalWindowHandle;
    private String newWindowHandle;

    @BeforeSuite
    public void testSuiteSetup(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/macOS/geckodriver");
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    //1. Open the browser
    //2. Go to "windows" page
    //3. Click on "Click Here" link
    //4. Verify the amount of windows is 2
    //5. Verify new window title
    //6. Verify new window text
    //7. Switch back to original window
    //8. Verify original window title
    @Test
    public void test0001() {
        String expectedNewWindowTitle = "New Window";
        String expectedNewWindowText = "New Window";
        String expectedOriginalWindowTitle = "New Window";
        int expectedAmountOfWindows = 2;

        openWindowsPage();
        clickOnLink();
        verifyAmountOfWindows(expectedAmountOfWindows);
        switchToNewWindow();
        verifyWindowTitle(expectedNewWindowTitle);
        verifyWindowText(expectedNewWindowText);
        switchToOriginalWindow();
        verifyWindowTitle(expectedOriginalWindowTitle);
    }

    //TODO: create a different scenario

    private void switchToNewWindow() {
        driver.switchTo().window(newWindowHandle);
    }

    private void switchToOriginalWindow() {
        driver.switchTo().window(originalWindowHandle);
    }

    private void verifyWindowText(String expectedText) {
        Assert.assertTrue(driver.getPageSource().contains(expectedText));
    }

    private void verifyWindowTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    private void verifyAmountOfWindows(int expectedAmount) {
        //TODO: change this to explicit wait
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<String> windowHandles = driver.getWindowHandles();
        int actualAmountOfHandles = windowHandles.size();
        Assert.assertEquals(actualAmountOfHandles, expectedAmount);

        Object[] arrayOfObjects = windowHandles.toArray();
        Object firstElement = arrayOfObjects[0];
        originalWindowHandle = (String) firstElement;
        newWindowHandle = (String) arrayOfObjects[1];
    }

    private void clickOnLink() {
        //TODO: change this to class attribute
        By expectedElement = By.linkText("Click Here");
        WebElement webElement = waitForElement(expectedElement);
        webElement.click();
    }

    private WebElement waitForElement(By expectedElement) {
       WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
       WebElement foundedElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(expectedElement));
       return foundedElement;
    }

    private void openWindowsPage() {
        driver.get(WINDOWS_MAIN_PAGE);
    }
}
