package GenericLibrary;

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

public class ITtestListnersImplementationLibrary implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String method = result.getMethod().getMethodName();
		//Reporter.log("Method is started "+method);
		
		 test = report.createTest(method);
		 test.log(Status.INFO, "Method is started");
	}

	public void onTestSuccess(ITestResult result) {
		String method = result.getMethod().getMethodName();
		//System.out.println("Method is successfull "+method);
		 test = report.createTest(method);
		 test.log(Status.PASS, "Method is passed");
	}

	public void onTestFailure(ITestResult result) {
		WebdriverLibrary wbl=new WebdriverLibrary();
        JavaLibrary jl=new JavaLibrary();
		String method = result.getMethod().getMethodName()+jl.dateedited();

		System.out.println("Method is failed "+method);
		
		
			try {
				String path = wbl.takeScreenShot(BaseClass.sderiver, method);
				   test.addScreenCaptureFromPath(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			 test = report.createTest(method);
			 test.log(Status.FAIL, "Method is failed");
             test.log(Status.FAIL,result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		String method = result.getMethod().getMethodName();
		//System.out.println("Method is skipped "+method);
		 test = report.createTest(method);
		 test.log(Status.SKIP, "Method is skipped");
         test.log(Status.SKIP,result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		JavaLibrary jl=new JavaLibrary();
		Reporter.log("Suite is started");
       ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+jl.dateedited()+".html");
         htmlreport.config().setDocumentTitle(" report of projetP");
         htmlreport.config().setTheme(Theme.STANDARD);
         htmlreport.config().setReportName("Extent report");
         
          report= new ExtentReports();
         report.attachReporter(htmlreport);
         report.setSystemInfo("Base Browser", "Chrome");
         report.setSystemInfo("url", "http://localhost:8888");
         report.setSystemInfo("environemt", "Testing Environemnt");
         report.setSystemInfo("Operating System", "Windows");

         
	}

	public void onFinish(ITestContext context) {
		System.out.println("Suite is finished");
		report.flush();

	}
	
	

}
