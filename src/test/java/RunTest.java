import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"jiraui/steps", "jiraui/hooks"},
        plugin={"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
        "json:target/cucumber,json",
        "html:test-output"}
//        tags = "@debug"
)

@Epic("Тестирование вебсервиса Jira edujira.ifellow.ru")
@Feature("Тестирование страницы проекта")
public class RunTest {
}
