import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerUse {

	public static void main(String[] args) throws InterruptedException {

		//		System.setProperty("webdriver.chrome.driver", "C:/Program Files/webdrivers/chromedriver.exe");

		WebDriverManager.chromedriver().setup(); // equivalent to System.setProperty(..)
		WebDriverManager.firefoxdriver().setup(); // equivalent to System.setProperty(..)
		WebDriverManager.iedriver().setup(); // equivalent to System.setProperty(..)
		WebDriverManager.edgedriver().setup(); // equivalent to System.setProperty(..)

		//		WebDriver driver = new ChromeDriver();
		//        FirefoxDriver driver = new FirefoxDriver();
		//        InternetExplorerDriver driver = new InternetExplorerDriver();
		EdgeDriver driver = new EdgeDriver();

		System.out.println("the property for chrome is: " + System.getProperty("webdriver.chrome.driver"));
		System.out.println("the property for firefox is: " + System.getProperty("webdriver.gecko.driver"));
		System.out.println("the property for explorer is: " + System.getProperty("webdriver.ie.driver"));
		System.out.println("the property for edge is: " + System.getProperty("webdriver.edge.driver"));

		System.out.println("System.getProperties() are: " + "\n" + System.getProperties());

		driver.get("http://demo.guru99.com/test/ajax.html");
		List<WebElement> elements = driver.findElements(By.name("name"));
		System.out.println("Number of elements:" + elements.size());

		Thread.sleep(2000);
		driver.quit();
	}
}
