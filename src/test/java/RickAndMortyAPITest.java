import api.rickandmorty.hooks.Setup;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.rickandmorty.steps.APISteps.*;
import static api.rickandmorty.steps.AssertSteps.*;
import static api.rickandmorty.steps.ParseJSONSteps.*;


@Epic("API тесты")
@Feature("RickAndMortyAPI тестирование")
@Owner("Ольхов Артем")
public class RickAndMortyAPITest extends Setup {
    final private String mortyID = "2";
    final private int okStatusCode = 200;

    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Раса последнего персонажа из последнего эпизода с Морти совпадает с Морти, место расположение - нет")
    @Description("Сравнение расы и место расположения Морти с последним персонажем из последнего эпизода с Морти")
    @DisplayName("Сравнение локации и расы персонажа1 с последним персонажем2 из последнего эпизода персонажа1")
    public void compareLocationAndSpeciesTwoCharactersTest() {
        JSONObject firstCharJSON = getCharacterJSON(mortyID);

        JSONObject lastEpisodeWithFirstCharJSON = getEpisodeJSON(getLastEpisodeIDWithCharacter(firstCharJSON));
        String secondCharID = getLastCharIDFromEpisode(lastEpisodeWithFirstCharJSON);
        Response secondCharResponse = getCharacterResponse(secondCharID);

        resStatusCodeEqual(secondCharResponse, okStatusCode);
        compareLocation(secondCharResponse, getCharCurrLocationName(firstCharJSON));
        compareSpecies(secondCharResponse, getCharSpecies(firstCharJSON));
    }
}
