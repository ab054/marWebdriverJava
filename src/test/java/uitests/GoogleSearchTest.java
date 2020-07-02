package uitests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExceptionMessages;
import utils.TestBase;


public class GoogleSearchTest extends TestBase {
    /*
        1. open the google.com webpage
        2. in search box type a query and submit the search
        3. Verify that result page is showing up
        4. Verify that amount of results is more than 100
     */
    @Test
    public void test0001() {
        String queryString = "Portnov Computer School";

        google.mainPage.open();
        google.mainPage.typeAndSubmitQuery(queryString);
        google.resultsPage.verifyResultsPage();
        printPageTitle();
        google.resultsPage.verifyAmountOfResults();

    }

    public void printPageTitle() {
        System.out.println("PAGE TITLE IS : " + driver.getTitle());
    }

    public void printPageTitle(String param) {
        System.out.println("PAGE TITLE IS : " + driver.getTitle() + param);
    }

    //@Parameters({"paramKey1"})
    @Test
    public void test0002() {
        String queryString = "Local Param";

        google.mainPage.open();
        google.mainPage.typeAndSubmitQuery(queryString);
        google.resultsPage.verifyResultsPage();
        google.resultsPage.verifyAmountOfResults();
    }

    @DataProvider(name = "dataForGoogleTest")
    public Object[][] createData1() {
        return new Object[][]{
                {"Portnov Computer School", 100},
                {"Portnov School", 10000000},
                {"Portnov Computer", 10000000}
        };
    }

    @Test(dataProvider = "dataForGoogleTest")
    public void test0003_DataProvider(String parameter1, int parameter2) {
        String searchQuery = parameter1;
        int expectedNumberOfResults = parameter2;

        google.mainPage.open();
        google.mainPage.typeAndSubmitQuery(searchQuery);
        google.resultsPage.verifyResultsPage();

        boolean isAmountOfResultsSufficient = google.resultsPage.getAmountOfResults() > expectedNumberOfResults;
        Assert.assertTrue(isAmountOfResultsSufficient, ExceptionMessages.amountOfResultsError(expectedNumberOfResults));
    }

    @Test
    public void test0003() {
        String queryString = "Portnov School";

        google.mainPage.open();
        google.mainPage.typeAndSubmitQuery(queryString);
        google.resultsPage.verifyResultsPage();
        google.resultsPage.verifyAmountOfResults();
    }
}
