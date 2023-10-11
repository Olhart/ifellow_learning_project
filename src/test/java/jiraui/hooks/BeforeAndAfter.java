package jiraui.hooks;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import jiraui.config.Properties;
import jiraui.steps.DashboardLoginSteps;
import jiraui.steps.MainPanelSteps;


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

    @Before
    public void allureSubTreadParallel() {
        String listenerName = "AllureSelenide";

        if (!(SelenideLogger.hasListener(listenerName))) {
            SelenideLogger.addListener(listenerName,
                    (new AllureSelenide().screenshots(true).savePageSource(false)));
        }
    }
}
