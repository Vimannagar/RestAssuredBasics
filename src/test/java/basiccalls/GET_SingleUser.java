package basiccalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GET_SingleUser {
	
	
	@Test
	public void getSingleUserDetails()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
	Response resp = given()
		
		.when()
		
		.get("/api/users/2")
		
		.then()
		
		.extract()
		
		.response();
		
	
	String response = resp.asPrettyString();
	
	System.out.println(response);
	}

}
