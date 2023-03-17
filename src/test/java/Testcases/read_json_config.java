package Testcases;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class read_json_config {
	static String url;
	static String name;
	static String age;
	static String city;
	static String firstname;
	static String lastname;
	static String email;
	static String salary;
	static String department;
	public static String[] getarray(){
		JSONParser parser = new JSONParser();
	
	    try (FileReader reader = new FileReader("config_info.json")) {
	        Object obj = parser.parse(reader);
	        JSONObject jsonObject = (JSONObject) obj;
	
	         url = (String) jsonObject.get("homepage");
		     name = (String) jsonObject.get("name");
		     age = (String) jsonObject.get("age");
		     city = (String) jsonObject.get("city");
		     firstname = (String) jsonObject.get("firstname");
		     lastname = (String) jsonObject.get("lastname");
		     email = (String) jsonObject.get("email");
		     salary = (String) jsonObject.get("salary");
		     department = (String) jsonObject.get("department");

	
	    } catch (IOException | ParseException e) {
	        e.printStackTrace();
	    }
		
	    String[] array= {url,name,age,city,firstname,lastname,email,salary,department}; 
	    return array;
	    
	}
}
