package api.reqres.steps;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class APISteps {
    static RequestSpecification requestSpecification;

    @Step("Задать спецификацию Rest-assured c базовым URL {baseURL}")
    public static void getRequestSpecification(String baseURL) {
        requestSpecification = given().baseUri(baseURL).contentType("application/json").filter(new AllureRestAssured());
    }

    @Step("Создать нового пользователя POST-запросом с параметрами: {requestParams} и получить ответ")
    public static Response createNewUserAndGetResponce(JSONObject requestParams) {
        Response response = requestSpecification.with().body(requestParams.toString()).when().post("api/users");
        return response;
    }
}
