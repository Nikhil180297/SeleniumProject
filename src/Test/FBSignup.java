package Test;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chromer.driver","chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MICROSECONDS);
		
		WebElement SignUp = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		SignUp.click();
	    Thread.sleep(3000);
		WebElement fName = driver.findElement(By.xpath("//input[@name='firstname']"));
		Thread.sleep(3000);
		WebElement lName = driver.findElement(By.xpath("//input[@name='lastname']"));
		Thread.sleep(3000);
		WebElement mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		
		fName.sendKeys("John");
		lName.sendKeys("White");
		mobile.sendKeys("99999999999");
		password.sendKeys("Anc@1234");
		
		WebElement selectedDay = driver.findElement(By.xpath("//select[@title='Day']/option[@selected='1']"));
		System.out.println("the default day is :"+ selectedDay.getText());
		
		WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
		Select ddDay = new Select(day);
		ddDay.selectByVisibleText("16");
		
		WebElement month = driver.findElement(By.xpath("//select[@title='Month']"));
		Select mmMonth = new Select(month);
		mmMonth.selectByVisibleText("Feb");
		
		WebElement year = driver.findElement(By.xpath("//select[@title='Year']"));
		Select yYear = new Select(year);
		yYear.selectByValue("1997");
		
		List<WebElement> Allmonth = driver.findElements(By.xpath("//select[@title='Month']/option"));
	    System.out.println("Total no of month are : "+Allmonth.size());	
	    for (WebElement month1:Allmonth) { 
	    	//or we can use this -->System.out.println(link.getAttribute("href");
			String i = month1.getText();
			System.out.println(i);
	    }
	    
	   /* WebElement Male = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));//  u can use this xpath-->"//label[text()='Male']"
	    Male.click();*/
	    
	    
	    String Gender = "Male";
	    
	    String gendreXpath = "//label[text()='Placeholder']";  // instead of using this String newXpath = "//label[text()='" + Gender + "']";
	    
	    String newXpath = gendreXpath.replace("Placeholder",Gender);
	  
	    WebElement genderElem = driver.findElement(By.xpath(newXpath));
		genderElem.click();
		
        /*WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
		Select ddDay = new Select(day);
		ddDay.selectByVisibleText("10");
		//ddDay.selectByValue("10")
		
		WebElement Month = driver.findElement(By.xpath("//select[@title='Month']"));
		Select mMonth = new Select(Month);
		mMonth.selectByVisibleText("Jan");
		//ddDay.selectByValue("10")
		
		WebElement Year = driver.findElement(By.xpath("//select[@title='Year']"));
		Select yYear = new Select(Year);
		yYear.selectByVisibleText("2022");
		//ddDay.selectByValue("10")*/
	}

}
