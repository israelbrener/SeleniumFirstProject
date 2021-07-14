import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebPageLocatorsFindElements {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Program Files/webdrivers/chromedriver.exe");	
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://automation.co.il/tutorials/selenium/demo1/indexNoID.html");

		//find an element by cssSelector-id (#+id)
		WebElement firstName = driver.findElement(By.cssSelector("#firstname"));	
		firstName.sendKeys("israel");
		//find an element by id
		WebElement lastName = driver.findElement(By.id("lastname"));
		lastName.sendKeys("brener");

		WebElement email = driver.findElement(By.cssSelector("#email"));
		email.sendKeys("israelBrener@gmail.com");
		Thread.sleep(2000);		
		//find an element by cssSelector-class name(.before each class name+class)
		driver.findElement(By.cssSelector(".btn.btn-next.btn-fill.btn-warning.btn-wd.btn-sm")).click();

		driver.findElement(By.cssSelector(".fa.fa-blind")).click();
		Thread.sleep(2000);
		//find an element by cssSelector-attribute([attribute='value'])
		driver.findElement(By.cssSelector("[name='next']")).click();

		driver.findElement(By.cssSelector("[name='streetname']")).clear();
		driver.findElement(By.cssSelector("[name='streetname']")).sendKeys("truman");
		driver.findElement(By.cssSelector("[name='streetnumber']")).sendKeys("1");
		driver.findElement(By.cssSelector("[name='city']")).sendKeys("Ramat Gan");

		//define a dropdown element by an object 
		Select selectCountry = new Select(driver.findElement(By.cssSelector("#country")));
		//selecting the element by 3 options: 1.index 2.VisibleText 3.value
		//		1.index
		selectCountry.selectByIndex(0);
		Thread.sleep(1000);
		//		2.VisibleText
		selectCountry.selectByVisibleText("Argentina");
		Thread.sleep(1000);
		//		3.value
		selectCountry.selectByValue("Italy");
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("[value='Finish']")).click();
		
		String pageSource =driver.getPageSource();
		System.out.println(pageSource);
		driver.close();

	}

}
