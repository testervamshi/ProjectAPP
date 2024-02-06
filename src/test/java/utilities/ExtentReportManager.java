package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;



public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkreporter;//UI of the report
	public ExtentReports extent;// common info to the report
	public ExtentTest test;// entry the data into the report
	String repName;
	public WebDriver driver;
	
	public void onStart(ITestContext context) {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//generate timestamp
		repName="Test-Report-"+timestamp+".html";
		//specify the location of folder
		sparkreporter=new ExtentSparkReporter(".\\reports\\"+repName);
		sparkreporter.config().setDocumentTitle("Automation testing");
		sparkreporter.config().setReportName("Smoke Test");
		sparkreporter.config().setTheme(Theme.DARK);
		
		//common info 
		extent =new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("computer name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Testrname","vamshi");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "chrome");
		
	}
	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest(result.getName());//create a entry in report
		test.log(Status.PASS, "Test is passed:"+result.getName());//update the info in the report
		System.out.println("test is passed");
		
		try {
			String imgpath=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);//screenshot is added to report
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test is failed:"+result.getName());
		test.log(Status.FAIL, "Test is failed:"+result.getThrowable());//reason for failure
		System.out.println("test is failed");
		try {
			String image=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(image);
			
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test is skipped:"+result.getName());
		test.log(Status.SKIP, "Test is skipped:"+result.getThrowable());
		try {
			String imgpath=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
			
		}catch(Exception e3) {
			e3.printStackTrace();
		}
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
