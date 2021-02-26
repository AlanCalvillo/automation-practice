package ui.pageobjects.Google.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchSuggestion extends AbstractComponent {
    public SearchSuggestion(WebDriver browser) {
        super(browser);
    }

    @FindBy(css = "li.sbct")
    private List<WebElement> suggestions;


    public void clickSuggestion(int option){
        this.suggestions.get(option - 1).click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((browser) -> this.suggestions.size() > 1);
    }
}