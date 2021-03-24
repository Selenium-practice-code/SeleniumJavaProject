package com.sumit.jqueryelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripSlider {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		 
		driver.findElement(By.xpath("//span[contains(text(),'From')]")).click();
		driver.findElement(By.xpath("//p[contains(text(),'Delhi, India')]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'To')]")).click();
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/p[1]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
		
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div/div[1]/div/div[2]/div/div/div/div[1]/div/div[4]"));
		WebElement mainSlider = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div/div[1]/div/div[2]/div/div/div/div[1]/div/div[2]"));
		Thread.sleep(3000);
		
		new Actions(driver).dragAndDropBy(slider, mainSlider.getSize().width/2, 0).build().perform();
		
		
	}

}
