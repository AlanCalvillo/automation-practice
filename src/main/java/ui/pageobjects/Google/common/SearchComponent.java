package ui.pageobjects.Google.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchComponent extends AbstractComponent {
    public SearchComponent(WebDriver browser) {
        super(browser);
    }

    @FindBy(name = "q")
    private WebElement searchBox;


    public void enter(String text){
        this.searchBox.clear();
        this.searchBox.sendKeys(text);
    }

    @Override
    public boolean isDisplayed() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchBox));
        return this.searchBox.isDisplayed();
    }




}