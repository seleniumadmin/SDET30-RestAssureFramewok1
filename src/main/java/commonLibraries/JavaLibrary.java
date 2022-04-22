package commonLibraries;

import java.util.Random;
/**
 * This class contains generic method related to java
 * @author My PC
 *
 */

public class JavaLibrary {
	
	public int getRandomNumber() 
	{
		Random ran=new Random();
		return ran.nextInt(1000);
		
	}
	

}
