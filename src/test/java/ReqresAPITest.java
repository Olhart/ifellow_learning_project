import api.reqres.config.Properties;
import api.reqres.hooks.Setup;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;

import static api.reqres.steps.APISteps.createNewUserAndGetResponce;
import static api.reqres.steps.AssertSteps.*;
import static api.reqres.steps.ParseJSONSteps.*;


@Epic("API тесты")
@Feature("RegresAPI тестирование")
@Owner("Ольхов Артем")
public class ReqresAPITest extends Setup {
    final private int statusCode201 = 201;
    final private String inspectedParamNameName = "name";
    final private String paramNameValue = "Tomato";
    final private String inspectedParamJobName = "job";
    final private String paramJobValue = "Eat maket";
    private static Properties properties = Properties.properties;

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Успешное создание нового пользователя, сервер возвращает валидные данные")
    @Description("Создаем нового пользователя отправкой POST запроса с измененными данными, прочитанных из файла, и " + "проверяем валидность возвращенных данных")
    @DisplayName("Проверка валидности возвращенных с сервера данных")
    public void Test() throws ParseException, IOException {
        JSONObject requestParams = getJSONObjFromFile(properties.jsonFileName());
        requestParams.put(inspectedParamNameName, paramNameValue).put(inspectedParamJobName, paramJobValue);

        Response response = createNewUserAndGetResponce(requestParams);

        resStatusCodeEqual(response, statusCode201);
        checkParam(response, inspectedParamNameName, requestParams.get(inspectedParamNameName).toString());
        checkParam(response, inspectedParamJobName, requestParams.get(inspectedParamJobName).toString());

        JSONObject responseJSON = new JSONObject(response.getBody().asString());

        checkValidID(parseIDFromJSON(responseJSON));
        checkValidCreateAt(parseDateFromJSON(responseJSON));
    }
}