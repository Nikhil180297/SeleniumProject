package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBlogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromer.driver","chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MICROSECONDS);
		
		WebElement UserName = driver.findElement(By.id("email"));
		UserName.sendKeys("ABC@XYZ.com");
		
		WebElement UserPwd = driver.findElement(By.name("pass"));
		UserPwd.sendKeys("Abc@1234");
		
		WebElement LoginBtn = driver.findElement(By.name("login"));
		LoginBtn.click();
		
	}
}


