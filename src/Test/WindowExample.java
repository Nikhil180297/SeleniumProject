package Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement newTab = driver.findElement(By.id("tabButton"));
		
		String PaerentWin = driver.getWindowHandle();
		System.out.println("Parent win is " + PaerentWin);
		
		newTab.click();
		
		Set<String> AllWin = driver.getWindowHandles();
		String childWin= "";
		
		for(String win: AllWin) {
			
			System.out.println("The win ID is " + win);

			if(!win.equals(PaerentWin)) {
				
				childWin = win;
			}
		}
		
		System.out.println("Child win is " + childWin);
		
		driver.switchTo().window(childWin);
		Thread.sleep(3000);
		WebElement childHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println("Header in child win is " + childHeader.getText());
		Thread.sleep(3000);

		driver.close();
		
        driver.switchTo().window(PaerentWin);
		
		WebElement newWindow = driver.findElement(By.id("windowButton"));
		newWindow.click();
		
		AllWin = driver.getWindowHandles();
		for(String win: AllWin) {
			
			System.out.println("The win ID is " + win);
			if(!win.equals(PaerentWin)) {
				childWin = win;
			}
		}
		System.out.println("Child win is " + childWin);
		driver.switchTo().window(childWin);
		Thread.sleep(3000);
		childHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println("Header in child win is " + childHeader.getText());
		Thread.sleep(3000);
		driver.quit();
     
		
		
		/*String PaerentWin = driver.getWindowHandle();
		System.out.println("Parent win is " + PaerentWin);
		
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("arguments[0].scrollIntoView();",newTab);
		
		newTab.click();*/
	}

}
