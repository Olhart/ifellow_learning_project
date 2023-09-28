package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.taskCardElements;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class TaskCardSteps extends taskCardElements {
    private static String receivedTaskStatus;
    private static String receivedFixVer;

    static void _setTaskStatus(SelenideElement StatusLink) {
        StatusLink.shouldBe(Condition.enabled, Duration.ofSeconds(10)).click();
        Selenide.sleep(5000);
    }

    @Когда("установили статус задачи \"В работе\"")
    public static void setInWorkTaskStatus() {
        _setTaskStatus(inWorkStatusLink);
    }

    @Когда("установили статус задачи \"Сделать\"")
    public static void setNeedToDoTaskStatus() {
        _setTaskStatus(needToDoStatusLink);
    }

    @Когда("установили статус задачи \"Готово\"")
    public static void setResolvedStatusLinkTaskStatus() {
        workFlowBarLink.shouldBe(Condition.enabled, Duration.ofSeconds(10)).click();
        _setTaskStatus(resolvedStatusLink);
    }

    @Когда("получили статус задачи")
    public static void getTaskStatus() {
        receivedTaskStatus = taskStatus.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText().trim();
        Assertions.assertNotEquals(receivedTaskStatus, "");
    }

    @Тогда("статус задачи отображается {string}")
    public static void checkTaskStatus(String expectedStatus) {
        Assertions.assertEquals(receivedTaskStatus.toLowerCase(), expectedStatus.toLowerCase());
    }

    @Когда("получили статус значения поля \"Исправить в версиях\"")
    public static void getFixVersion() {
        receivedFixVer = fixVersionLink.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText().trim();
    }

    @Тогда("значение поля \"Исправить в версиях\" отображается {string}")
    public static void checkFixVersion(String expectedVersion) {
        Assertions.assertEquals(receivedFixVer.toLowerCase(), expectedVersion.toLowerCase());
    }
}