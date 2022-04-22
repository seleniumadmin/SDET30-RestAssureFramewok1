package DifffrentWaysToPOST;

import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import projectLibraries.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPOSO {
	@Test
	public void createProject() {
		JavaLibrary jLib = new JavaLibrary();
		baseURI="http://localhost";
		port=8084;
		
	   //step1:create pre requisites
		ProjectLibrary pLib = new ProjectLibrary("Harindra", "Google "+jLib.getRandomNumber(), "Completed", 5);
		
		given()
		.body(pLib)
		.contentType(ContentType.JSON)
		.when() //step2:perform action
		.post("/addProject")
		.then()  //step3:validation
		.assertThat().statusCode(201) 
		.log().all();
		
	}

}
