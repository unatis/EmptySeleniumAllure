package infra.QaDocs;

import infra.Common.Common;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(tagName = "main")
    WebElement mainPage;

    @FindBy(id = "letsbeginwork")
    WebElement letsBeginButton;

    private Common common = null;

    public MainPage(Common commonObj) {
        common = commonObj;
        PageFactory.initElements(common.getDriver(), this);
    }
    @Step("verifyMainPage")
    public void verifyMainPage() {

        try {

            if(!common.isElementPresent(By.tagName("main"))){
                common.Report("Main_Page not found", Common.MessageColor.RED);
            }

        } catch (Exception e) {
            common.Report(e.getMessage(), Common.MessageColor.RED);
        }
    }
    @Step("clickLetsBeginButton")
    public void clickLetsBeginButton() {
        try {

            letsBeginButton.click();

        } catch (Exception e) {
            common.Report(e.getMessage(), Common.MessageColor.RED);
        }
    }

}
