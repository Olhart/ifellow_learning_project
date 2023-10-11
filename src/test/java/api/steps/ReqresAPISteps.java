package api.steps;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class ReqresAPISteps {
    static RequestSpecification requestSpecification;

    public static void getRequestSpecification(String baseURL) {
        requestSpecification = given()
                .baseUri(baseURL)
                .contentType("application/json");
    }

    public static Response createNewUserAndGetResponce(JSONObject requestParams){
        Response response = requestSpecification
                .with()
                .body(requestParams.toString())
                .when()
                .post("api/users");
        return response;
    }
}
