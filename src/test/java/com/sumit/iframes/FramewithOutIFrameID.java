package com.sumit.iframes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramewithOutIFrameID {

	public static void main(String[] args) throws InterruptedException {
		 
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		 
	
		
		WebElement dragable = driver.findElement(By.id("draggable"));
		WebElement dropable = driver.findElement(By.id("droppable"));
		
		 Actions action = new Actions(driver);
		 action.dragAndDrop(dragable, dropable).perform();
		 
		 driver.switchTo().defaultContent();
		 
		 System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText());

	}

}
