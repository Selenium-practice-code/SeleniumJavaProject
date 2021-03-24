package com.sumit.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

 

public class AssertionTest {
	
	@Test
	public void Validate() {
		
		try {
		System.out.println("Beginning");
		
		String actual_title = "Gmail.com";
		String expected_title = "Yahoo.com";
		
		//hard assertion
		Assert.assertEquals(actual_title, expected_title); 	
		}catch(Throwable t) {
			
			System.out.println("Error Occurred");
		}
		
		System.out.println("Ending");
		
				
	}

}
  