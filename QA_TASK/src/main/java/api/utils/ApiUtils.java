package api.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class ApiUtils {
    private static final String CONFIG_DATA = "config";
    private static RequestSpecification request = given().baseUri(JsonParser.getData(CONFIG_DATA, "url"));

    public static Response getAll(String property) {
        return request.get(JsonParser.getData(CONFIG_DATA, property));
    }

    public static Response getById(String configProp, int id) {
        return request.get(JsonParser.getData(CONFIG_DATA, configProp)
                + "/" + id);
    }

    public static Response post(JSONObject requestParams, String property) {
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        return request.post(JsonParser.getData(CONFIG_DATA, property));
    }

    public static Response put(JSONObject requestParams, String property) {
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        return request.put(JsonParser.getData(CONFIG_DATA, property));
    }

    public static Response patch(JSONObject requestParams, String property) {
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        return request.patch(JsonParser.getData(CONFIG_DATA, property));
    }

    public static Response delete(String configProp, int id) {
        return request.delete(JsonParser.getData(CONFIG_DATA, configProp)
                + "/" + id);
    }
}
