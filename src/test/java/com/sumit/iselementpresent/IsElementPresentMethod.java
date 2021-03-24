package com.sumit.iselementpresent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IsElementPresentMethod {

	public static WebDriver driver;

	public static boolean isElementPresent(String locator) {

//		try {
//			driver.findElement(By.xpath(locator));
//			return true;
//			
//		} catch (Throwable t) {
//			
//			return false;
//		}
//		
//		

		int size = driver.findElements(By.xpath(locator)).size();

		if (size == 0) {

			return false;

		} else {

			return true;
		}

	}

	public static void main(String[] args) {

	}

}
