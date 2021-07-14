//דוגמה לתוכנית פשוטה על מנת לבדוק שסלניום עובד
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateInBrowser {

	public static void main(String[] args) {
		// define the driver to work with Chrome
		// שימו לב למיקום הדרייבר על המחשב שלכם
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		

		driver.manage().window().maximize();

		// navigate to https://www.bing.com
		driver.get("https://www.bing.com");

		// print url's title & GUID
		System.out.println("Page #1 title: " + driver.getTitle());
		System.out.println("Page #1 GUID: " + driver.getWindowHandle());

		// print url's address
		System.out.println("Page #1 address is: " + driver.getCurrentUrl());

		// navigate to https://www.google.com
		driver.get("https://www.google.com");

		// print url's address
		System.out.println("Page #2 address is:" + driver.getCurrentUrl());

		// navigate back (i.e.to bing)
		driver.navigate().back();
		System.out.println("Page #3 address is:" + driver.getCurrentUrl());

		// navigate forward (i.e.to google)
		driver.navigate().forward();

		System.out.println("Page #4 address is:" + driver.getCurrentUrl());
		System.out.println("the system getProperties is: "+System.getProperties().getProperty("webdriver.chrome.driver"));
		// driver.close();
		driver.quit();	

	}
}
