package responsevValidation;

import org.testng.annotations.Test;


import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {
	@Test
	public void dynamicResponse() {
		
	String expData="TY_PROJ_418";
		baseURI="http://localhost";
		port=8084;
		 //action
		
        Response resp = when()
        .get("/projects");
        
        //validation
        boolean flag=false;
       List<String> pIDs=resp.jsonPath().get("projectId");
       for(String projectID:pIDs) {
		if(projectID.equalsIgnoreCase(expData)) {
			flag=true;
		}
			
		}
       System.out.println("data verified");
       resp.then().log().all();
	}

}
