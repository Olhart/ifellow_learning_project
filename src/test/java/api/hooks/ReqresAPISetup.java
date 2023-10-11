package api.hooks;

import api.steps.ReqresAPISteps;
import org.junit.jupiter.api.BeforeAll;

public class ReqresAPISetup {
    static String baseURL = "https://reqres.in/";

    @BeforeAll
    public static void setRequestSpecification() {
        ReqresAPISteps.getRequestSpecification(baseURL);
    }
}
