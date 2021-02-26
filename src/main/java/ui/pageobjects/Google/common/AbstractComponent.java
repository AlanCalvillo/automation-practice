package ui.pageobjects.Google.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractComponent {
    public abstract boolean isDisplayed();
    //public abstract void goTo(String site);
    protected WebDriverWait wait;


    public AbstractComponent(final WebDriver browser){
        this.wait = new WebDriverWait(browser,30);
        PageFactory.initElements(browser,this);
    }

}
