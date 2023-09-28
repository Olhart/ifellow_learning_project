package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import elements.testIssuesElements;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class TestIssuesSteps extends testIssuesElements {
    public static String strNumberOfTask;
    @Когда("получаем строковое представление числа активных задач")
    public static void getNumberOfTasks() {
        String strWithNumberOfTask = numbersOfTasks.shouldBe(Condition.visible).getText();
        String[] arrayWithNumberOfTask = strWithNumberOfTask.trim().split(" ");
        strNumberOfTask = arrayWithNumberOfTask[arrayWithNumberOfTask.length - 1];
    }

    @Тогда("проверям, что это целое положительное число")
    public static void checkNumberOfTask() {
        int numberOfTask = Integer.parseInt(strNumberOfTask);
        Assertions.assertTrue(numberOfTask >= 0);
    }

    @Затем("открыта карточка созданной задачи")
    public static void goToMyLastOpenTask() {
        Selenide.open("https://edujira.ifellow.ru/projects/TEST/issues?filter=myopenissues");
        myFirstOpenTaskLink.shouldBe(Condition.enabled, Duration.ofSeconds(10)).click();
    }
}
