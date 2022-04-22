package CRUDOperationsWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleprojectTest {
	@Test
	public void getSingleProject() {
		
		//step1:create pre requisites
		baseURI="http://localhost";
		port=8084;
		 
		//step2:actions
		when()
		.get("/projects/TY_PROJ_435")
		
		.then() //step3:validate
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
	}

}
