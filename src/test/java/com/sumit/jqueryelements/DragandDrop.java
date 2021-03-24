package com.sumit.jqueryelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {

	public static WebDriver driver;

	public static void main(String[] args) {
		 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement draggable = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		WebElement droppable = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		
		new Actions(driver).dragAndDrop(draggable, droppable).perform();
	}

}
