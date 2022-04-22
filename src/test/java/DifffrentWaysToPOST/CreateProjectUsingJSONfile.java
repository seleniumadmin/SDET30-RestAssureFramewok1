package DifffrentWaysToPOST;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateProjectUsingJSONfile {
	@Test
	public void createProject() {
		//step1:create pre requisites
		File file=new File(".\\Data.json");
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(file)
		.contentType(ContentType.JSON)
		.when() //step2:perform Actions
		.post("/addProject")
		.then() //step3:validate
		.assertThat().statusCode(201)
		.log().all();
	}

}
