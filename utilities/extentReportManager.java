package utilities;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;
import java.util.UUID;


public class extentReportManager extends utils
{
	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	static Date date = new Date();
	public static String currentDate = dateFormat.format(date);	
	public static String reportDir = "";
		
	
	// This Function Initial Extent Report
	// Parameters: TimeStamp
	// Returned Value: ExtentReport Instance
	public static ExtentReports Instance(String timeStamp) throws ParserConfigurationException, SAXException, IOException
    {
		ExtentReports extent;
        String Path = getData("ReportFilePath") + "Execution_" + timeStamp + "/" + getData("ReportFileName");        
        extent = new ExtentReports(Path, false, DisplayOrder.OLDEST_FIRST);
        return extent;
    }
	
	// This Function Capture Screen Shot
	// Parameters: TimeStamp
	// Returned Value: Image Path (as String)	
	public static String CaptureScreen(String timeStamp) throws ParserConfigurationException, SAXException, IOException
	{
		String imgPath = getData("ReportFilePath") + "Execution_" + timeStamp + "/" + UUID.randomUUID().toString() + ".png";
		TakesScreenshot oScn = (TakesScreenshot) driver;
		File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		File oDest = new File(imgPath);
		try
		{
			FileUtils.copyFile(oScnShot, oDest);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		return imgPath;
     }
	
	
	public static String CaptureScreens(WebDriver driver, String timeStamp) throws ParserConfigurationException, SAXException, IOException
	{
		String imgPath = getData("ReportFilePath") + "Execution_" + timeStamp + "/" + UUID.randomUUID().toString() + ".png";
		TakesScreenshot oScn = (TakesScreenshot) driver;
		File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		File oDest = new File(imgPath);
		try
		{
			FileUtils.copyFile(oScnShot, oDest);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		return imgPath;
     }

	
	public static String capscr(String timeStamp) throws ParserConfigurationException, SAXException, IOException, AWTException
	{
		String imgPath = getData("ReportFilePath") + "Execution_" + timeStamp + "\\" + UUID.randomUUID().toString() + ".png";
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = new Robot().createScreenCapture(screenRect);
		ImageIO.write(capture, "png", new File(imgPath));
		return imgPath;
	}
}
