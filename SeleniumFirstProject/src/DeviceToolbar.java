import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeviceToolbar {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Program Files/webdrivers/chromedriver.exe");

		Map<String, String> mobileEmulation = new HashMap<>();
//		mobileEmulation.put("deviceName", "iPad");
		mobileEmulation.put("deviceName", "iPhone X");
//		mobileEmulation.put("deviceName", "Moto G4");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();

		driver.get("https://www.walla.co.il/");
		Thread.sleep(2000);

		driver.quit();

	}

}
