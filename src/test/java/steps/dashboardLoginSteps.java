package steps;

import com.codeborne.selenide.Condition;
import elements.dashboardLogInElements;

public class dashboardLoginSteps extends dashboardLogInElements {
    public static void Login(String login, String password) {
        loginInput.shouldBe(Condition.visible).setValue(login);
        passwordsInput.shouldBe(Condition.visible).setValue(password);
        logInButtonInput.shouldBe(Condition.visible).shouldBe(Condition.enabled).doubleClick();
    }


}
