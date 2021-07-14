import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {

	public static void main(String[] args) throws InterruptedException {
		// define the driver to work with Chrome
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

		// navigate to https://www.bing.com
		driver.get("https://www.bing.com");
		WebElement we = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));

		// Synchronization - 3 ways for waiting to the DOM:
		// #1 - Sleep: make the script sleep (stop) for x milliseconds
		Thread.sleep(1000);
		// #2 - Implicit wait: change the setting of the WebDriver to wait when not find
		// an element
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		// #3 - Explicit wait: wait x max of seconds until web element will appear
		// on page (DOM)
		//		WebDriverWait waitDriver = new WebDriverWait(driver, 10);
		//		WebElement we2;
		//		we2 = waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sb_form_q\"]")));
		//		we2.clear();

		we.sendKeys("go microsoft");
		driver.findElement(By.cssSelector("#sb_form > label > svg")).click();
		Thread.sleep(2000);
		System.out.println("Page #1 address is: " + driver.getCurrentUrl());

		WebDriverWait waitDriver = new WebDriverWait(driver, 10);
		WebElement we2;
		we2 = waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sb_form_q")));
		we2.clear();
		Thread.sleep(2000);
		System.out.println("Page #2 address is: " + driver.getCurrentUrl());

		driver.quit();

	}
}
