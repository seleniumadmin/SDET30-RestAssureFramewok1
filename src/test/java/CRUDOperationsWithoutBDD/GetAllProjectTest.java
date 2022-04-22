package CRUDOperationsWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetAllProjectTest 
{
	@Test
	public void getAllProjectTest() 
	{
		//step1:create a prerequisites
		//step2:Perform the action
		Response resp=RestAssured.get("http://localhost:8084/projects");
		
		//step3:provide validation
		resp.then().log().all();
		
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(200, actStatus);
	}

}
