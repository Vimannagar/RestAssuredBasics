package fetchingdatafromresponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Question6ForReadymadeJSON {

	@Test
	public void validatePriceWithTotal() {
		String json = "{\r\n" + "\"dashboard\": {\r\n" + "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"www.abc.com\"\r\n" + "},\r\n" + "\"courses\": [\r\n" + "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n" + "\"price\": 50,\r\n" + "\"copies\": 6\r\n" + "},\r\n"
				+ "{\r\n" + "\"title\": \"Cypress\",\r\n" + "\"price\": 40,\r\n" + "\"copies\": 4\r\n" + "},\r\n"
				+ "{\r\n" + "\"title\": \"RPA\",\r\n" + "\"price\": 45,\r\n" + "\"copies\": 10\r\n" + "}\r\n" + "]\r\n"
				+ "}";
		int sum = 0;
		JsonPath jp = new JsonPath(json);

		int totalCourses = jp.getInt("courses.size()");

		for (int i = 0; i < totalCourses; i++) {
			int priceValue = jp.getInt("courses[" + i + "].price");
			int copiesValue = jp.getInt("courses[" + i + "].copies");

			sum = sum + priceValue * copiesValue;
		}

		System.out.println("Total sum value is " + sum);

		int purchaseAmount = jp.getInt("dashboard.purchaseAmount");

		Assert.assertEquals(sum, purchaseAmount);

	}

}
