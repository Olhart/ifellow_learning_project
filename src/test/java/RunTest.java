import com.codeborne.selenide.Selenide;
import contrib.beforeAndAfter;
import org.junit.jupiter.api.Test;
import steps.mainPanelSteps;
import steps.taskCardSteps;
import steps.taskCreateWindowSteps;
import steps.testIssuesSteps;


public class RunTest extends beforeAndAfter {

    @Test
    public void numberOfActiveTaskInProjectTestTest() {
        mainPanelSteps.goToTestProject();
        int numberOfActiveTask = testIssuesSteps.getNumberOfTasks();
        System.out.println(numberOfActiveTask);
    }

    @Test
    public void TaskStatusAndVersionTest() {
        mainPanelSteps.goToTeslSeleniumBugTask();
        taskCardSteps.checkTaskStatus("Сделать");
        taskCardSteps.checkFixVersion("Version 2.0");
    }

    @Test
    public void createTaskTest() {
        Selenide.open("https://edujira.ifellow.ru/projects/TEST");
        mainPanelSteps.clickOnCreateButton();
        taskCreateWindowSteps.setTaskType("Ошибка");
        taskCreateWindowSteps.setTopicInput("Live is bug");
        taskCreateWindowSteps.clickFixVersionAsVersion_2_0();
        taskCreateWindowSteps.setTaskPriority("Highest");

        String[] tags = {"QA_practice", "QA_school"};
        taskCreateWindowSteps.setTags(tags);

        String description = "Задача создана автоматически";
        taskCreateWindowSteps.setDescriptionAsText(description);

        String env = "OS: Debian GNU/Linux 11 (bullseye)\nBrowser: Chrome ver. 114";
        taskCreateWindowSteps.setEnvAsText(env);
        taskCreateWindowSteps.clickAffectedVersionAsVersion_2_0();
        taskCreateWindowSteps.clickAssignMeAsAssignee();

        taskCreateWindowSteps.clickSubmit();

    }

    @Test
    public void changeTaskStatusTest() {
        testIssuesSteps.goToMyLastOpenTask();
        taskCardSteps.setNeedToDoTaskStatus();
        taskCardSteps.setInWorkTaskStatus();
        taskCardSteps.setResolvedStatusLinkTaskStatus();
    }
}
