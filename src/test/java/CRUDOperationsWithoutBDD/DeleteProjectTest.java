package CRUDOperationsWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DeleteProjectTest {
	@Test
	public void deleteProjectTest() {
		//step1:To perform action
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_417");
		
		//step3:validate the action
		resp.then().log().all();
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(204, actStatus);
	}
}
