package ui.pageobjects.Google.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ui.pageobjects.Google.common.AbstractComponent;
import ui.pageobjects.Google.common.SearchComponent;
import ui.pageobjects.Google.common.SearchSuggestion;

public class GoogleResultPage {
    private SearchSuggestion searchSuggestion;
    private SearchComponent searchComponent;
    private NavigationBar navigationBar;
    private ResultStat resultStat;

    public GoogleResultPage(WebDriver browser) {
        this.searchComponent = new SearchComponent(browser);
        this.searchSuggestion = new SearchSuggestion(browser);
        this.navigationBar = new NavigationBar(browser);
        this.resultStat  = new ResultStat(browser);
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public ResultStat getResultStat() {
        return resultStat;
    }
}
