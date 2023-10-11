import api.hooks.ReqresAPISetup;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.equalTo;
import static api.steps.JSONSteps.getJSONObjFromFileWithNewParams;
import static api.steps.ReqresAPISteps.createNewUserAndGetResponce;

public class ReqresAPITest extends ReqresAPISetup {
    final String[][] newParams = {{"name","Tomato"}, {"job","Eat maket"}};

    @Test
    public void Test() throws ParseException {
        JSONObject requestParams = getJSONObjFromFileWithNewParams(newParams);
        Response response = createNewUserAndGetResponce(requestParams);
        response
                .then()
                .assertThat()
                .statusCode(201) // исправил на 201 - при создании возвращает его
                .body(newParams[0][0], equalTo(newParams[0][1]))
                .body(newParams[1][0], equalTo(newParams[1][1]));
        int id = Integer.parseInt(new JSONObject(response.getBody().asString()).get("id").toString());
        Assertions.assertNotNull(id);
        String strDate = new JSONObject(response.getBody().asString()).get("createdAt").toString().trim();

        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse(strDate);
        Assertions.assertTrue(date.before(new Date()));
    }
}