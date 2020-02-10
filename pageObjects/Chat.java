package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;
import com.gargoylesoftware.htmlunit.javascript.host.dom.Text;
import com.relevantcodes.extentreports.LogStatus;
import utilities.extentReportManager;
import utilities.utils;
import static org.junit.Assert.fail;
import utilities.utils;
import java.io.IOException;
import javax.lang.model.element.Element;
import javax.xml.parsers.ParserConfigurationException;

public class Chat extends utils {
	String text;

	public Chat(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "div[data-automation='continue-online']")
	public WebElement Continue;

	@FindBy(how = How.CSS, using = "input[class='MuiInputBase-input-52 MuiOutlinedInput-input-37']")
	public WebElement address;

	@FindBy(how = How.XPATH, using = "//div[@data-automation='neither']")
	public WebElement neither;

	@FindBy(how = How.ID, using = "select_multiple_buttons_schedule_pickup")
	public WebElement pickup;

	@FindBy(how = How.XPATH, using = "//b[contains(.,'Your pickup is confirmed for ')]")
	public WebElement validateMessage;

	@FindBy(how = How.ID, using = "select_multiple_buttons_schedule_pickup")
	public WebElement done;

	public void checkChat() throws ParserConfigurationException, SAXException, IOException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Continue));
			test.log(LogStatus.PASS, "The chat is open");
		} catch (

		Exception exp) {
			test.log(LogStatus.FAIL, "Problem with chat , Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with chat , See Report for more Details");
		}
	}

	public void clickContinue() throws ParserConfigurationException, SAXException, IOException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Continue));
			Continue.click();
			test.log(LogStatus.PASS, "Continue was successfully");
		} catch (

		Exception exp) {
			test.log(LogStatus.FAIL, "Problem with continue , Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with continue , See Report for more Details");
		}
	}

	public void enterAddress(String data) throws ParserConfigurationException, SAXException, IOException {
		try {
			Thread.sleep(5000L);
			// wait.until(ExpectedConditions.visibilityOf(address));
			address.sendKeys(data);
			Thread.sleep(1000L);

			address.sendKeys(Keys.ARROW_UP);
			address.sendKeys(Keys.ENTER);
			address.sendKeys(Keys.ENTER);

			test.log(LogStatus.PASS, "Address was successfully");
		} catch (

		Exception exp) {
			test.log(LogStatus.FAIL, "Problem with address , Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with address , See Report for more Details");
		}
	}

	public void clickNeither() throws ParserConfigurationException, SAXException, IOException, InterruptedException {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(neither));

			neither.click();
			test.log(LogStatus.PASS, "Neither was successfully");
		} catch (Exception exp) {
			test.log(LogStatus.FAIL, "Problem with neither , Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with neither , See Report for more Details");
		}
	}

	public void SelectPickUpTime()
			throws ParserConfigurationException, SAXException, IOException, InterruptedException {
		try {
			Select dropdown = new Select(driver.findElement(By.id("select_multiple_buttons_schedule_pickup")));
			Thread.sleep(1000L);
			dropdown.selectByIndex(1);

			test.log(LogStatus.PASS, "Address was successfully");
		} catch (

		Exception exp) {
			test.log(LogStatus.FAIL, "Problem with address , Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with address , See Report for more Details");
		}
	}

	public void ValidatePickupMessage() throws ParserConfigurationException, SAXException, IOException {
		try {
			Thread.sleep(5000L);
			// wait.until(ExpectedConditions.elementToBeClickable(validateMessage));
			text = validateMessage.getText();
			if (text.contains("Your pickup is confirmed")) {
				System.out.println("The pick up is confirm");
			}
			test.log(LogStatus.PASS, "Validate Pickup Message up time was show ");
		} catch (Exception exp) {
			test.log(LogStatus.FAIL, "Problem with Validate Pickup Message, Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with Validate Pickup Message , See Report for more Details");
		}
	}

	public void endOrder() throws ParserConfigurationException, SAXException, IOException {
		try {
			Select dropdown = new Select(driver.findElement(By.id("select_multiple_buttons_details_correction")));
			Thread.sleep(1000L);
			dropdown.selectByValue("1");

			test.log(LogStatus.PASS, "End order was successfully");
		} catch (

		Exception exp) {
			test.log(LogStatus.FAIL, "Problem with End order , Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with End order , See Report for more Details");
		}
	}
}
