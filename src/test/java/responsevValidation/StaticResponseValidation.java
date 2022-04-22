package responsevValidation;

import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLibraries.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {
	@Test
	public void staticResponse() {
		
		JavaLibrary jLib=new JavaLibrary();
		//step1:preconditions
		baseURI="http://localhost";
		port=8084;
		
		ProjectLibrary pLib=new ProjectLibrary("Advik", "Amdocs "+jLib.getRandomNumber(), "created", 12);
		 
		Response resp= given()
		.body(pLib)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject");
		
		resp.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
		}

}
