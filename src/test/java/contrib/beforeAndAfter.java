package contrib;

import Hooks.chromeVer114WebHooks;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import steps.dashboardLoginSteps;
import steps.mainPanelSteps;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class beforeAndAfter extends chromeVer114WebHooks {
    @BeforeAll
    public static void logIn() {
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
        getWebDriver().manage().window().maximize();
        dashboardLoginSteps.Login("AT2", "Qwerty123");
        mainPanelSteps.checkVisibleUserProfile();
    }
}
