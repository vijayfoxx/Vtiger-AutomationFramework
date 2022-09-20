package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class acts like implementation class for overriding all the methods present in ITestlistener class
 * @author Vijay
 *
 */

public class ListenerImplementationClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName); // testt os created which will initialize the individual test
		
		//Reporter.log(methodName+"test script execution is started",true);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"---Passed");
		
		//Reporter.log(methodName+"is passed", true);
	}

	public void onTestFailure(ITestResult result) {
		WebdriverUtility wu=new WebdriverUtility();
		JavaUtility ju=new JavaUtility();
		//this will capture the exception accured
		//String msg = result.getThrowable().toString();
		//this will capture the current method name
		String methodName = result.getMethod().getMethodName();
		//this will append the date in format for screenshot
		String screenshotName =methodName+"-"+ ju.getSystemDateInFormat();
		//this will login report and console
		test.log(Status.FAIL, methodName+"---Failed");
		test.log(Status.FAIL, result.getThrowable());
		//Reporter.log(methodName+"is failed, because"+msg, true);
		//this will capture the screenshot and provide screenshot name and save it to folder
		try {
			String path = wu.takeScreenshot(BaseClass.sdriver, screenshotName);
			test.addScreenCaptureFromPath(path);//navigate to screenshot path and attach it to report
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String msg = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"---Skipped");
		test.log(Status.SKIP, result.getThrowable());
		//Reporter.log(methodName+"is skipped, because"+msg, true);
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		//start of the execution
		/*configure the extents report*/
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReports/Report-"+ new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("WASM-vtiger execution report");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("vtiger execution report");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Base-Platform", "Windows");
		report.setSystemInfo("Base-Url", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Vijay");
	}

	public void onFinish(ITestContext context) {
		//end of the execution
		report.flush(); //consolidate all the scripts and dumb the status into report
	}
	

}
