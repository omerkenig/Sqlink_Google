package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class utils
{
	
	public static WebDriver driver;
	public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
    public static String location;
    public static ExtentReports extent;
    public static ExtentTest test;
    private static String sPathFile = "projConfig.xml"; 
    protected Random rnd = new Random();
    protected static WebDriverWait wait;
    
    


    
    
    // This Function Initiate a Test for it's Logs and reports
    // <param name="sTestName">Test Name</param>
    // <param name="sTestDescription">test Description</param>
    public void initTest(String sTestName, String sTestDescription) throws ParserConfigurationException, SAXException, IOException
    {
        location = getData("ReportFilePath") + "Execution_" + timeStamp + "\\";
        File dir = new File(location);
        dir.mkdir();
        test = extent.startTest(sTestName, sTestDescription);       
    }
    
    
    // This Function Initiate Extent Report and put it to the extent Object
    public static void initExtentReport() throws ParserConfigurationException, SAXException, IOException
    {
        extent = extentReportManager.Instance(timeStamp);
    }
    
    
    // This Function Finalize The Extent Test 
    public void finilizeExtentReportTest() throws ParserConfigurationException, SAXException, IOException
    {
        extent.endTest(test); 
    }

    // This Function Finalize The Extent Report
    public static void finilizeExtentReport()
    {
        extent.flush();
        extent.close();
    }
    
    
    // This Function Reads data from XML Configuration File
    // <param name="sNodeName">Attribute (Node) Name</param>
    // <returns>Attribute (Node) Value</returns>
    public static String getData(String sNodeName) throws ParserConfigurationException, SAXException, IOException
    {
    	File fXmlFile = new File(sPathFile);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);		
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(sNodeName).item(0).getTextContent();
    }
    
    
    // This Function Initiate the Browser Type, It get the Value from Configuration File and Initiate the driver Accordingly
    // <param name="browserType">The Browser Type</param>
    // <returns>Initialized driver</returns>
    public static void initBrowser(String browserType) throws ParserConfigurationException, SAXException, IOException
	{
		switch (browserType.toLowerCase())
		{
        case "firefox":
        	 driver = initFFDriver();
             break;
    
        case "ie":
        	 driver = initIEDriver();
             break;
                     
        case "chrome":
        	 driver = initChromeDriver();
             break;
         
             default:
            	 driver = initChromeDriver();
            	 break; 
		}
		
		//driver.manage().window().maximize();		
		driver.get(getData("URL"));
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(getData("WaitTime")), TimeUnit.SECONDS);
	}
	
	
    // This Function Initiate Chrome driver
    // <returns>Webdriver of Chrome</returns>
	public static WebDriver initChromeDriver() throws ParserConfigurationException, SAXException, IOException
    {		
		System.setProperty("webdriver.chrome.driver", getData("ChromeDriverPath"));
		WebDriver driver = new ChromeDriver();
        return driver;
    }

    
    // This Function Initiate FireFox driver
    // <returns>WebDriver of FireFox</returns>
    public static WebDriver initFFDriver() throws ParserConfigurationException, SAXException, IOException
    {
    	System.setProperty("webdriver.gecko.driver", getData("FireFoxDriverPath"));
        WebDriver driverff = new FirefoxDriver();
        return driverff;
    }
    
    
    // This Function Initiate Internet Explorer driver
    // <returns>WebDriver of Internet Expllorer</returns>
    public static WebDriver initIEDriver() throws ParserConfigurationException, SAXException, IOException
    {
    	System.setProperty("webdriver.ie.driver", getData("IEDriverPath"));
    	WebDriver iedriver = new InternetExplorerDriver();
        return iedriver;
    }
    

    // This Function Switch Every End of test To the Main Page (Expense Report Page)
    // <param name="driver">driver to Execute</param>
	/*
	 * public void recoveryTest(WebDriver driver) throws
	 * ParserConfigurationException, SAXException, IOException { try {
	 * driver.findElement(By.id("post-9")); } catch (NoSuchElementException e) {
	 * driver.findElement(By.cssSelector("img[src*='images/DemoSite.png']")).click()
	 * ; } }
	 */
}
