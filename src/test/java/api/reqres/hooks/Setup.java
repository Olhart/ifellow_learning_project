package api.reqres.hooks;

import api.reqres.config.Properties;
import api.reqres.steps.APISteps;
import org.junit.jupiter.api.BeforeAll;

public class Setup {
    private static Properties properties = Properties.properties;

    @BeforeAll
    public static void setRequestSpecification() {
        APISteps.getRequestSpecification(properties.baseURL());
    }
}
