package api.base;

import io.restassured.response.Response;

public interface IRestResponse<T> {
    /**
     * @return Body of the response as Generic class
     */
    T getBody();

    /**
     * @return Body of the response as a String
     */
    String getContent();

    /**
     * @return Status code of the response
     */
    int getStatusCode();

    /**
     * @return Check if the response is successful or not
     */
    boolean isSuccessful();

    /**
     * @return Status message of the response
     */
    String getStatusDescription();

    /**
     * @return Response instance
     */
    Response getResponse();
}
