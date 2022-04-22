package CRUDOperationsWithBDD;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest {
	@Test
	public void deleteProjectTest() {
		
		//step1:create prerequisites
		baseURI="http://localhost:8084/";
		
		//step2:actions
		when()
		.delete("/projects/TY_PROJ_417")
		
		.then()  //step3:validate
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(204)
		.log().all();
		
	}

}
