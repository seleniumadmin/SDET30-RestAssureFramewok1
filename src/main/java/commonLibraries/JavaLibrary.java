package commonLibraries;

import java.util.Random;
/**
 * This class contains generic method related to java
 * @author My PC
 *
 */

public class JavaLibrary {
	/**
	 * This method will generate a random number for every execution
	 * @return
	 */
	
	public int getRandomNumber() 
	{
		Random ran=new Random();
		return ran.nextInt(1000);
		
	}
	

}
