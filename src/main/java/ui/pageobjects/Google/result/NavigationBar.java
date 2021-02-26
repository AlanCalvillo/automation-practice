package ui.pageobjects.Google.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pageobjects.Google.common.AbstractComponent;

public class NavigationBar extends AbstractComponent {

    public NavigationBar(WebDriver browser) {
        super(browser);
    }
    @FindBy(id = "hdtb")
    private WebElement bar;

    @FindBy(linkText = "Images")
    private WebElement images;

    @FindBy(linkText = "Videos")
    private WebElement videos;

    public void goToImages(){
        this.images.click();
    }

    public void goToNews(){
        this.videos.click();
    }
    @Override
    public boolean isDisplayed() {
        return this.wait.until((browser)-> this.bar.isDisplayed());
    }
}
