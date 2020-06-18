package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.GoogleResultsPage;
import pages.MainGooglePage;
import pages.TestBase;


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

        MainGooglePage mainGooglePage = new MainGooglePage(driver);
        GoogleResultsPage googleResultsPage = new GoogleResultsPage(driver);

        mainGooglePage.open();
        mainGooglePage.typeAndSubmitQuery(queryString);
        googleResultsPage.verifyResultsPage();
        googleResultsPage.verifyAmountOfResults();
    }

    @Parameters({"paramKey1"})
    @Test
    public void test0002(String param1) {
        String queryString = param1;

        MainGooglePage mainGooglePage = new MainGooglePage(driver);
        GoogleResultsPage googleResultsPage = new GoogleResultsPage(driver);

        mainGooglePage.open();
        mainGooglePage.typeAndSubmitQuery(queryString);
        googleResultsPage.verifyResultsPage();
        googleResultsPage.verifyAmountOfResults();
    }

    @Test
    public void test0003() {
        String queryString = "Portnov School";

        MainGooglePage mainGooglePage = new MainGooglePage(driver);
        GoogleResultsPage googleResultsPage = new GoogleResultsPage(driver);

        mainGooglePage.open();
        mainGooglePage.typeAndSubmitQuery(queryString);
        googleResultsPage.verifyResultsPage();
        googleResultsPage.verifyAmountOfResults();
    }
}
