package infra.YoutubeCom;

import infra.Common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(id = "content")
    WebElement mainPage;

    @FindBy(id = "search-icon-legacy")
    WebElement searchButton;

    @FindBy(name = "search_query")
    WebElement searchTexBox;

    private Common common = null;

    public MainPage(Common commonObj) {
        common = commonObj;
        PageFactory.initElements(common.getDriver(), this);
    }

    public void verifyMainPage() {

        try {

            common.isElementPresent(By.id("content"));

        } catch (Exception e) {
            common.Report(e.getMessage(), Common.MessageColor.RED);
        }
    }

    public void clickSearchButton() {
        try {

            searchButton.click();

        } catch (Exception e) {
            common.Report(e.getMessage(), Common.MessageColor.RED);
        }
    }

    public void setSearchText(String searchText) {
        try {
            searchTexBox.clear();
            searchTexBox.sendKeys(searchText);

        } catch (Exception e) {
            common.Report(e.getMessage(), Common.MessageColor.RED);
        }
    }

}
