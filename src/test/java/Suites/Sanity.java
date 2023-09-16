package Suites;

import infra.Common.Common;
import infra.Common.Config;
import infra.QaDocs.MainPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;


public class Sanity {
    private static String startURL = "";
    private static Common common = null;

    //To run suites in parallel
    //mvn clean test -Dtest=Suites.Sanity,Suites.Regression
    //in pom set true  junit.jupiter.execution.parallel.enabled=false
    //https://www.youtube.com/watch?v=i2LQh15HP1U&ab_channel=StasPeshkur
    @BeforeAll
    public static void setup(){
        startURL = Config.getProperty("start.url");

        common = new Common();
    }

    @BeforeEach
    public void init(){

        common.LaunchBrowser(Common.Browser.FIREFOX);
    }

    @Test
    void test_1(){

        common.NavigateTo(startURL);

        common.Await(5);

        MainPage mainPage = new MainPage(common);

        mainPage.verifyMainPage();

        mainPage.clickLetsBeginButton();

        common.Await(5);
    }

    @AfterEach
    public void teardown() {

        common.CloseBrowser();
    }

    @AfterAll
    public static void cleanup() {

    }
}
