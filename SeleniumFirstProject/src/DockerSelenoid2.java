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

public class DockerSelenoid2 {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "opera");
		capabilities.setCapability("browserVersion", "72.0");
		Map<String, Object> of = new HashMap<>();
		of.put("enableVNC", true);
		of.put("enableVideo", true);
		capabilities.setCapability("selenoid:options", of);
		RemoteWebDriver driver = new RemoteWebDriver(URI.create("http://127.0.0.1:4444/wd/hub/").toURL(), capabilities);

		DesiredCapabilities capabilities2 = new DesiredCapabilities();
		capabilities2.setCapability("browserName", "chrome");
		capabilities2.setCapability("browserVersion", "88.0");
		Map<String, Object> of2 = new HashMap<>();
		of2.put("enableVNC", true);
		of2.put("enableVideo", true);
		capabilities2.setCapability("selenoid:options", of2);
		RemoteWebDriver driver2 = new RemoteWebDriver(URI.create("http://127.0.0.1:4444/wd/hub/").toURL(), capabilities2);

		driver.get("http://demo.guru99.com/test/ajax.html");
		driver2.get("http://demo.guru99.com/test/ajax.html");

		List<WebElement> elements = driver.findElements(By.name("name"));
		System.out.println("Number of elements:" + elements.size());
		List<WebElement> elements2 = driver2.findElements(By.name("name"));
		System.out.println("Number of elements:" + elements.size());
		System.out.println("Number of elements2:" + elements2.size());

		driver.get("http://www.walla.com");
		driver2.get("http://www.walla.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver2.getCurrentUrl());
		Thread.sleep(5000);

		driver.quit();
	}
}
