package com.sumit.utilities;

import org.apache.log4j.PropertyConfigurator;
import org.testng.log4testng.Logger;

public class TestLogs {
	
	public static Logger log = Logger.getLogger(TestLogs.class);

	public static void main(String[] args) {
		
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/properties/log4j.properties");
		
		log.info("first massage");
		
		log.info("second message"); 
		
		log.debug("last message");
	}

}
