package CRUDOperationsWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProject {
	@Test
	public void getAllProject() {
		baseURI="http://localhost";
		port=8084;
		
		when()
		 .get("/projects")
		 .then()
		 .assertThat()
		 .statusCode(200)
		 .log().all();
		 
	}
	

}
