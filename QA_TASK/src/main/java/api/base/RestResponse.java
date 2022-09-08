package api.base;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class RestResponse<T> implements IRestResponse<T> {

    private final T data;
    private final Response response;
    private final ObjectMapper mapper = new ObjectMapper();

    public RestResponse(TypeReference<T> t, Response response) {
        this.response = response;
        try{
            this.data = mapper.convertValue(response.getBody().as(JsonNode.class), t);
        }catch (Exception e){
            throw new RuntimeException("There should be a default constructor in the Response POJO");
        }
    }

    @Override
    public T getBody() {
        return data;
    }

    @Override
    public String getContent() {
        return response.getBody().asString();
    }

    @Override
    public int getStatusCode() {
        return response.getStatusCode();
    }

    @Override
    public boolean isSuccessful() {
        int code = response.getStatusCode();
        return code == 200 || code == 201 || code == 202 || code == 203 || code == 204 || code == 205;
    }

    @Override
    public String getStatusDescription() {
        return response.getStatusLine();
    }

    @Override
    public Response getResponse() {
        return response;
    }
}
