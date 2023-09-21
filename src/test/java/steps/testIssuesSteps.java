package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import elements.testIssuesElements;
import org.junit.jupiter.api.Assertions;

public class testIssuesSteps extends testIssuesElements {
    public static int getNumberOfTasks() {
        String strWithNumberOfTask = numbersOfTasks.shouldBe(Condition.visible).getText();
        String[] arrayWithNumberOfTask = strWithNumberOfTask.trim().split(" ");
        int numberOfTask = Integer.parseInt(arrayWithNumberOfTask[arrayWithNumberOfTask.length - 1]);
        Assertions.assertTrue(numberOfTask > 0);
        return numberOfTask;
    }

    public static void goToMyLastOpenTask() {
        Selenide.open("https://edujira.ifellow.ru/projects/TEST/issues?filter=myopenissues");
        myFirstOpenTaskLink.shouldBe(Condition.enabled).click();
    }
}
