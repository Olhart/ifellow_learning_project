package api.steps;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RickAndMortyAPISteps {
    public static RequestSpecification requestSpecification;

    public static void getRequestSpecification(String baseURL) {
        requestSpecification = given()
                .baseUri(baseURL);
    }

    private static Response getResponse(String endpoint) {
        Response response = requestSpecification
                .when()
                .get(endpoint);
        return response;
    }

    public static JSONObject getCharacterJSON(Integer characterId) {
        Response response = getResponse("character/" + characterId.toString());
        return new JSONObject(response.getBody().asString());
    }

    public static JSONObject getCharacterJSON(String characterId) {
        Response response = getResponse("character/?name=" + characterId);
        return new JSONObject(response.getBody().asString()).getJSONArray("results").getJSONObject(0);
    }

    public static String getCharacterCurrentLocationName(JSONObject CharacterJSON) {
        return CharacterJSON.getJSONObject("location").get("name").toString();
    }

    public static String getCharacterSpecies(JSONObject JSONResBody) {
        return JSONResBody.get("species").toString();
    }

    public static String getLastCharacterIDInEpisode(String locationID) {
        JSONArray characterJSONArray = new JSONObject(getResponse("episode/"+locationID).getBody().asString())
                .getJSONArray("characters");
        return characterJSONArray.get(characterJSONArray.length() - 1).toString().replaceAll("[^0-9]", "");
    }

    public static String getLastEpisodeIDWithCharacter(JSONObject CharacterJSON) {
        JSONArray episodeJSONArray = CharacterJSON.getJSONArray("episode");
        return episodeJSONArray.get(episodeJSONArray.length() - 1).toString().replaceAll("[^0-9]", "");
    }
}
