package ui.pageobjects.Google.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pageobjects.Google.common.AbstractComponent;

public class ResultStat extends AbstractComponent {
    public ResultStat(WebDriver browser) {
        super(browser);
    }
    @FindBy(id = "result-stats")
    private WebElement stat;

    public String getStat(){
        return this.stat.getText();
    }
    @Override
    public boolean isDisplayed() {
        return this.wait.until((browser) -> this.stat.isDisplayed());
    }
}
