package com.sumit.iframes;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestiFrames {

	public static WebDriver driver;

	public static void captureScreenshot() throws IOException {

		// Time Stamp
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		// Taking screenshot
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot,
				new File(System.getProperty("user.dir") + "/src/test/resources/screenshot/" + fileName));

	}

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Set<String> winids = driver.getWindowHandles();
		Iterator<String> iterator = winids.iterator();
		String first_window = iterator.next();

		// switch to frame()
		driver.switchTo().frame("iframeResult");
		//driver.findElement(By.xpath("/html/body/button")).click();

		//using java script executor
		((JavascriptExecutor) driver).executeScript("myFunction()");

		driver.switchTo().window(first_window);

		//Move back to main window only for frame
		driver.switchTo().defaultContent();

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));

		System.out.println(frames.size());

		for (WebElement frame : frames) {

			System.out.println(frame.getAttribute("id"));

		}

		captureScreenshot();

	}
}
