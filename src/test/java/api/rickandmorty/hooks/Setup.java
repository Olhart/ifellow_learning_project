package api.rickandmorty.hooks;

import api.rickandmorty.config.Properties;
import api.rickandmorty.steps.APISteps;
import org.junit.jupiter.api.BeforeAll;

public class Setup {
    private static Properties properties = Properties.properties;

    @BeforeAll
    public static void setRequestSpecification() {
        APISteps.setRequestSpecification(properties.baseURL());
    }
}
