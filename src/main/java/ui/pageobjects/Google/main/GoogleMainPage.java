package ui.pageobjects.Google.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ui.pageobjects.Google.common.AbstractComponent;
import ui.pageobjects.Google.common.SearchComponent;
import ui.pageobjects.Google.common.SearchSuggestion;

public class GoogleMainPage {
    private WebDriver browser;
    private SearchComponent searchBar;
    private SearchSuggestion searchSuggestion;

    public GoogleMainPage(WebDriver browser){
        this.browser = browser;
        this.searchBar = new SearchComponent(browser);
        this.searchSuggestion = new SearchSuggestion(browser);
    }

    public void goTo(){
        this.browser.navigate().to("https://www.google.com/");
    }

    public SearchComponent getSearchBar() {
        return searchBar;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }
}
