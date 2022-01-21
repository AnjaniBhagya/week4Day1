package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("http://www.leafground.com/pages/Window.html");
		Thread.sleep(2000);
		driver.findElement(By.id("home")).click();
		Thread.sleep(3000);
		System.out.println("WebDriver control is in New Window");
		Set<String> winh = driver.getWindowHandles();
		List<String> s1 = new ArrayList<String>(winh);
		driver.switchTo().window(s1.get(0));
		driver.quit();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver1 = new ChromeDriver();
		driver1.get("http://www.leafground.com/pages/Window.html");
		Thread.sleep(2000);
		driver1.findElement(By.xpath("//button[contains(text(),'Open Multiple Windows')]")).click();
		Thread.sleep(2000);
		driver1.findElement(By.id("home")).click();
		Thread.sleep(2000);
		Set<String> winh2 = driver1.getWindowHandles();
		List<String> s2 = new ArrayList<String>(winh2);
		int size = s2.size();
		System.out.println("Number of windows : "+size);
		driver1.quit();
		Thread.sleep(2000);		
		System.out.println("All windows closed.");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver2 = new ChromeDriver();
		driver2.get("http://www.leafground.com/pages/Window.html");
		Thread.sleep(2000);		
		driver2.findElement(By.id("color")).click();
		Thread.sleep(2000);	
		Set<String> winh3 = driver2.getWindowHandles();
		List<String> s3 = new ArrayList<String>(winh3);
		//driver2.switchTo().window(s3.get(0)).close();
		driver2.switchTo().window(s3.get(0));
		driver2.close();
		driver2.switchTo().window(s3.get(1));
		driver2.close();
		driver2.switchTo().window(s3.get(2));
		
	}

}
