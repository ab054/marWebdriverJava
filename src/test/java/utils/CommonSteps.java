package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonSteps {

    public static WebElement waitForElement(WebDriver driver, By expectedElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        WebElement foundedElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(expectedElement));
        return foundedElement;
    }

}
