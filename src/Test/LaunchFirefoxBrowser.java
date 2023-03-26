package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefoxBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MICROSECONDS);
		
		WebElement loginlink = driver.findElement(By.linkText("Log in"));
		String location = loginlink.getAttribute("href");
		System.out.println("the link will take you to" + location);
		loginlink.click();
		
		Thread.sleep(3000);
		
		WebElement UserName= driver.findElement(By.className("email"));
		UserName.sendKeys("ABC@XYZ.com");
		
		WebElement UserPwd= driver.findElement(By.id("password"));
		UserPwd.sendKeys("Abc@1234");
		
		WebElement RemMe = driver.findElement(By.className("rememberMe"));
		RemMe.click();
		
		WebElement loginBtn = driver.findElement(By.name("btn_login"));
		loginBtn.click();
		
		WebElement error = driver.findElement(By.className("error_msg"));
		String errorMsg = error.getText();
        String expErrorMsg = "The email or password you have entered is invalid.";
		
		if(error.isDisplayed() && errorMsg.equals(expErrorMsg)) {
			
			System.out.println("TC Passed");
		}else {
			
			System.out.println("TC Failed");
		}
		
		List<WebElement> AllLinks = driver.findElements(By.tagName("a"));
	    System.out.println("Total no of links are : "+AllLinks.size());	
	
		driver.close();
		
	}

}
