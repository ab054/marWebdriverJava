package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class MainGooglePage extends TestBase {

    private static final String GOOGLE_MAIN_PAGE_URL = "https://www.google.com/";
    private By textInputLocator = By.cssSelector(".gLFyf");

    private WebDriver driver;

    public MainGooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(GOOGLE_MAIN_PAGE_URL);
    }

    public void typeAndSubmitQuery(String queryString) {
        WebElement textInput = driver.findElement(textInputLocator);
        textInput.sendKeys(queryString);
        textInput.submit();
    }
}
