package basiccalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LogWhenValidationFails {
	
	@Test
	public void getListOfUsers()
	{
		RestAssured.baseURI = "https://reqres.in";
		
Response resp = given()
				
				.log().ifValidationFails()
				
				.when()
		
				.get("api/users?page=2")
		
				.then()
				
				.log().ifValidationFails()
				
				.assertThat()
				
				.statusCode(200)
				
				
		
				.extract()
		
				.response();

		
		
	}

}
