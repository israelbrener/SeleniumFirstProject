import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassOnWebElements {

	public static void main(String[] args) throws InterruptedException {
		// Define the driver to work with Chrome
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Manage Driver
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Get URL
		driver.get("https://www.timeanddate.com/weather/");
		// Select item
		WebElement homeMenu = driver.findElement(By.linkText("Home"));

		Actions action = new Actions(driver);
		action.moveToElement(homeMenu).perform();
		Point location = homeMenu.getLocation();
		int x = location.getX();
		int y = location.getY();
		System.out.println("Coordinates of an element is: " +"\n x "  + x + " \n and y " +y);

		WebElement aboutUs = driver.findElement((By.linkText("About Us")));
		action.click(aboutUs).perform();

		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}
}
