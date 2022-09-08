package api.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


public class JsonParser {

    private static final String CONFIG_PATH = "src/main/resources/config.json";
    public static String getData(String type, String property)  {
        JSONParser jsonParser = new JSONParser();
        String result = "";
        try (FileReader reader = new FileReader(CONFIG_PATH))
        {
            Object obj = jsonParser.parse(reader);
            JSONObject gm = (JSONObject) obj;
            result = (String)gm.get(property);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
