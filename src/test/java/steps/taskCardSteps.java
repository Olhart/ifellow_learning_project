package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.taskCardElements;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class taskCardSteps extends taskCardElements {

    static void _setTaskStatus(SelenideElement StatusLink, String expectedStatusText) {
        StatusLink.shouldBe(Condition.visible).click();
        Selenide.sleep(3000);
        Assertions.assertEquals(getTaskStatus().toLowerCase(), expectedStatusText.toLowerCase());
    }

    public static void setInWorkTaskStatus() {
        _setTaskStatus(inWorkStatusLink, "В работе");
    }

    public static void setNeedToDoTaskStatus() {
        _setTaskStatus(needToDoStatusLink, "Сделать");
    }

    public static void setResolvedStatusLinkTaskStatus() {
        workFlowBarLink.shouldBe(Condition.enabled).click();
        _setTaskStatus(resolvedStatusLink, "Готово");
    }

    public static String getTaskStatus() {
        String status = taskStatus.shouldBe(Condition.visible, Duration.ofSeconds(2)).getText().trim();
        Assertions.assertNotEquals(status, "");
        return status;
    }

    public static void checkTaskStatus(String expectedStatus) {
        String status = taskStatus.shouldBe(Condition.visible, Duration.ofSeconds(2)).getText().trim();
        Assertions.assertEquals(status.toLowerCase(), expectedStatus.toLowerCase());
    }

    public static void checkFixVersion(String expectedVersion) {
        String status = fixVersionLink.shouldBe(Condition.visible, Duration.ofSeconds(2)).getText().trim();
        Assertions.assertEquals(status.toLowerCase(), expectedVersion.toLowerCase());
    }
}