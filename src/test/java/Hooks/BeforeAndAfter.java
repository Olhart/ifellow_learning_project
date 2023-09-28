package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import steps.DashboardLoginSteps;
import steps.MainPanelSteps;
import config.Properties;


public class BeforeAndAfter {
    private static Properties properties = Properties.properties;

    @Before(value = "@login", order = 20)
    public void logIn() {
        DashboardLoginSteps.openMainPage();
        DashboardLoginSteps.login(properties.login(), properties.password());
        MainPanelSteps.checkVisibleUserProfile();
    }
    @After
    public void logout(){
        MainPanelSteps.logout();
        System.out.println("***Logout done***");
    }
    @Before(value = "@webSetUP", order = 10)
    public void webDriverSetUp() {
        ChromeVer114WebHooksForLinux.driverSetup();
    }
}
