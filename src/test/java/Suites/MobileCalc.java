package Suites;

import infra.Common.Common;
import infra.Common.Config;
import infra.MobileCalc.FrontWindow;
import org.junit.jupiter.api.*;

public class MobileCalc {
    private static String deviceName = "";
    private static String deviceID = "";
    private static String packageName = "";
    private static String activityName = "";
    private static String platformVersion = "";
    private static Common common = null;

    @BeforeAll
    public static void setup(){

        deviceName = Config.getProperty("mobile.deviceName");
        deviceID = Config.getProperty("mobile.deviceID");
        packageName = Config.getProperty("mobile.app.packageName");
        activityName = Config.getProperty("mobile.app.activityName");
        platformVersion = Config.getProperty("mobile.app.platformVersion");

        common = new Common();

        common.LaunchEmulator(deviceName, deviceID);//cmd adb devices
        common.Await(80);
    }

    @BeforeEach
    public void init(){
        common.LaunchApp(packageName, activityName, deviceName, deviceID, platformVersion);
        common.Await(25);
    }

    @Test
    void mobilCalcTest(){

        FrontWindow frontWindow = new FrontWindow(common);

        frontWindow.clickNumber_2_Button();

        frontWindow.clickPlusButton();

        frontWindow.clickNumber_3_Button();

        frontWindow.clickEqualsButton();

        common.await(2);

        frontWindow.verifyResultText("5");
    }

    @AfterEach
    public void teardown() {
        common.closeApp();
    }

    @AfterAll
    public static void cleanup() {
        common.stopEmulator(deviceID);
    }
}
