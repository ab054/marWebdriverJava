package uitests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
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
        google.resultsPage.verifyAmountOfResults();
    }

    @Parameters({"paramKey1"})
    @Test
    public void test0002(String param1) {
        String queryString = param1;

        google.mainPage.open();
        google.mainPage.typeAndSubmitQuery(queryString);
        google.resultsPage.verifyResultsPage();
        google.resultsPage.verifyAmountOfResults();
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
