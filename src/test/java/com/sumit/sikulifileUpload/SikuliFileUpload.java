package com.sumit.sikulifileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SikuliFileUpload {

	public static void main(String[] args) throws FindFailed {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://easyupload.io/");
		
		Screen screen = new Screen();
		
		Pattern img1 = new Pattern("/Users/sumtagnihoti/Desktop/loc.png");
		Pattern img2 = new Pattern("/Users/sumtagnihoti/Desktop/open.png");

		// uploading the image using sendkeys
		driver.findElement(By.xpath("//body/main[1]/div[1]/div[1]/div[1]/form[1]/div[1]/button[1]")).click(); 
				//.sendKeys("/Users/sumtagnihoti/Desktop/Screen Shot 2021-02-14 at 7.01.41 PM.png");
		
	 
		
		screen.type(img1, "/Users/sumtagnihoti/Desktop/Screen Shot 2021-02-14 at 7.01.41 PM.png");
		screen.click(img2);

	}

}
