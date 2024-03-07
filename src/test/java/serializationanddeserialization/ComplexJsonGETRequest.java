package serializationanddeserialization;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.ComplexJsonResponseBody;
import pojo.Data;

public class ComplexJsonGETRequest {

	@Test
	public void getListOfUsers() {
		RestAssured.baseURI = "https://reqres.in";

		ComplexJsonResponseBody responseObject = given()

				.queryParam("page", "2")

				.log().all()

				.when()

				.get("api/users")

				.then()

				.log().all()

				.extract()

				.response().as(ComplexJsonResponseBody.class);

		int pageValue = responseObject.getPage();

		System.out.println(pageValue);

		int totalPages = responseObject.getTotal_pages();

		System.out.println(totalPages);

		List<Data> data = responseObject.getData();

		Data datalist = data.get(1);

		String lastname = datalist.getLast_name();

		System.out.println(lastname);
	}
}
