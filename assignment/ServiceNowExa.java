package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowExa
{
	public static void main(String[] args) throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://dev83049.service-now.com/login.do?");
		Thread.sleep(2000);		
		driver.findElement(By.id("user_name")).sendKeys("admin");		
		driver.findElement(By.id("user_password")).sendKeys("Anju@admin123");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incidents");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//span[@id='incident_breadcrumb']/a[1]")).click();
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//table[@id='sys_user_table']//tr[1]/td[3]/a")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windows2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(windows2.get(0));
		Thread.sleep(2000);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("My Short Description");	
		String inciNum = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println(inciNum);
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//span[text()='Press Enter from within the input to submit the search.']/following-sibling::input"))
				.sendKeys(inciNum);
		driver.findElement(By.xpath(
				"//span[text()='Press Enter from within the input to submit the search.']/following-sibling::input"))
				.sendKeys(Keys.ENTER);
		String incinum2 = driver.findElement(By.xpath("//table[@id='incident_table']//tr[1]/td[3]")).getText();
		System.out.println(incinum2);
		if(inciNum.equals(incinum2))
		{
			System.out.println("Incident number matches with the retrived number");
		} else {
			System.out.println("Incident number does not matches with the retrived number");
		}
		File screenshotfile = driver.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File("./images/Servicenow.png");
		FileUtils.copyFile(screenshotfile, destinationfile);

		
	}
	
}
