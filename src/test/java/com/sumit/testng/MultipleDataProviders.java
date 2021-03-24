package com.sumit.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleDataProviders {
	
	
	@Test(dataProvider = "dp1")
	public void testData(String username, String password) {
		
		System.out.println(username + "-----" + password);
	}
	

	@DataProvider(name = "dp1")
	public static Object[][] getData() {
		
		Object[][] data = new Object[2][2];
		
		data[0][0] = "raman";
		data[0][1] = "xgasjah";
		
		data[1][0] = "saman";
		data[1][1] = "xgasjah";
		
		return data;

	}

}
