package jiraui.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import jiraui.config.Properties;
import jiraui.elements.dashboardLoginElements;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;


import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DashboardLoginSteps extends dashboardLoginElements {
    private static Properties properties = Properties.properties;

    @Step("Выполнить ввод в профиль {login} с вводом пароля")
    @Когда("переданы логин: {string} и пароль: {string}")
    public static void login(String login, String password) {
        if (login.equals("login") & password.equals("password")) {
            login = properties.login();
            password = properties.password();
        }
        loginInput.shouldBe(Condition.visible).setValue(login);
        passwordsInput.shouldBe(Condition.visible).setValue(password);
        loginButtonInput.shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
    }

    @Step("Открыть главную страницу}")
    @Дано("открыта главная страница с полями ввода данных авторизации")
    public static void openMainPage() {
        Selenide.open(properties.baseUrl());
        getWebDriver().manage().window().maximize();
    }
}
