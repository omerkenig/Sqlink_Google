package pageObjects;

import static org.junit.Assert.fail;
import java.awt.AWTException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;
import com.relevantcodes.extentreports.LogStatus;
import utilities.extentReportManager;
import utilities.utils;
import utilities.utils;

public class login extends utils {
	public login(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "email")
	public WebElement Email;

	@FindBy(how = How.NAME, using = "phone")
	public WebElement Phone;

	@FindBy(how = How.NAME, using = "firstName")
	public WebElement FirstName;

	@FindBy(how = How.NAME, using = "lastName")
	public WebElement LastName;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[4]/div/div[2]/div[4]/form/div[4]/button")
	public WebElement Continue;

	public WebElement Continue() {
		return Continue;
	}

	public void action(String email, String phone, String firstName, String lastName)
			throws InterruptedException, ParserConfigurationException, SAXException, IOException, AWTException {
		// solitaire.click();
		enterEmail(email);
		enterPhone(phone);
		enterFirstName(firstName);
		enterLastName(lastName);
		clickContinue();
	}

	private void enterEmail(String email2) throws ParserConfigurationException, SAXException, IOException {
		try {
			int num=(rnd.nextInt(10000000 - 1) + 1);
			Email.click();
			Email.sendKeys(num+email2);
			test.log(LogStatus.PASS, "Email was submit successfully");
		} catch (Exception exp) {
			test.log(LogStatus.FAIL, "Problem with email , Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with email , See Report for more Details");
		}
	}

	private void enterPhone(String phone2) throws ParserConfigurationException, SAXException, IOException {
		try {
			Phone.sendKeys(phone2);
			test.log(LogStatus.PASS, "Phone was submit successfully");
		} catch (Exception exp) {
			test.log(LogStatus.FAIL, "Problem with phone , Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with phone , See Report for more Details");
		}
	}

	private void enterFirstName(String firstName2) throws ParserConfigurationException, SAXException, IOException {
		try {
			FirstName.sendKeys(firstName2);
			test.log(LogStatus.PASS, "First name was submit successfully");
		} catch (Exception exp) {
			test.log(LogStatus.FAIL, "Problem with first name , Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with first name , See Report for more Details");
		}
	}

	private void enterLastName(String lastName2) throws ParserConfigurationException, SAXException, IOException {
		try {
			LastName.sendKeys(lastName2);
			test.log(LogStatus.PASS, "Last name was submit successfully");
		} catch (Exception exp) {
			test.log(LogStatus.FAIL, "Problem with first name , Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with first name , See Report for more Details");
		}
	}

	private void clickContinue() throws ParserConfigurationException, SAXException, IOException {
		try {
			Continue.click();
			test.log(LogStatus.PASS, "Continue was successfully");
		} catch (Exception exp) {
			test.log(LogStatus.FAIL, "Problem with continue , Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with continue , See Report for more Details");
		}
	}

}
