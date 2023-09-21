package Hooks;

import org.junit.jupiter.api.BeforeAll;


public class chromeVer114WebHooks {
    @BeforeAll
    public static void driverSetup() {
        System.setProperty("chrome_driver", "driver");
//        Configuration.startMaximized = true;
    }
}
