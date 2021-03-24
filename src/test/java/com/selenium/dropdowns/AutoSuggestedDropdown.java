package com.selenium.dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestedDropdown {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Launching the browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// hit the url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Auto suggested dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(3000);

		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		// Creating for each loop
		for (WebElement option : options) {

			if (option.getText().equalsIgnoreCase("India")) {

				option.click();
				break;
			}

		}

	}

}
