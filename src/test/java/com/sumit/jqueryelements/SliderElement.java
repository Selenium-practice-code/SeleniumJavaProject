package com.sumit.jqueryelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderElement {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		WebElement mainSlider = driver.findElement(By.xpath("//*[@id='slider']"));
		
		
		//give the size of slider
		//mainSlider.getSize().width/2;
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, mainSlider.getSize().width/2, 0).perform();
	}

}
