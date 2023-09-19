package Hooks;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class webHooks {
    @BeforeAll
    public static void driverSetup() {
        System.setProperty("chrome_driver", "driver");
        Configuration.startMaximized = true;
        System.out.println("*** webHooks.driverSetup done");
    }
}
