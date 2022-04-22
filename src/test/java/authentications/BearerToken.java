package authentications;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BearerToken {
	@Test
	public void bearerToken() {
		baseURI="https://api.github.com";
		JSONObject jObj=new JSONObject();
		jObj.put("name", "sdet30-restAssured");
		
		given()
		.auth()
		.oauth2("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")
		.body(jObj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user/repos")
		
		.then().log().all();
		
		
	}

}
