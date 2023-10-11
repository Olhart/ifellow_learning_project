package jiraui.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import jiraui.config.Properties;
import jiraui.elements.mainPanelElements;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class MainPanelSteps extends mainPanelElements {
    private static Properties properties = Properties.properties;

    @Step("Проверить, что доступен пользовательский профиль")
    @Тогда("доступна ссылка на в профиль пользователя")
    public static void checkVisibleUserProfile() {
        Selenide.sleep(3000);
        profileMenuLink.shouldBe(Condition.visible.because("Ссылка на профайл скрыта"), Duration.ofSeconds(10));
    }

    @Step("Перейти в проект {projectName} через поиск на главной панели")
    @Дано("выполнен переход в проект {string} через поиск")
    public static void goToTestProject(String projectName) {
        searchInput.shouldBe(Condition.enabled).click();
        searchInput.sendKeys(projectName);
        testProjectLinkInQuickSearchResult.shouldBe(Condition.enabled).click();
        String resultUrl = getWebDriver().getCurrentUrl();
        Assertions.assertTrue(resultUrl.contains(properties.testProjectUrl()));
    }

    @Step("Перейти в на страницу задачи {targetTaskName} через поиск на главной панелию")
    @Дано("выполнен переход в картучку задачи {string} с кодом {string} посредством поиск по названию")
    public static void goToTeslSeleniumBugTask(String targetTaskName, String targetTaskCode) {
        searchInput.shouldBe(Condition.enabled).click();
        searchInput.sendKeys(targetTaskName);
        testSeleniumBugLinkInQuickSearchResult.shouldBe(Condition.enabled).click();
        String resultUrl = getWebDriver().getCurrentUrl();
        Assertions.assertTrue(resultUrl.contains(properties.cardTaskPrefixUrl() + targetTaskCode));
    }

    @Step("На панели меню нажать кнопку \"Создать\"")
    @Дано("на панели меню нажата кнопка \"Создать\", отобразилась форма создания задачи")
    public static void clickOnCreateButton() {
        createButton.shouldBe(Condition.enabled).click();
    }

    @Step("Выйти из профиля через меню профиля")
    public static void logout() {
        profileMenuLink.shouldBe(Condition.enabled).click();
        logoutLink.shouldBe(Condition.enabled).click();
    }
}
