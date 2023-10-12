package api.reqres.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.Date;

import static org.hamcrest.Matchers.equalTo;


public class AssertSteps {
    protected static final Logger logger = LogManager.getLogger(AssertSteps.class);
    @Step("Проверить, что код статус ответа = {expectedStatusCode}")
    public static void resStatusCodeEqual(Response response, int expectedStatusCode){
        response
                .then()
                .assertThat()
                .statusCode(expectedStatusCode);
    }

    @Step("Проверить, совпадает ли в ответе параметр {paramName} со значением {expectedValue}")
    public static void checkParam(Response response, String paramName, String expectedValue){
            response
                    .then()
                    .assertThat()
                    .body(paramName, equalTo(expectedValue));
    }

    @Step("Проверить корректность значение параметра \"createdAt\" в теле ответа")
    public static void checkValidCreateAt(Date date) {
        Assertions.assertTrue(date.before(new Date()));
    }

    @Step("Проверить корректность значение параметра \"id\" в теле ответа")
    public static void checkValidID(int id) {
        Assertions.assertNotNull(id);
    }
}
