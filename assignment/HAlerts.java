package week4.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HAlerts {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Thread.sleep(500);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Thread.sleep(1000);
		Alert alertone = driver.switchTo().alert();
		String text = alertone.getText();		
		System.out.println(text);
		alertone.sendKeys("Anju");
		alertone.accept();
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		
		
	}

}
