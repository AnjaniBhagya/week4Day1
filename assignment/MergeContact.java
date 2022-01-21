package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebDriverManager.chromedriver().setup();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		 driver.findElement(By.id("password")).sendKeys("crmsfa");
		   driver.findElement(By.className("decorativeSubmit")).click();
		   driver.findElement(By.linkText("CRM/SFA")).click();
		   driver.findElement(By.linkText("Contacts")).click();
		   driver.findElement(By.linkText("Merge Contacts")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
		   Thread.sleep(5000);
		   Set<String> winh = driver.getWindowHandles();
		   List<String> chrref = new ArrayList<String>(winh);		   
		   driver.switchTo().window(chrref.get(1));
		   driver.findElement(By.xpath("(//a[@class='linktext' ])[1]")).click();
		   driver.switchTo().window(chrref.get(0));
		   //second widget click
		   driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
		   Thread.sleep(5000);
		   Set<String> winh2 = driver.getWindowHandles();
		   
		   List<String> chrref2 = new ArrayList<String>(winh2);	
		   driver.switchTo().window(chrref2.get(1));
		   driver.findElement(By.xpath("(//a[@class='linktext' ])[5]")).click();		   
		   driver.switchTo().window(chrref2.get(0));
		   driver.findElement(By.xpath("//a[text()='Merge']")).click();
		   Thread.sleep(2000);
		   driver.switchTo().alert().accept();	  
		   String title = driver.getTitle();
		   System.out.println(title);		   

	}

}
