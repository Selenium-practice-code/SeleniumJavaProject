package com.sumit.calender;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * target day, month, year current day, month, year jump to month increment or
 * decrement
 */

public class CalenderUI {

	static int targetDay = 0, targetMonth = 0, targetYear = 0;

	static int currentDay = 0, currentMonth = 0, currentYear = 0;

	static int jumpMonthsBy = 0;

	static boolean increment = true;

	public static void main(String[] args) throws InterruptedException {

		/*
		 * 
		 * target day, month, year current day, month, year jump to the month increment
		 * or decrement
		 */

		String dateToSet = "18/04/2021";

		// get current date
		getCurrentDateMonthAndYear();
		System.out.println(currentDay + "   " + currentMonth + "   " + currentYear);

		// get target date
		GetTargetDateMonthAndYear(dateToSet);
		System.out.println(targetDay + "   " + targetMonth + "   " + targetYear);

		// Get Jump month
		CalculateHowManyMonthsToJump();
		System.out.println(jumpMonthsBy);
		System.out.println(increment);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"travel_date\"]")).click();

		for (int i = 0; i < jumpMonthsBy; i++) {

			if (increment) {

				driver.findElement(By.xpath("/html/body/div[7]/div[1]/table/thead/tr[1]/th[3]")).click();

			} else {

				driver.findElement(By.xpath("/html/body/div[7]/div[1]/table/thead/tr[1]/th[1]")).click();

			}

			Thread.sleep(1000);

		} 
		

		driver.findElement(By.linkText(Integer.toString(targetDay))).click();

	}

	public static void getCurrentDateMonthAndYear() {

		Calendar cal = Calendar.getInstance();

		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH) + 1;
		currentYear = cal.get(Calendar.YEAR);

	}

	public static void GetTargetDateMonthAndYear(String dateString) {

		int firstIndex = dateString.indexOf("/");
		int lastIndex = dateString.lastIndexOf("/");

		String day = dateString.substring(0, firstIndex);
		targetDay = Integer.parseInt(day);

		String month = dateString.substring(firstIndex + 1, lastIndex);
		targetMonth = Integer.parseInt(month);

		String year = dateString.substring(lastIndex + 1, dateString.length());
		targetYear = Integer.parseInt(year);

	}

	public static void CalculateHowManyMonthsToJump() {

		if ((targetMonth - currentMonth) > 0) {

			jumpMonthsBy = (targetMonth - currentMonth);
		} else {

			jumpMonthsBy = (currentMonth - targetMonth);
			increment = false;
		}

	}

}
