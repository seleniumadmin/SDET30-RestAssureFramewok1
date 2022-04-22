package CRUDOperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	@Test
	public void ctreateProjectTest() {
		//step1:create the pre-requisites---request body
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "Usha");
		jObj.put("projectName", "Xylem");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 12);
		
		RequestSpecification req=RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		//step2:perform the action
		
	     Response response=req.post("http://localhost:8084/addProject");
	     
	     //step3:validate the response
	     System.out.println(response.getContentType());
	     System.out.println(response.asString());
	     System.out.println(response.prettyPrint());
	     System.out.println(response.prettyPeek());
		
	}

}
