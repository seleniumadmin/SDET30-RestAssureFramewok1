package RequestChaining;

import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLibraries.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateprojectAndGetProject {
	@Test
	public void requestChaining1() {
		//Step1:create project using POJO
		JavaLibrary jLib=new JavaLibrary(); 
		ProjectLibrary pLib = new ProjectLibrary("Swathi", "Firefox"+jLib.getRandomNumber(), "Completed", 15);
		baseURI="http://localhost";
		port=8084;
		
		Response resp = given()
		.body(pLib)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
		//capture the project id
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();
		
		//create a get request and pass proid as path parameter
		given()
		.param("pid", proId)
		.when()
		.get("/projects/{pid}")
		.then()
		.assertThat().statusCode(200).log().all();
		
		
	}

}
