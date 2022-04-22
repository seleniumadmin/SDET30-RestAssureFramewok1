package CRUDOperationsWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetSingleProjectTest {
	@Test
	public void getSingleProject() {
		//step1:create Pre requisites
		//step2:Perform action
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_417");
		
		//step3:validation
		resp.then().log().all();
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(actStatus, 200);
	}

}
