package DifffrentWaysToPOST;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJSONobject {
	@Test
	public void createproject() {
		JavaLibrary jLib=new JavaLibrary();
		
		//step1:create prerequisites
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "Prakash");
		jObj.put("projectName", "AllStates "+jLib.getRandomNumber());
		jObj.put("status", "Completed");
		jObj.put("teamSize", 10);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		
		.when()  //step2:perform action
		.post("/addProject")
		
		.then() //step3:valiadation
		.assertThat().statusCode(201)
		.log().all();
		
		
		
	}
}
