package commonLibraries;

import io.restassured.RestAssured;
import io.restassured.response.Response;
/**
 * this cl;ass consists of generic method related to restAssured
 * @author My PC
 *
 */

public class RestAssuredLibrary {
	/**this method will will return the json path
	 * 
	 * @param resp
	 * @param jsonPath
	 */
	public String getJsonPath(Response resp,String jsonPath) 
	{
		String value=resp.jsonPath().getString(jsonPath);
		return value;
	
		
		
	
	
	
	
	
	
	}

}
