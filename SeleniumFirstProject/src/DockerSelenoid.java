import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;

import java.util.Map;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DockerSelenoid {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

//		System.setProperty("webdriver.chrome.driver", "C:/Program Files/Selenium/chromedriver_win32/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "opera");
		capabilities.setCapability("browserVersion", "72.0");

		Map<String, Object> of = new HashMap<>();
		of.put("enableVNC", true);
		of.put("enableVideo", true);
		capabilities.setCapability("selenoid:options", of);

		RemoteWebDriver driver = new RemoteWebDriver(URI.create("http://127.0.0.1:4444/wd/hub/").toURL(), capabilities);
//		RemoteWebDriver driver = new RemoteWebDriver(URI.create("http://selenoid:4444/wd/hub").toURL(), capabilities);

		driver.get("http://demo.guru99.com/test/ajax.html");

		List<WebElement> elements = driver.findElements(By.name("name"));
		System.out.println("Number of elements:" + elements.size());

		driver.get("http://www.walla.com");
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(5000);
		driver.quit();
	}
}
