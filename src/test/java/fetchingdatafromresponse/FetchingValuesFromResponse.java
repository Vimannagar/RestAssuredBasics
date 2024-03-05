package fetchingdatafromresponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;


public class FetchingValuesFromResponse {
	
	
	@Test
	public void fetchData()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
		Response resp = given()
				
				.when()
		
				.get("api/users?page=2")
		
				.then()
		
				.extract()
		
				.response();

String response = resp.asPrettyString();

System.out.println(response);

// to get the status code of response

int statusCode = resp.statusCode();

System.out.println(statusCode);

Assert.assertEquals(statusCode, 200);

//To get the time required for fetching the response

long timeRequired = resp.getTime();

System.out.println(timeRequired);

//To get the header value from the response 

Headers headersValue = resp.headers();

List<Header> listOfHeaders = headersValue.asList();

System.out.println(listOfHeaders);

String valueOfHeader = resp.getHeader("Content-Type");

System.out.println(valueOfHeader);



		
		
	}

}
