package pageObjects;

import java.awt.AWTException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;
import static org.junit.Assert.fail;
import com.relevantcodes.extentreports.LogStatus;

import utilities.extentReportManager;
import utilities.utils;

//import utilities.utils;

public class homePage extends utils {
	// WebDriverWait wait = new WebDriverWait(driver,20);
	public homePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "q")
	public WebElement searchtext;

	@FindBy(how = How.XPATH, using = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[1]/div/span/svg")
	public WebElement searchclick;

	public void printlinks() {
		
		//Get list of web-elements with tagName  - a
		 List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		  
		 //Traversing through the list and printing its text along with link address
		 for(WebElement link:allLinks){
		 System.out.println(link.getText() + " - " + link.getAttribute("href"));
	}

	public void waitForGithub() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[role='option']")));
		List<WebElement> results = driver.findElements(By.cssSelector("[role='option']"));
	}

	public void validGithub() {

		String expectedLinkText = "https://github.com/SeleniumHQ/selenium";
		Assert.assertEquals(
				driver.findElement(By.xpath("//*[@id=\"rcnt\"]//div[@class='r']/a[1]")).getAttribute("href"),
				expectedLinkText);
	}

	public void clickResult() {

		driver.findElement(By.xpath("//*[@id=\"rcnt\"]//div[@class='r']/a[1]")).click();
	}

	public void validRepo() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/div/div/h1/strong/a")));
	}

	public void clickCloneOrDownload() {

		String expectedRepo = "https://github.com/SeleniumHQ/selenium";
		Assert.assertEquals(
				driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/div/div/h1/strong/a"))
						.getAttribute("href"),
				expectedRepo);

		// click "Clone or Download"
		driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/div/div[5]/details[2]/summary"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"js-repo-pjax-container\"]//input[contains(@aria-label,'Clone')]")));

	}

	public void printUrl() {

		System.out.println(driver
				.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]//input[contains(@aria-label,'Clone')]"))
				.getAttribute("value"));
		driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/div/div[5]/details[2]/summary"))
				.click();
	}

	public void findAndOpen() {

		driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/span[2]/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-issues-search")));
		WebElement webIssue = driver.findElement(By.id("js-issues-search"));
		webIssue.sendKeys("Zooming browsers using short cut keys such as \"CMD+\" does not work");
		webIssue.sendKeys(Keys.ENTER);
		// click on first comment
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"issue_7793\"]/div/div[3]/span[3]/a")));
		driver.findElement(By.xpath("//*[@id=\"issue_7793\"]/div/div[3]/span[3]/a")).click();
	}

	public void printData() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@id,'issuecomment')]")));
		// print the date of the last comment
		WebElement lastComment = driver
				.findElement(By.xpath("//a[contains(@id,'issuecomment')][last()]/relative-time"));
		System.out.println("date of last comment is: " + lastComment.getAttribute("title"));
	}

}
