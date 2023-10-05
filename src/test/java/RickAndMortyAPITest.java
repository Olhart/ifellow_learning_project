import hooks.RickAndMortyAPISetup;
import org.checkerframework.checker.index.qual.Positive;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static steps.RickAndMortyAPISteps.*;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class RickAndMortyAPITest extends RickAndMortyAPISetup {

    @Test
    public void compareLocationAndSpeciesTwoCharactersTest() {
        JSONObject CharacterJSON = getCharacterJSON("Morty Smith");
        String CharacterCurrentLocationName = getCharacterCurrentLocationName(CharacterJSON);
        String CharacterSpecies = getCharacterSpecies(CharacterJSON);
        String AnotherCharacterID = getLastCharacterIDInEpisode(getLastEpisodeIDWithCharacter(CharacterJSON));

        given(requestSpecification)
                .when()
                .get("character/"+AnotherCharacterID)
                .then()
                .assertThat()
                .statusCode(200)
                .body("location.name",not(equalTo(CharacterCurrentLocationName))) //Инверсировал условие - локации разные
                .body("species",equalTo(CharacterSpecies));
    }
}
