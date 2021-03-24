package com.sumit.iframes;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/#top");

		driver.findElement(By.xpath("//a[@id='opentab']")).click();

		Set<String> winids = driver.getWindowHandles();
		Iterator<String> iterator = winids.iterator();

		String first_window = iterator.next();
		String Second_window = iterator.next();

		Thread.sleep(3000);

		driver.switchTo().window(Second_window);

		driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/div[2]/nav[1]/div[2]/ul[1]/li[8]/a[1]")).click();

		driver.switchTo().window(first_window);

		System.out.println(driver.findElement(By.xpath("//body//h1")).getText());

	}

}
