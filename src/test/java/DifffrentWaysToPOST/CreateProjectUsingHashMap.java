package DifffrentWaysToPOST;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardResizeToggleHandler;

import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUsingHashMap {
	@Test
	public void createProject() {
		JavaLibrary jLib=new JavaLibrary();
		baseURI="http://localhost";
		port=8084;
		
		//step1:create pre requisites
		HashMap map=new HashMap();
		map.put("createdBy", "chandan");
		map.put("projectName", "Sony"+jLib.getRandomNumber());
		map.put("status", "Created");
		map.put("teamSize", 10);
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()  //step2:perform action
		.post("/addProject")
		
		.then() //step3:valiadation
		.assertThat().statusCode(201)
		.log().all();
		
	}

}
