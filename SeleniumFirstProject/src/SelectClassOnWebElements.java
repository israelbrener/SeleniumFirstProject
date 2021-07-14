import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassOnWebElements {

	public static void main(String[] args) {
		// Define the driver to work with Chrome
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Manage Driver
		driver.manage().window().maximize();

		// Get URL
		driver.get("https://www.timeanddate.com/weather/");

		// Select item
		WebElement selectBefore = driver.findElement(By.id("sort"));
		Select selectAfter = new Select(selectBefore);
		selectAfter.selectByVisibleText("Country");

		// driver.close();
		driver.quit();
	}
}
