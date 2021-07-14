//דוגמה לתוכנית פשוטה על מנת לבדוק שסלניום עובד
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollByJSExecutor {

	public static void main(String[] args) throws InterruptedException {
		// define the driver to work with Chrome
		// שימו לב למיקום הדרייבר על המחשב שלכם
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		

		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

        //Launch the application		
        driver.get("https://www.browserstack.com/guide/selenium-scroll-tutorial");

        //Locating element by link text and store in variable "element"        		
        WebElement element = driver.findElement(By.linkText("Try Selenium Testing For Free"));

        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", element);
        
        Thread.sleep(3000);
        
		// driver.close();
		driver.quit();	

	}
}
