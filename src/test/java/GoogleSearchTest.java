import jdk.nashorn.internal.objects.NativeString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class GoogleSearchTest {

    private static final String GOOGLE_MAIN_PAGE_URL = "https://www.google.com/";
    private WebDriver driver;
    private String resultsStatsText;
    private By resultsStatsLocator = By.id("result-stats");
    private By textInputLocator = By.cssSelector(".gLFyf");

    @BeforeSuite
    public void testSuiteSetup(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/macOS/geckodriver");
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }


    /*
        1. open the google.com webpage
        2. in search box type a query and submit the search
        3. Verify that result page is showing up
        4. Verify that amount of results is more than 100
     */

    //TODO: refactor this to step-by-step format
    @Test
    public void test0001() {
        String queryString = "Portnov Computer School";

        openMainGooglePage();
        typeAndSubmitQuery(queryString);
        verifyResultsPage();
        verifyAmountOfResults();
    }


    @Test
    public void test0002() {
        String queryString = "Portnov School";

        openMainGooglePage();
        typeAndSubmitQuery(queryString);
        verifyResultsPage();
        verifyAmountOfResults();
    }

    private void verifyAmountOfResults() {
        String[] stringArray = resultsStatsText.split(" ");
        String amountOfResults = stringArray[1];
        String amountOfResultsFixed = amountOfResults.replace(",", "");
        int amountOfResultsParsed = Integer.parseInt(amountOfResultsFixed);
        Assert.assertTrue(amountOfResultsParsed > 100);
    }

    private void verifyResultsPage() {
        //TODO: read about try and catch block
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement resultsStatsElement = driver.findElement(resultsStatsLocator);
        resultsStatsText = resultsStatsElement.getText();
        Assert.assertTrue(resultsStatsText.contains("results"));
    }

    private void typeAndSubmitQuery(String queryString) {
        WebElement textInput = driver.findElement(textInputLocator);
        textInput.sendKeys(queryString);
        textInput.submit();
    }

    private void openMainGooglePage() {
        driver.get(GOOGLE_MAIN_PAGE_URL);
    }
}
