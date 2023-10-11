package api.hooks;

import api.steps.RickAndMortyAPISteps;
import org.junit.jupiter.api.BeforeAll;

public class RickAndMortyAPISetup {
    static String baseURL = "https://rickandmortyapi.com/api";

    @BeforeAll
    public static void setRequestSpecification() {
        RickAndMortyAPISteps.getRequestSpecification(baseURL);
    }
}
