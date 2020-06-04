import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class GoogleSearchTest extends TestBase {

    private static final String GOOGLE_MAIN_PAGE_URL = "https://www.google.com/";
    private String resultsStatsText;
    private By resultsStatsLocator = By.id("result-stats");
    private By textInputLocator = By.cssSelector(".gLFyf");

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


    @Parameters({"paramKey1"})
    @Test
    public void test0002(String param1) {
        String queryString = param1;

        openMainGooglePage();
        typeAndSubmitQuery(queryString);
        verifyResultsPage();
        verifyAmountOfResults();
    }

    @Test
    public void test0003() {
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
        waitForElement(resultsStatsLocator);
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
