package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.taskCreateWindowElements;
import org.junit.jupiter.api.Assertions;

public class taskCreateWindowSteps extends taskCreateWindowElements {
    private static void _setValueInInput(SelenideElement element, String value) {
        element.shouldBe(Condition.enabled).doubleClick().sendKeys(value);
        Assertions.assertEquals(element.shouldBe(Condition.enabled).getValue(), value);
    }

    public static void _setTextAreaByText(SelenideElement buttonText, SelenideElement textArea, String value) {
        buttonText.shouldBe(Condition.enabled).click();
        textArea.shouldBe(Condition.enabled).click();
        textArea.sendKeys(value);
    }

    public static void setTaskType(String taskType) {
        _setValueInInput(taskTypeInput, taskType);
    }

    public static void setTaskPriority(String taskPriority) {
        _setValueInInput(taskPriorityInput, taskPriority);
    }

    public static void setTags(String tag) {
        tagsInput.shouldBe(Condition.enabled).click();
        tagsInput.sendKeys(tag + " ");
    }

    public static void setTags(String[] tags) {
        tagsInput.shouldBe(Condition.enabled).click();
        for (String tag : tags) {
            tagsInput.sendKeys(tag + " ");
        }
    }

    public static void clickFixVersionAsVersion_2_0() {
        fixVersionsOptVersion_2_0.shouldBe(Condition.visible).click();
    }

    public static void clickAffectedVersionAsVersion_2_0() {
        affectedVersionsOptVersion_2_0.shouldBe(Condition.visible).click();
    }

    public static void setTopicInput(String topicName) {
        _setValueInInput(topicNameInput, topicName);
    }

    public static void setDescriptionAsText(String description) {
        _setTextAreaByText(descriptionButtonText, descriptionTextArea, description);
    }

    public static void setEnvAsText(String description) {
        _setTextAreaByText(envButtonText, envTextArea, description);
    }

    public static void clickAssignMeAsAssignee() {
        assignMeButton.shouldBe(Condition.enabled).click();
    }

    public static void clickSubmit() {
        submitInput.shouldBe(Condition.enabled).click();
    }
}
