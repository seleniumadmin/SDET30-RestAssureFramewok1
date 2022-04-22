package responsevValidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import projectLibraries.ProjectLibrary;

public class CreateMultipleProjectWithDiffData {
@Test(dataProvider="getData")
public void createProject(String createdBy,String projectName,String status,int teamSize) 
{
	//prerqisites
	JavaLibrary jLib=new JavaLibrary();
	ProjectLibrary pLib=new ProjectLibrary(createdBy,projectName+jLib.getRandomNumber(),status,teamSize);
	baseURI="http://localhost";
	port=8084;
	
	given()
	.body(pLib)
	.contentType(ContentType.JSON)
	
	//Actions
	.when()
	.post("/addProject")
	//validation
	.then().log().all();
	
}

@DataProvider(name="getData")
public Object[][] data()
{
	Object[][] data=new Object[3][4];

data[0][0]="usha";
data[0][1]="Dell";
data[0][2]="Completed";
data[0][3]=12;

data[1][0]="usha";
data[1][1]="Dell";
data[1][2]="Completed";
data[1][3]=12;

data[2][0]="usha";
data[2][1]="Dell";
data[2][2]="Completed";
data[2][3]=12;

return data;
}
}
