package hooks;

import org.junit.jupiter.api.BeforeAll;
import static steps.ReqresAPISteps.getRequestSpecification;

public class ReqresAPISetup {
    static String baseURL = "https://reqres.in/";

    @BeforeAll
    public static void setRequestSpecification() {
        getRequestSpecification(baseURL);
    }
}
