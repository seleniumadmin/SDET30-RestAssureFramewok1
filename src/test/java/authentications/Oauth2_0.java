package authentications;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;



public class Oauth2_0 {
	@Test
	public void oauthAuthentication() {
		//create a request to generate access token
		Response resp = given()
		.formParam("client_id", "SDETCoopsAPI")
		.formParam("client_secret", "ab6a934b729dc483e9d8890044cb745d")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://eg.com")
		.formParam("code", "authorization_code only")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		//capture the acces token from the response of request
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		//create another request and use the token to acces the APIs
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 3129)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then().log().all();
		
		
		
	}

}
