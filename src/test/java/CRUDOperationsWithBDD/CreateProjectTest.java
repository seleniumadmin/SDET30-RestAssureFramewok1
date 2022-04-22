package CRUDOperationsWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;



public class CreateProjectTest {
	@Test
	public void createProjectTest() 
	{
		JSONObject jObj = new JSONObject();
        jObj.put("cretedBy", "Usharani");
        jObj.put("projectName", "Xylem1123451");
        jObj.put("status", "Completed");
        jObj.put("teamSize", 12);
        
        baseURI="http://localhost";
        port=8084;
        
        given()
           .body(jObj)
           .contentType(ContentType.JSON)
           
           .when()  //step2:perform action
           .post("/addProject")
           
           .then() //step3:validation
           .assertThat()
           .statusCode(201)
           .contentType(ContentType.JSON)
           .log().all();

		
	}

}
