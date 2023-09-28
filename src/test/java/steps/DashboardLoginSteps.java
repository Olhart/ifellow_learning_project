package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import config.Properties;
import elements.dashboardLoginElements;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;


import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DashboardLoginSteps extends dashboardLoginElements {
    private static Properties properties = Properties.properties;

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

    @Дано("открыта главная страница с полями ввода данных авторизации")
    public static void openMainPage() {
        Selenide.open(properties.baseUrl());
        getWebDriver().manage().window().maximize();
    }
}
