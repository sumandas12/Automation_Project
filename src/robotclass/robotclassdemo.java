package robotclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class robotclassdemo {

	private static Robot r2;

	public static void browserAppLaunchNew() throws AWTException, Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
		
		r2 = null;
		r2.keyPress(KeyEvent.VK_TAB);
		r2.keyPress(KeyEvent.VK_TAB);
		r2.keyPress(KeyEvent.VK_TAB);
		r2.keyPress(KeyEvent.VK_TAB);
		r2.keyPress(KeyEvent.VK_TAB);
		r2.keyPress(KeyEvent.VK_TAB);
		r2.keyPress(KeyEvent.VK_TAB);
		r2.keyPress(KeyEvent.VK_TAB);
		r2.keyPress(KeyEvent.VK_TAB);
		r2.keyPress(KeyEvent.VK_TAB);
		r2.keyPress(KeyEvent.VK_TAB);
		r2.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r2.keyPress(KeyEvent.VK_D);
		Thread.sleep(3000);
		r2.keyPress(KeyEvent.VK_A);
		r2.keyPress(KeyEvent.VK_S);
		Thread.sleep(3000);
		r2.keyPress(KeyEvent.VK_D);
		Thread.sleep(3000);
		r2.keyPress(KeyEvent.VK_TAB);
		r2.keyPress(KeyEvent.VK_D);
		Thread.sleep(3000);
		r2.keyPress(KeyEvent.VK_A);
		Thread.sleep(3000);
		r2.keyPress(KeyEvent.VK_S);
		Thread.sleep(3000);
		r2.keyPress(KeyEvent.VK_D);
		Thread.sleep(3000);
		r2.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r2.keyPress(KeyEvent.VK_ENTER);
		
		//Took_Screenshot
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("screenshots/snap3.jpg"));
		Thread.sleep(3000);
		
		
		
	}

	
}
