package api.rickandmorty.steps;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class APISteps {
    public static RequestSpecification requestSpecification;

    @Step("Задать спецификацию Rest-assured c базовым URL {baseURL}")
    public static void setRequestSpecification(String baseURL) {
        requestSpecification = given().baseUri(baseURL).filter(new AllureRestAssured());
    }

    @Step("Получить ответ из GET запроса на базовый URL с суффиксом {endpoint}")
    public static Response getResponseFromGetRequest(String endpoint) {
        return requestSpecification.when().get(endpoint);
    }

    @Step("Получить ответ из GET запроса на базовый URL с суффиксом {endpoint}")
    public static Response getCharacterResponse(String characterID) {
        return getResponseFromGetRequest("character/" + characterID);
    }

    @Step("Получить тело ответа из GET запроса на базовый URL с суффиксом {endpoint} в формате JSON")
    public static JSONObject getBodyAsJSON(String endpoint) {
        return new JSONObject(getResponseFromGetRequest(endpoint).getBody().asString());
    }

    @Step("Получить информацию о персонаже с ID {characterID} в формате JSON")
    public static JSONObject getCharacterJSON(String characterID) {
        return getBodyAsJSON("character/" + characterID);
    }

    @Step("Получить информацию о эпизоде с ID {episodeID} в формате JSON")
    public static JSONObject getEpisodeJSON(String episodeID) {
        return getBodyAsJSON("episode/" + episodeID);
    }
}