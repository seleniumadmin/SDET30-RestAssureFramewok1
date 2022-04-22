package CRUDOperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	@Test
	public void updateProjectTest() {
		//step1:create pre reqisites
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "Usha");
		jObj.put("projectName", "Xylem1");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 15);
		
		RequestSpecification req=RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		//step2:perform action
		Response resp=req.put("http://localhost:8084/projects/TY_PROJ_410");
		
		//step3:validate
		resp.then().log().all();
		int actstatus = resp.getStatusCode();
		
		Assert.assertEquals(200, actstatus);
		
	}

}
