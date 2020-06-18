package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class XpathTest {

    private WebDriver driver;

    @BeforeSuite
    public void testSuiteSetup() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void test0001() {
        driver.get("https://the-internet.herokuapp.com/login");

        String fullXpath = "/html/body/div[2]/div/div/form/button";

        String relativeXpath = "//form/div[1]/div/div[1]/div/div/input[1]";

        String xpath1 = "//button[@class='radius']";
        String xpath2 = "//button[@class='radius'][@type='submit']";
        String xpath3 = "//button[@class='radius' and @type='submit']";
        String xpath4 = "//button[@class='radius' or @type='submit']";
        String xpath5 = "//button[contains(@class,'adi')]";
        String xpath6 = "//button[starts-with(@class,'rad')]";
        String xpath7 = "//*[text()=' Login']";
        String xpath8 = "//*[@name='username']/following::*[@type='password']";
        String xpath9 = "//*[@name='username']/preceding::*[@type='password']";

        driver.findElement(By.xpath(xpath1));


    }
}
