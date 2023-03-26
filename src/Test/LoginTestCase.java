package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.setProperty("webdriver.chrome.driver","chromerdriver.exe");
     WebDriver driver = new ChromeDriver();
     
     driver.get("https://www.simplilearn.com/");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MICROSECONDS);
	
     WebElement loginlink = driver.findElement(By.linkText("Log in"));
	}

}
