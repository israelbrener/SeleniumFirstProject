import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyboardEventsSendKeys {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:/Program Files/webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// navigate to AUT URL
		driver.get("https://www.wikipedia.org/");

		// Get the locator value of Search box and store it in a variable
		WebElement searchBox = driver.findElement(By.name("search"));

		// Use sendKeys method to enter the search text and simulate the Enter key press
		// event
		searchBox.sendKeys("selenium");
		searchBox.sendKeys(Keys.ENTER);

		// Use Keys.chord() to simulate Ctrl+A and store the output in a String variable
		String selectAll = Keys.chord(Keys.CONTROL, "a");

		// Wait until Article link is loaded
		WebDriverWait wait = new WebDriverWait(driver, 10L);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//li[@id='ca-nstab-main']//a[contains(text(), 'Article')]")));

		// Locate the desired object/ webelement and store in a variable
		WebElement articleLink = driver
				.findElement(By.xpath("//li[@id='ca-nstab-main']//a[contains(text(), 'Article')]"));

		// Send the Select All command to this webelement
		articleLink.sendKeys(selectAll);
		
		Thread.sleep(2000);

		driver.quit();

	}
}