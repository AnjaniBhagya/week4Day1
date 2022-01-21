package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameExercise {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/frame.html");
		WebElement framele = driver.findElement(By.xpath("(//div[@id='wrapframe']/iframe)[1]"));
		driver.switchTo().frame(framele);
		WebElement btnele = driver.findElement(By.id("Click"));
		File srcbtnimg = btnele.getScreenshotAs(OutputType.FILE);
		File destimg = new File("./images/FrameButton.png");
		FileUtils.copyFile(srcbtnimg, destimg);
		driver.switchTo().defaultContent();
		List<WebElement> framelist = driver.findElements(By.xpath("//iframe"));
		int size = framelist.size();
		System.out.println(size);

	}

}
