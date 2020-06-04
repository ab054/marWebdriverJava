import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    public WebDriver driver;

    public WebElement waitForElement(By expectedElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        WebElement foundedElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(expectedElement));
        return foundedElement;
    }

}
