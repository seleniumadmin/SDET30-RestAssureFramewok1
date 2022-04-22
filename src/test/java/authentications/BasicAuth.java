package authentications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuth {
	@Test
	public void basicDigestiveAuth() {
		baseURI="http://localhost";
		port=8084;
		 
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then()
		.assertThat().statusCode(202).log().all();
		
	}
	@Test
	public void basicPreEmpitiveAuth() {
		baseURI="http://localhost";
		port=8084;
		 
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then()
		.assertThat().statusCode(202).log().all();
	}
	@Test
	public void basicAuth() {
		
		baseURI="http://localhost";
		port=8084;
		
			
			 
			given()
			.auth().digest("rmgyantra", "rmgy@9999")
			
			.when()
			.get("/login")
			
			.then()
			.assertThat().statusCode(202).log().all();
		}
		
	}


