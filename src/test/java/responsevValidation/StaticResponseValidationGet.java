package responsevValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationGet 
{
	@Test
	public void responseValidationGet() {
		//preconditions
		baseURI ="http://localhost";
		port=8084;
		
		String expData="TY_PROJ_001";
		
		Response resp = when()
		.get("/projects");
		 //validation
		String actData=resp.jsonPath().get("[0].projectId");
	    Assert.assertEquals(actData, expData);
	    System.out.println("data verified");
	    
	    resp.then().log().all();
		
		
		
	}

}
