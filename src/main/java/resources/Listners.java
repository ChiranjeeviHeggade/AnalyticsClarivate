package resources;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import foundation.BaseClass;
import resources.MonitoringMail;
import resources.TestConfig;

public class Listners implements ITestListener, ISuiteListener {

	BaseClass base = new BaseClass();
	public String messageBody;
	

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext folder) {
		folder.getName();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		
		try {
			base.getScreenShot(result.getName(),result.getStatus());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		 result.getName();
		 try {
		 base.getScreenShot(result.getName(), result.getStatus());
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }

	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ISuite suite) {
    MonitoringMail mail = new MonitoringMail(); 
	
	try {
		messageBody = "CLICK ON THE LINK TO SEE THE EXTENT REPORT - " + "http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/LeadCreation/ExtentReports";
	} catch (UnknownHostException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		 
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
