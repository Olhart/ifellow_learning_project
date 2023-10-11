package jiraui.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import jiraui.elements.taskCreateWindowElements;
import io.cucumber.java.ru.И;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class TaskCreateWindowSteps extends taskCreateWindowElements {
    @Step("Кликнуть в поле ввода и напечатать {value}")
    private static void _setValueInInput(SelenideElement element, String value) {
        element.shouldBe(Condition.enabled).doubleClick().sendKeys(value);
        Assertions.assertEquals(element.shouldBe(Condition.enabled).getValue(), value);
    }

    @Step("Кликнуть в поле ввода и напечатать {value}")
    private static void _setTextAreaByText(SelenideElement buttonText, SelenideElement textArea, String value) {
        buttonText.shouldBe(Condition.enabled).click();
        textArea.shouldBe(Condition.enabled).click();
        textArea.sendKeys(value);
    }

    @Step("Установить тип задачи \"{taskType}\"")
    private static void setTaskType(String taskType) {
        _setValueInInput(taskTypeInput, taskType);
    }

    @Step("Установить приоритет \"{taskPriority}\"")
    private static void setTaskPriority(String taskPriority) {
        _setValueInInput(taskPriorityInput, taskPriority);
    }

    @Step("Ввести тег(и) \"{tag}\"")
    private static void setTags(String tag) {
        tagsInput.shouldBe(Condition.enabled).click();
        tagsInput.sendKeys(tag + " ");
    }

    @Step("Ввести тег(и) \"{tags}\"")
    private static void setTags(String[] tags) {
        tagsInput.shouldBe(Condition.enabled).click();
        for (String tag : tags) {
            tagsInput.sendKeys(tag + " ");
        }
    }

    @Step("Выбрать Исправить в версиях \"Version2.0\"")
    private static void clickFixVersionAsVersion_2_0() {
        fixVersionsOptVersion_2_0.shouldBe(Condition.visible).click();
    }

    @Step("Выбрать Затронуты версии \"Version2.0\"")
    private static void clickAffectedVersionAsVersion_2_0() {
        affectedVersionsOptVersion_2_0.shouldBe(Condition.visible).click();
    }

    @Step("Ввести название задачи {topicName}")
    private static void setTopicInput(String topicName) {
        _setValueInInput(topicNameInput, topicName);
    }

    @Step("Ввести описание: \n{description}")
    private static void setDescriptionAsText(String description) {
        _setTextAreaByText(descriptionButtonText, descriptionTextArea, description);
    }

    @Step("Ввести описание jrhe;tybz: \n{description}")
    private static void setEnvAsText(String description) {
        _setTextAreaByText(envButtonText, envTextArea, description);
    }

    @Step("Исполнителем выбрать себя")
    private static void clickAssignMeAsAssignee() {
        assignMeButton.shouldBe(Condition.enabled).click();
    }

    @Step("Нажать кнопку \"Создать\"")
    @И("завершено создание задачи путем нажатия кнопки \"Создать\" внизу окна с формой")
    public static void clickSubmit() {
//        submitInput.shouldBe(Condition.enabled).click();
        cancelButton.shouldBe(Condition.enabled).click();
    }

    @И("заполнена форма")
    public static void fillOutFormOfTask(Map<String, String> kwargs) {

                        setTaskType(kwargs.get("Тип задачи"));

                setTopicInput(kwargs.get("Тема"));


            if (kwargs.get("Исправить в версиях").equals("Version2.0")) {
                clickFixVersionAsVersion_2_0();
            }

            if (kwargs.get("Затронуты версии").equals("Version2.0")) {
                clickAffectedVersionAsVersion_2_0();
            }

            setTaskPriority(kwargs.get("Приоритет"));

            String[] tags = kwargs.get("Метки").split(" ");
            setTags(tags);

            setDescriptionAsText(kwargs.get("Описание"));
            setEnvAsText(kwargs.get("Окружение"));

            if (kwargs.get("Исполнитель").equals("Назначить меня")) {
                clickAssignMeAsAssignee();
            }

    }
}
