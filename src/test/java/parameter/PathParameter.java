package parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	@Test
	public void getSingleProject() {
		//pre requisites
		baseURI="http://localhost";
		port=8084;
		
		given()
		.pathParam("pid", "TY_PROJ_1004")
		
		//Actions
		.when()
		.get("/projects/{pid}")
		
		//validations
		.then()
		.log().all();
		
	}

}
