package AutomationTest.vedlogic.api;

import AutomationTest.vedlogic.config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class ReqResClient {
	
	
    public ReqResClient() {
        RestAssured.baseURI = ConfigReader.get("apiBaseUrl");
    }

//    public Response getUser(int userId) {
//        return RestAssured.given()
//        		.header("x-api-key", ConfigReader.get("apikey"))
//                .contentType(ContentType.JSON)
//                .when()
//                .get("/api/users/" + userId)
//                .then()
//                .extract()
//                .response();
//    }
//
//    public Response listUsers(int page) {
//        return RestAssured.given()
//        		.header("x-api-key", ConfigReader.get("apikey"))
//                .contentType(ContentType.JSON)
//                .queryParam("page", page)
//                .when()
//                .get("/api/users")
//                .then()
//                .extract()
//                .response();
//    }
//
//    public Response createUser(String name, String job) {
//        Map<String, Object> requestBody = new HashMap<>();
//        requestBody.put("name", name);
//        requestBody.put("job", job);
//
//        return RestAssured.given()
//        		.header("x-api-key", ConfigReader.get("apikey"))
//                .contentType(ContentType.JSON)
//                .body(requestBody)
//                .when()
//                .post("/api/users")
//                .then()
//                .extract()
//                .response();
//    }
//
//    public Response deleteUser(int userId) {
//        return RestAssured.given()
//        		.header("x-api-key", ConfigReader.get("apikey"))
//                .contentType(ContentType.JSON)
//                .when()
//                .delete("/api/users/" + userId)
//                .then()
//                .extract()
//                .response();
//    }
    

    public RequestSpecification getRequest() {
    	return RestAssured.given()
            .header("x-api-key", ConfigReader.get("apikey"))
            .contentType(ContentType.JSON);
    }
    

	public Response getUser(int userId) {
	    return getRequest()
	            .when()
	            .get("/api/users/" + userId)
	            .then()
	            .extract()
	            .response();
	}
	
	public Response listUsers(int page) {
	    return getRequest()
	            .queryParam("page", page)
	            .when()
	            .get("/api/users")
	            .then()
	            .extract()
	            .response();
	}
	
	public Response createUser(String name, String job) {
	    Map<String, Object> requestBody = new HashMap<>();
	    requestBody.put("name", name);
	    requestBody.put("job", job);
	
	    return getRequest()
	            .body(requestBody)
	            .when()
	            .post("/api/users")
	            .then()
	            .extract()
	            .response();
	}
	
	public Response deleteUser(int userId) {
	    return getRequest()
	            .when()
	            .delete("/api/users/" + userId)
	            .then()
	            .extract()
	            .response();
	}


}