import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OpenDrivers {

	public static void main(String[] args) throws InterruptedException {

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath is: " + projectPath);

		// open 4 browsers: 1.chrome 2.edge 3.explorer 4.Firefox

		// set 1 chrome
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/webdrivers/chromedriver.exe");
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().maximize();

		driverChrome.get("https://www.walla.co.il/");
		String urlChrome = driverChrome.getCurrentUrl();
		System.out.println("chrome's url is: " + urlChrome);

		// System.out.println("WindowHandle is: "+driverChrome.getWindowHandle());
		// String title = driverChrome.getTitle();
		// System.out.println("title is: " + title);
		//// String pageSource = driverChrome.getPageSource();
		// System.out.println("pageSource is: " + pageSource);

		// set 2 edge
		System.setProperty("webdriver.edge.driver", "C:/Program Files/webdrivers/msedgedriver.exe");
		WebDriver driverEdge = new EdgeDriver();
		driverEdge.manage().window().maximize();

		driverEdge.get("https://www.walla.co.il/");
		System.out.println("edge url is: " + driverEdge.getCurrentUrl());

		System.out.println("WindowHandle is: " + driverChrome.getWindowHandle());
		String title = driverChrome.getTitle();
		System.out.println("title is: " + title);
		String pageSource = driverChrome.getPageSource();
		System.out.println("pageSource is: " + pageSource);

		// set 3 explorer
		System.setProperty("webdriver.ie.driver", "C:/Program Files/webdrivers/IEDriverServer.exe");
		 WebDriver driverExplorer = new InternetExplorerDriver();
		 driverExplorer.manage().window().maximize();
		
		
		 driverExplorer.get("https://www.google.com/");
		 driverExplorer.get("https://www.walla.co.il/");
		 Thread.sleep(2000);
		 String urlExplorer = driverExplorer.getCurrentUrl();
		 System.out.println("explorer's url is: " + urlExplorer);

		// set 4 Firefox
		System.setProperty("webdriver.gecko.driver",
				"C:/Program Files/webdrivers/geckodriver.exe");
		WebDriver driverFirefox = new FirefoxDriver();
		driverFirefox.manage().window().maximize();

		driverFirefox.get("https://www.google.com/");
		driverFirefox.get("https://www.walla.co.il/");
		Thread.sleep(2000);
		String urlFirefox = driverFirefox.getCurrentUrl();
		System.out.println("Firefox's url is: " + urlFirefox);

		// driverChrome.navigate().refresh();
		// driverChrome.close();

		// close specific tab in browser
		// driverExplorer.close();
		// quit all tabs
		driverChrome.quit();
		 driverEdge.quit();
		 driverExplorer.quit();
		driverFirefox.quit();

	}

}
