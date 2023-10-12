package api.reqres.steps;

import io.qameta.allure.Step;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;

import static api.reqres.utils.DataParser.parseDataFromString;

public class ParseJSONSteps {

    @Step("Получаем JSON объект из файла {fileName}")
    public static JSONObject getJSONObjFromFile(String fileName) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get("src", "test", "resources", fileName)));
        JSONObject jsonObject = new JSONObject(text);
        return jsonObject;
    }

    @Step("Парсим дату из ответа (JSON)")
    public static Date parseDateFromJSON(JSONObject jsonObject) throws ParseException {
        String strDate = jsonObject.get("createdAt").toString().trim();
        return parseDataFromString(strDate);
    }

    @Step("Парсим ID из ответа (JSON)")
    public static int parseIDFromJSON(JSONObject jsonObject) {
        return Integer.parseInt(jsonObject.get("id").toString());
    }
}
