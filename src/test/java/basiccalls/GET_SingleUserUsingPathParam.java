package basiccalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_SingleUserUsingPathParam {
	
	@Test
	public void getSingleUserDetails()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
	Response resp = given()
			
			.pathParam("keyofpathparam", "2")
		
		.when()
		
		.get("/api/users/{keyofpathparam}")
		
		.then()
		
		.extract()
		
		.response();
		
	
	String response = resp.asPrettyString();
	
	System.out.println(response);
	}


}
