package parameter;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameter {
	@Test
	public void creareProjectUsingFormParameter() {
		//Pre conditions
		baseURI="http://localhost";
		port=8084;
		
		given()
		.formParam("createdBy", "Aishwarya")
		.formParam("projectName", "BMTC")
		.formParam("status", "Created")
		.formParam("teamSize", 1)
		.contentType(ContentType.JSON)
		
		//action
		.when()
		.post("/addProject")
		
		//validation
		.then().log().all();
	}

}
