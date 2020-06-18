package pages;

import org.openqa.selenium.WebDriver;

public class GooglePOM {

    public GoogleResultsPage resultsPage;
    public MainGooglePage mainPage;

    public GooglePOM(WebDriver driver) {
        this.resultsPage = new GoogleResultsPage(driver);
        this.mainPage = new MainGooglePage(driver);
    }
}
