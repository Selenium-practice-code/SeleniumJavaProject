package com.sumit.extentreports;

import java.io.IOException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsTest {

	public ExtentHtmlReporter htmlRepoter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void setReports() {

		htmlRepoter = new ExtentHtmlReporter("./reports/extent.html");

		htmlRepoter.config().setEncoding("utf-8");
		htmlRepoter.config().setDocumentTitle("Automation Reports");
		htmlRepoter.config().setReportName("Automation Test Results");
		htmlRepoter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlRepoter);

		extent.setSystemInfo("Automation Tester", "Sumit Agnihotri");
		extent.setSystemInfo("Orgainzation", "w2Automation");
		extent.setSystemInfo("Build No", "W2A-1234");
	}

	@AfterTest
	public void endReports() {

		extent.flush();
	}

	@Test
	public void doLogin() {

		test = extent.createTest("Login Test");
		System.out.println("Successfully login");
	}

	@Test
	public void doUserReg() {

		test = extent.createTest("User Reg Test");
		Assert.fail("User reg Test Failed");
	}

	@Test
	public void isSkip() {

		test = extent.createTest("Skip test");
		throw new SkipException("Skipping the test case");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			

			String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			test.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
					+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
					+ " \n");
			
//		 	
//			try {
//
//				ExtentManager.captureScreenshot();
//				testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
//						MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName)
//								.build());
//			} catch (IOException e) {
//
//			 
			
			

			String failureLogg = "TEST CASE FAILED";
			Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
			test.log(Status.FAIL, m);
			

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			String methodName = result.getMethod().getMethodName();

			String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + "  PASSED" + "</b>";

			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			test.pass(m);

		} else if (result.getStatus() == ITestResult.SKIP) {

			String methodName = result.getMethod().getMethodName();
 
			String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + "  Skipped" + "</b>";

			Markup m = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
			test.skip(m);

		}

	}

}
