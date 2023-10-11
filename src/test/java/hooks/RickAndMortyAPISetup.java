package hooks;

import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import static steps.RickAndMortyAPISteps.getRequestSpecification;

public class RickAndMortyAPISetup {
    static String baseURL = "https://rickandmortyapi.com/api";

    @BeforeAll
    public static void setRequestSpecification() {
        getRequestSpecification(baseURL);
    }
}
