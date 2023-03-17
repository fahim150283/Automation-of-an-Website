package Testcases;

import java.nio.charset.Charset;
import java.util.Random;

public class random_name_generator {


	public static String getStaticValue() {
		
		
		byte[] array = new byte[5]; // length is bounded by 5
	    new Random().nextBytes(array);
	    
		String myString = new String(array, Charset.forName("UTF-8"));
		return myString;
	}
}
