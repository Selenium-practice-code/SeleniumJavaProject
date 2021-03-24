package com.sumit.sslcrtification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingSSLCertification {

	public static void main(String[] args) {
		 
		DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome ();      
				handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
				
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver (handlSSLErr);
				
				//for firefox
				
				FirefoxProfile profile = new FirefoxProfile();
				profile.setAcceptUntrustedCertificates(true);
				profile.setAssumeUntrustedCertificateIssuer(false);
				
				
				

	}

}
