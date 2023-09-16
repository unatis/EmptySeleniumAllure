package infra.MobileCalc;

import infra.Common.Common;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FrontWindow {

    //Currently page factory can't work with accessibility in Java versions after 8
    @AndroidFindBy(accessibility = "2")//com.google.android.calculator:id/digit_2   //android.widget.ImageButton[@content-desc="2"]
    WebElement number_2_button;

    @AndroidFindBy(accessibility = "3")//com.google.android.calculator:id/digit_3  //android.widget.ImageButton[@content-desc="3"]
    WebElement number_3_button;

    @AndroidFindBy(accessibility = "equals")//com.google.android.calculator:id/eq  //android.widget.ImageButton[@content-desc="equals"]
    WebElement equalsButton3;

    @AndroidFindBy(accessibility = "No formula")//com.google.android.calculator:id/formula //android.widget.EditText[@content-desc="No formula"]
    WebElement textResult;

    private Common common = null;

    WebDriverWait wait;

    public FrontWindow(Common commonObj) {
        common = commonObj;
        PageFactory.initElements(common.getMobileDriver(), this);
        wait = new WebDriverWait(common.getMobileDriver(), Duration.ofSeconds(5));
    }

    public void clickNumber_2_Button() {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("2"))).click();
            //number_2_button.click();

        } catch (Exception e) {
            common.Report(e.getMessage(), Common.MessageColor.RED);
        }
    }

    public void clickNumber_3_Button() {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("3"))).click();
            //number_3_button.click();

        } catch (Exception e) {
            common.Report(e.getMessage(), Common.MessageColor.RED);
        }
    }

    public void clickEqualsButton() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("equals"))).click();
            //equalsButton3.click();

        } catch (Exception e) {
            common.Report(e.getMessage(), Common.MessageColor.RED);
        }
    }

    public void clickPlusButton() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("plus"))).click();
            //equalsButton3.click();

        } catch (Exception e) {
            common.Report(e.getMessage(), Common.MessageColor.RED);
        }
    }

    public void verifyResultText(String expectedResult) {
        try {
            String foundResult = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.calculator:id/result_final"))).getText();

            if(foundResult.equals(expectedResult))
            {
                common.Report("Found result \""+foundResult+"\" is equals to expected \"" + foundResult+"\"");
            }
            else {
                common.Report("Found result \""+foundResult+"\" is Not equals to expected \"" + foundResult+"\"", Common.MessageColor.RED);
            }

        } catch (Exception e) {
            common.Report(e.getMessage(), Common.MessageColor.RED);
        }
    }
}
