package jiraui.config;

import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;
import org.aeonbits.owner.Config;

@Config.Sources({
        "file:src/test/resources/properties/jiraui.properties"
})
public interface Properties extends Reloadable {
    Properties properties = ConfigFactory.create(Properties.class);

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("base.url")
    String baseUrl();

    @Key("test.project.url")
    String testProjectUrl();

    @Key("card.task.prefix.url")
    String cardTaskPrefixUrl();

    @Key("chromedriver")
    String chromeDriver();
}