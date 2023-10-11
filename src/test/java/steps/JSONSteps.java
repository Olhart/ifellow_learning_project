package steps;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONSteps {

    public static JSONObject getJSONObjFromFileWithNewParams(String[][] newParams){
        String text;
        try{
            text = new String(Files.readAllBytes(Paths.get("src", "test.json")));
            JSONObject jsonObject = new JSONObject(text);
        }
        catch(IOException ex) {
            text = "";
        }
        JSONObject jsonObject = new JSONObject(text);

        for (String[] param : newParams) {
            jsonObject.put(param[0], param[1]);
        }
        return jsonObject;
    }
}
