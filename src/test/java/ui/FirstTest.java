package ui;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.drivers.Browsers;
import ui.drivers.DriverFactory;
import ui.pageobjects.Google.main.GoogleMainPage;
import ui.pageobjects.Google.result.GoogleResultPage;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    WebDriver browser;
    GoogleMainPage mainPage;
    GoogleResultPage resultPage;
    @BeforeTest
    public void setup(){
        browser = DriverFactory.getDriver(Browsers.CHROME);
        browser.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        browser.manage().window().maximize();
    }
    @BeforeClass
    public void getPagesReady(){
        mainPage = new GoogleMainPage(browser);
        resultPage = new GoogleResultPage(browser);
    }

    @Test(dataProvider = "getData")
    public void allTogether(String company, int option){

        mainPage.goTo();
        Assert.assertTrue(mainPage.getSearchBar().isDisplayed());

        mainPage.getSearchBar().enter(company);
        Assert.assertTrue(mainPage.getSearchSuggestion().isDisplayed());

        mainPage.getSearchSuggestion().clickSuggestion(option);
        Assert.assertTrue(resultPage.getNavigationBar().isDisplayed());

        resultPage.getSearchComponent().enter(company);
        Assert.assertTrue(resultPage.getSearchSuggestion().isDisplayed());

        resultPage.getSearchSuggestion().clickSuggestion(option);

        resultPage.getNavigationBar().goToNews();

        System.out.println(
                resultPage.getResultStat().getStat()
        );
    }
    @DataProvider
    public Object [][] getData(){
        return new Object[][]{
                {"Luxoft",2},
                {"Digital On Us",1}
        };
    }

    @AfterTest
    public void tearDown(){
        if (browser != null) {
            browser.quit();
        }
    }
}
