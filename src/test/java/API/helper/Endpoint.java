package API.helper;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Endpoint {

    public static final String HOST_GOREST = "https://gorest.co.in/public/v2/";
    public static final String GET_LIST_USERS = HOST_GOREST + "users";

    public static RequestSpecification setupRequest(){
        return RestAssured.given()
                .baseUri(HOST_GOREST)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 11a784aacb967ef537317a1e0f4a9a2976d7033069eac7a424021593dbc97176");
    }
}
