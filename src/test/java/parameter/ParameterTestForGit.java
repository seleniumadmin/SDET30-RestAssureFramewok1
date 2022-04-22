package parameter;


import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class ParameterTestForGit 
{
	@Test
public void parameterTest() {
	
	baseURI="https://api.git.com";
	 given()
	 .pathParam("username", "seleniumadmin")
	 .queryParam("per_page", 30)
	 .queryParam("page", 1)
	 
	 .when()
	 .get("/users/{username}/repos")
	 
	 .then().assertThat().statusCode(403).log().all();
	
}
}
