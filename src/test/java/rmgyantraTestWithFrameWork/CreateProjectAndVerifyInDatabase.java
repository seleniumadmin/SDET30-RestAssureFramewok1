package rmgyantraTestWithFrameWork;

import org.testng.annotations.Test;

import commonLibraries.BaseAPIClass;
//import commonLibraries.ContantsLibrary;
import commonLibraries.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import projectLibraries.ProjectLibrary;

public class CreateProjectAndVerifyInDatabase extends BaseAPIClass {
	@Test
	public void createProjectAndVerifyInDatabase() throws Throwable {
		//step1:create Prerequisites
		ProjectLibrary pLib = new ProjectLibrary("Usharani","Amdocs "+jLib.getRandomNumber(),"On Going",20);
		
		Response resp=given()
		.body(pLib)
		.contentType(ContentType.JSON)
		
			
		
		.when()
		.post(EndPointsLibrary.CreateProject);
		
		
		//step2:capture the projects ID
		String expData = rLib.getJsonPath(resp, "projectId");
		System.out.println(expData);
		
		//step3:verify the project in api response
		given()
		.pathParam("pid",expData)
		.when()
		.get(EndPointsLibrary.GetAllprojects+"{pid}")
		.then().log().all();
		System.out.println("Data Successfully verified in API response");
		
		//step4:verify the project in database
		String query="select * from project";
		String data = dLib.executeQueryAndGetData(query, expData, 1);
		System.out.println(data);
		System.out.println("data verified successfully in database");
		
		
		}

}
