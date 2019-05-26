package com.mercury.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class MR {
	
	static WebDriver driver;

	// ===============================================================================

	public void browserAppLaunch() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
	}

public void login() throws InterruptedException, IOException, AWTException {



//WebElement uName = driver.findElement (By.xpath('//input[@name='userName']"));
	
	  WebElement uName = driver.findElement(By.name("userName"));
	  uName.sendKeys("dasd");
		
//WebElement pwd = driver.findElement (By.xpath('//input[@name='password']"));
	
	  WebElement pwd = driver.findElement(By.name("password"));
	  pwd.sendKeys("dasd");
		
//WebElement login = driver.findElement (By.xpath('//input[@name='Login']"));
	  WebElement login = driver.findElement(By.name("login"));
	  login.click();
	
	 Thread.sleep(3000);
	
	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("screenshots/snap1.png"));
	Thread.sleep(3000);

}
	
		
public void SikuliPractice() throws FindFailed {
	
	WebElement uName = driver.findElement(By.name("userName"));
	  uName.sendKeys("dasd");
	  
	  WebElement pwd = driver.findElement(By.name("password"));
	  pwd.sendKeys("dasd");	  
	  
	  
	  Screen screen = new Screen();
	  Pattern btnlogin = new Pattern("./SikuliFiles/btnlogin.PNG");
	  screen.click(btnlogin);
	
}

public void AutoItPractice () throws InterruptedException, IOException, FindFailed {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://newtours.imgbb.com/");
	
	Thread.sleep(4000);
	
	WebElement btnStartUpload = driver.findElement(By.xpath("//a[@class='btn btn-big blue']"));
	btnStartUpload.click();
	Runtime.getRuntime().exec("./autoITexe/selectandfetchfile.exe");
	Thread.sleep(6000);
	//WebElement btnUpload = driver.findElement(By.xpath("//button[@class='btn btn-big green']"));
	//WebElement btnUpload = driver.findElement(By.xpath("//button[@class='btn btn-big green']"));
	//btnUpload.click();
	//Thread.sleep(5000);
	
	  Screen screen = new Screen();
	  Pattern btnlogin = new Pattern("./SikuliFiles/upload.PNG");
	  screen.click(btnlogin);
	
	
}

/* Verify Login */

public void verifyLogin()
{
	String expTitle = "Find a Flight: Mercury Tours:";
	String actTitle = driver.getTitle();
	
	System.out.println("System returns the page title: "+ actTitle);
	
	if(actTitle.equals(expTitle))
	{
		System.out.println("Test case passed");
	}
	else
	{
		System.out.println("Test case failed");
	}
	
}


/* Verify Login with boolean return type*/

public boolean verifyLoginWithReturn()
{
	String actTitle = "Find a Flight: Mercury Tours:";
	String expTitle = driver.getTitle();
	
	System.out.println("System returns the page title: "+ expTitle);
	
	if(actTitle.equals(expTitle))
	{
		return true;
		//System.out.println("Test case passed");
	}
	else
	{
		//System.out.println("Test case failed");
		return false;
	}
	
}



/*
 * Simple login process with parameter
 */
public void loginMercuryWithParameter(String uname, String password) throws IOException, InterruptedException {
	
	WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));
	
	//WebElement uName = driver.findElement(By.name("userName"));
	uName.sendKeys(uname);
	
	WebElement pwd = driver.findElement(By.name("password"));	
	//WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
	pwd.sendKeys(password);

	WebElement login = driver.findElement(By.name("login"));
	//WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
	login.click();

	Thread.sleep(3000);
}


public static void browserCloseStatic()
{
	driver.close();
}

/*
 * Iframe Handling
*/

public void frameHandling() throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 	driver = new ChromeDriver();
	 	driver.manage().window().fullscreen();
    	driver.get("http://demo.guru99.com/test/guru99home/");
    	Thread.sleep(6000); 
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,2300)");
    	Thread.sleep(6000);  
    	
    	driver.switchTo().frame("a077aa5e");
    	Thread.sleep(4000); 
    	
    	WebElement linkbtn = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
    	linkbtn.click();
    	
    	driver.switchTo().defaultContent();
    	
    	/* Iframe Identification */
    	
    	int size = driver.findElements(By.tagName("iframe")).size();
    	System.out.println(size);
    	
    	List<WebElement> ele = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of frames in a page :" + ele.size());
        for(WebElement el : ele){
            System.out.println("Frame Id :" + el.getAttribute("id"));
            System.out.println("Frame name :" + el.getAttribute("name"));
        }
}

	
}



