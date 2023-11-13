package api.endpoints;
import static  io.restassured.RestAssured.*;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response createUser(User Payload)
	{
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(Payload)
		.when()
		.post(Routes.post_user);
		
		return response;
		
	}

	
	public static Response readUser(String userName)
	{
		Response response =given()
		.pathParam("username", userName)
		.when()
		.get(Routes.get_user);
		
		return response;
		
	}
	
	public static Response updateUser(String userName, User Payload)
	{
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(Payload)
		.when()
		.put(Routes.update_user);
		
		return response;
		
	}
	
	public static Response deleteUser(String userName)
	{
		Response response =given()
		.pathParam("username", userName)
		.when()
		.delete(Routes.delete_user);
		
		return response;
		
	}
}
