package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.CommonSteps;
import utils.TestBase;

public class GoogleResultsPage extends TestBase {
    private WebDriver driver;

    private String resultsStatsText;
    private By resultsStatsLocator = By.id("result-stats");

    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyResultsPage() {
        CommonSteps.waitForElement(driver, resultsStatsLocator);
        WebElement resultsStatsElement = driver.findElement(resultsStatsLocator);
        resultsStatsText = resultsStatsElement.getText();
        Assert.assertTrue(resultsStatsText.contains("results"));
    }

    public void verifyAmountOfResults() {
        String[] stringArray = resultsStatsText.split(" ");
        String amountOfResults = stringArray[1];
        String amountOfResultsFixed = amountOfResults.replace(",", "");
        int amountOfResultsParsed = Integer.parseInt(amountOfResultsFixed);
        Assert.assertTrue(amountOfResultsParsed > 100);
    }
}
