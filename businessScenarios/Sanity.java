package businessScenarios;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;
import pageObjects.Chat;
import pageObjects.homePage;
import pageObjects.login;
import utilities.commonOps;
import utilities.utils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Sanity extends utils {

	// public static WebDriver driver;
	Random rnd = new Random();

	private static String mainWindowHandle;
	private static pageObjects.homePage home = new pageObjects.homePage(driver);

	@BeforeClass
	public static void openBrowser() throws ParserConfigurationException, SAXException, IOException {
		// Initiating a chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SQtest\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@After
	public void finalizingTest() throws ParserConfigurationException, SAXException, IOException {
		// recoveryTest(driver);
		finilizeExtentReportTest();
	}

	@AfterClass
	public static void closeBrowser() throws ParserConfigurationException, SAXException, IOException {
		finilizeExtentReport();
		 driver.quit();
	}

	@Test
	public void Test1_PrintAllLinks()
			throws InterruptedException, ParserConfigurationException, SAXException, IOException, AWTException {

		  //1. open google.com
        driver.get("http://www.google.com");
		  //2. enter "selenium"
        home.searchtext.sendKeys"selenium";
        //3. google search click
        home.searchclick.click();
        //4. print all links
        home.printlinks();  
	}

	@Test
	public void Test2()
			throws InterruptedException, ParserConfigurationException, SAXException, IOException, AWTException {
		  //1. open google.com
        driver.get("http://www.google.com");
        //2. enter "selenium g"
        home.searchtext.sendKeys"selenium g";
        //3.
        home.waitForGithub();
        // look for selenium github
        WebElement result = null;
        // 6. validGithub
        home.validGithub();
        //7. click result
        home.clickResult();
        //8. valide repo
        home.validRepo();
        //9. click Clone Or Download
        home.clickCloneOrDownload();
        //10.print URL
        home.printUrl();
        //11.find &open issue
        home.findAndOpen();
        
        //12. PrintData
        home.printData();
        
        
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getText().equalsIgnoreCase("selenium github")){
            	result = results.get(i);
                System.out.println("got the result");
                break;
            }
        }
        
	}

	public static void initElements() {
		PageFactory.initElements(driver, home);


	}

}
