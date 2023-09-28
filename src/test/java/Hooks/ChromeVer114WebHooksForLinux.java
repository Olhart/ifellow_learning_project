package Hooks;

import config.Properties;

public class ChromeVer114WebHooksForLinux {
    private static Properties properties = Properties.properties;

    public static void driverSetup() {

//        System.setProperty("webdriver.chrome.driver", properties.chromeDriver());
        System.setProperty("selenide.browser","chrome");
    }
}
