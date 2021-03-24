package com.sumit.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testNg_Parameters {
	
   @Test(dataProvider = "getData")
	public void testFormFill(String username, String password, int age) {
	   
	   System.out.println(username + "  -  " + password + " - " + age);
		
		

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][3];

		data[0][0] = "tom@gmail.com";
		data[0][1] = "pass2123";
		data[0][2] = 18;

		data[1][0] = "jerry@gmail.com";
		data[1][1] = "pass@123";
		data[1][2] = 19;

		return data;

	}

}
