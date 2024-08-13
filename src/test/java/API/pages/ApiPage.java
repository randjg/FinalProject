package API.pages;

import API.helper.Endpoint;
import API.helper.Models.User;
import io.restassured.response.Response;

public class ApiPage {

    public Response createUser(User user){
        return Endpoint.setupRequest()
                .body(user)
                .post("/users");
    }

    public Response getUserById(int userID){
        return Endpoint.setupRequest()
                .get("/users/" + userID);
    }

    public Response getUserByName(String userName){
        return Endpoint.setupRequest()
                .get("/users/" + userName);
    }
}
