package api.rickandmorty.steps;

import io.qameta.allure.Step;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class ParseJSONSteps {
    @Step("Получить текущее местоположение персонажа из JSON")
    public static String getCharCurrLocationName(JSONObject CharacterJSON) {
        return CharacterJSON.getJSONObject("location").get("name").toString();
    }
    @Step("Получить расу персонажа из JSON")
    public static String getCharSpecies(JSONObject JSONResBody) {
        return JSONResBody.get("species").toString();
    }

    @Step("Получить ID последнего персонажа в эпизоде из JSON")
    public static String getLastCharIDFromEpisode(JSONObject EpisodeJSON) {
        JSONArray characterJSONArray = EpisodeJSON.getJSONArray("characters");
        return characterJSONArray.get(characterJSONArray.length() - 1).toString().replaceAll("[^0-9]", "");
    }

    @Step("Получить ID последнего эпизода, в котором появился персонаж из JSON")
    public static String getLastEpisodeIDWithCharacter(JSONObject CharacterJSON) {
        JSONArray episodeJSONArray = CharacterJSON.getJSONArray("episode");
        return episodeJSONArray.get(episodeJSONArray.length() - 1).toString().replaceAll("[^0-9]", "");
    }
}
