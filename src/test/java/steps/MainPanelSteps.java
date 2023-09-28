package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import config.Properties;
import elements.mainPanelElements;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class MainPanelSteps extends mainPanelElements {
    private static Properties properties = Properties.properties;


    @Тогда("доступна ссылка на в профиль пользователя")
    public static void checkVisibleUserProfile() {
        Selenide.sleep(3000);
        profileMenuLink.shouldBe(Condition.visible.because("Ссылка на профайл скрыта"), Duration.ofSeconds(10));
    }

    @Дано("выполнен переход в проект {string} через поиск")
    public static void goToTestProject(String projectName) {
        searchInput.shouldBe(Condition.enabled).click();
        searchInput.sendKeys(projectName);
        testProjectLinkInQuickSearchResult.shouldBe(Condition.enabled).click();
        String resultUrl = getWebDriver().getCurrentUrl();
        Assertions.assertTrue(resultUrl.contains(properties.testProjectUrl()));
    }

    @Дано("выполнен переход в картучку задачи {string} с кодом {string} посредством поиск по названию")
    public static void goToTeslSeleniumBugTask(String targetTaskName, String targetTaskCode) {
        searchInput.shouldBe(Condition.enabled).click();
        searchInput.sendKeys(targetTaskName);
        testSeleniumBugLinkInQuickSearchResult.shouldBe(Condition.enabled).click();
        String resultUrl = getWebDriver().getCurrentUrl();
        Assertions.assertTrue(resultUrl.contains(properties.cardTaskPrefixUrl() + targetTaskCode));
    }

    @Дано("на панели меню нажата кнопка \"Создать\", отобразилась форма создания задачи")
    public static void clickOnCreateButton() {
        createButton.shouldBe(Condition.enabled).click();
    }

    public static void logout() {
        profileMenuLink.shouldBe(Condition.enabled).click();
        logoutLink.shouldBe(Condition.enabled).click();
    }
}
