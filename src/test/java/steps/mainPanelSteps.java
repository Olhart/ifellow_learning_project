package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import elements.mainPanelElements;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class mainPanelSteps extends mainPanelElements {
    public static void checkVisibleUserProfile() {
        Selenide.sleep(3000);
        profileMenuLink.shouldBe(Condition.visible.because("Ссылка на профайл скрыта"), Duration.ofSeconds(5));
    }

    public static void goToTestProject() {
        String expectedPrefixLink = "https://edujira.ifellow.ru/projects/TEST/issues";
        searchInput.shouldBe(Condition.enabled).click();
        searchInput.sendKeys("Test");
        testProjectLinkInQuickSearchResult.shouldBe(Condition.enabled).click();
        String resultUrl = getWebDriver().getCurrentUrl();
        Assertions.assertTrue(resultUrl.contains(expectedPrefixLink));
    }

    public static void goToTeslSeleniumBugTask() {
        String expectedPrefixLink = "https://edujira.ifellow.ru/browse/TEST-21967";
        searchInput.shouldBe(Condition.enabled).click();
        searchInput.sendKeys("TestSelenium bug");
        testSeleniumBugLinkInQuickSearchResult.shouldBe(Condition.enabled).click();
        String resultUrl = getWebDriver().getCurrentUrl();
        Assertions.assertTrue(resultUrl.contains(expectedPrefixLink));
    }

    public static void clickOnCreateButton() {
        createButton.shouldBe(Condition.enabled).click();
    }
}
