package CRUDOperationsWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

//import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {
	@Test
	public void getUpdateProjectTest() 
	{
		//JavaLibrary jlib=new Javalibrary();
		JSONObject jObj = new JSONObject();
        jObj.put("cretedBy", "Usharani");
        jObj.put("projectName", "Xylem11 ");
        jObj.put("status", "Completed");
        jObj.put("teamSize", 12);
        
        baseURI="http://localhost";
        port=8084;
        
        given()
           .body(jObj)
           .contentType(ContentType.JSON)
           
           .when() //step2:perform action
           .put("/projects/TY_PROJ_1004")
           
           .then() //step3:validation
           .assertThat()
           .statusCode(200)
           .contentType(ContentType.JSON)
           .log().all();

		

	}

}
