package com.sumit.testng;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_1 {
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		
		//Choose the browser, version, and platform to test
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability("version", 71);
		cap.setCapability("platform", Platform.WIN10);
		
		new RemoteWebDriver(
			    new URL("https://practiceselenium_7:0ba97510-c3c0-4bcd-8f7e-7bd0d57ac4bb@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), cap
				);
	}
	
	 
	@Test
	public void testLogin() {
		
		System.out.println("Testing Login Screen.");
	}
	
	@Test
	public void testFormFill() {
		
		System.out.println("Testing registeration form.");
	}
	
	@BeforeMethod
	public void OpenBrowser() {
		
		System.out.println("Open Browser");
	}
	
	@AfterMethod
	public void ClosingBrowser() {
		
		System.out.println("Close Browser");
	}
	
	@BeforeTest
	public void OpenDBconnection() {
		
		System.out.println("Create db connection");
	}
	
	@AfterTest
	public void CloseDBconnection() {
		
		System.out.println("db Connection Closed");
	}
	
	@BeforeSuite
	public void StartSeleniumServer() {
		
		System.out.println("Selenium server started");
		
	}
	
	@AfterSuite
	public void ClosedSeleniumServer() {
		
		
		System.out.println("Selenium server closed");
	}
	

}
