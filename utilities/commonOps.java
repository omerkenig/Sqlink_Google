package utilities;

import static org.junit.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

public class commonOps extends utils
{
	
	
    // This Function Verify if Element Exists on Page (Verification made By DOM Recognition)
    // <param name="element">DOM Element</param>
    public static void verifyElementExists(WebElement element) throws ParserConfigurationException, SAXException, IOException
    {
    	
        try
        {
        	Thread.sleep(5000L);
        	wait.until(ExpectedConditions.visibilityOf(element)); 
            element.isDisplayed();           
            test.log(LogStatus.PASS, "DOM Verification Passed, Element Exists: " + element);
        }
        catch (Exception exp)
        {
            test.log(LogStatus.FAIL, "DOM Verification Failed, Element NOT Exists, Error Message: " + exp.getMessage() + test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
            System.out.println("Element not Exists in Page : " + exp.getMessage());
            fail("Problem with Verifying Element, See Report for more Details");
        }
    }
    
    
    // This Function Verify if Element Displayed on Page (Verification made By DOM Recognition)
    // <param name="element">DOM Element</param>
    public static void verifyElementDisplay(WebElement element) throws ParserConfigurationException, SAXException, IOException, InterruptedException
    {
    	Thread.sleep(5000L);
    	wait.until(ExpectedConditions.visibilityOf(element)); 
        try
        {
        	if (element.isDisplayed())
        		test.log(LogStatus.PASS, "DOM Verification Passed, Element Displayed: " + element);
        	else
        	{
        		test.log(LogStatus.FAIL, "DOM Verification Failed, Element Not Displayed: " + element + test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
        		fail("DOM Verification Failed, Element Not Displayed");
        	}	
            
        }
        catch (Exception exp)
        {
            test.log(LogStatus.FAIL, "DOM Verification Failed, Element NOT Exists, Error Message: " + exp.getMessage() + test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
            System.out.println("Element not Exists in Page : " + exp.getMessage());
            fail("Problem with Verifying Element, See Report for more Details");
        }
    }
    
    
    // This Function Verify if Element is Not Displayed on Page (Verification made By DOM Recognition)
    // <param name="element">DOM Element</param>
    public void verifyElementNotDisplay(WebElement element) throws ParserConfigurationException, SAXException, IOException
    {
        try
        {
        	if (!element.isDisplayed())
        		test.log(LogStatus.PASS, "DOM Verification Passed, Element Not Displayed: " + element);
        	else
        	{
        		test.log(LogStatus.FAIL, "DOM Verification Failed, Element Displayed: " + element + test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
        		fail("DOM Verification Failed, Element Displayed");
        	}	
            
        }
        catch (Exception exp)
        {
            test.log(LogStatus.FAIL, "DOM Verification Failed, Element NOT Exists, Error Message: " + exp.getMessage() + test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
            System.out.println("Element not Exists in Page : " + exp.getMessage());
            fail("Problem with Verifying Element, See Report for more Details");
        }
    }
}
