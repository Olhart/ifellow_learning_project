package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class dashboardLogInElements {
    public static SelenideElement loginInput = $x("//input[@id='login-form-username']");
    public static SelenideElement passwordsInput = $x("//input[@id='login-form-password']");
    public static SelenideElement logInButtonInput = $x("//input[@id='login']");
}
