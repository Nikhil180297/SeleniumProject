package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement  Element = driver.findElement(By.id("alertButton"));
		Element.click();
		
		Alert obj = driver.switchTo().alert();
		Thread.sleep(3000);
		obj.accept();
		
		WebElement  Element1 = driver.findElement(By.id("confirmButton"));
		Element1.click();
		
		Alert obj1 = driver.switchTo().alert();
		Thread.sleep(3000);
		obj1.dismiss();
	}

}
