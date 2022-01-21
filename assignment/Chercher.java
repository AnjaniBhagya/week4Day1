package week4.day1.assignment;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chercher
{
	public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
	driver.switchTo().frame("frame1");
	driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("My Topic");
	driver.switchTo().frame("frame3");
	driver.findElement(By.xpath("//input[@id='a']")).click();
	driver.switchTo().parentFrame();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("frame2");
	WebElement ele = driver.findElement(By.id("animals"));
	Select dd = new Select(ele);
	dd.selectByValue("avatar");
	File screenshotfile = driver.getScreenshotAs(OutputType.FILE);
	File Destfile = new File("./images/Chercher.png");
	FileUtils.copyFile(screenshotfile, Destfile);
	
	
		
	}

}
