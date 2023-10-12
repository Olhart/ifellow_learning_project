package api.rickandmorty.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AssertSteps {
    protected static final Logger logger = LogManager.getLogger(AssertSteps.class);
    @Step("Проверить, что код статус ответа = {expectedStatusCode}")
    public static void resStatusCodeEqual(Response response, int expectedStatusCode){
        response
                .then()
                .assertThat()
                .statusCode(expectedStatusCode);
    }

    @Step("Посмотреть, совпадает ли локация персонажа с {expectedLocationName}")
    public static void compareLocation(Response response, String expectedLocationName){
        try {
            response
                    .then()
                    .assertThat()
                    .body("location.name", equalTo(expectedLocationName));
        }
        catch (AssertionError e) {
            logger.log(Level.INFO, e.toString());
        }
    }

    @Step("Посмотреть, совпадает ли раса персонажа с {expectedSpecies}")
    public static void compareSpecies(Response response, String expectedSpecies){
        try {
            response
                    .then()
                    .assertThat()
                    .body("species", equalTo(expectedSpecies));
        }
        catch (AssertionError e) {
            logger.log(Level.INFO, e.toString());
        }
    }
}
