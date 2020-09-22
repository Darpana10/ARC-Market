package com.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginDemo {
	WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) throws InterruptedException
	{
		
		if (browser.equalsIgnoreCase("chrome"))
		{
			//setup the chromedriver using WebDriverManager
	        WebDriverManager.chromedriver().setup();
	        //Create driver object for Chrome
	        driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(90,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(90 ,TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(90,TimeUnit.SECONDS);	
			driver.manage().window().maximize();
			
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			//setup the firefoxdriver using WebDriverManager
			WebDriverManager.firefoxdriver().setup();
			//Create driver object for firefox
			driver = new FirefoxDriver();
			
				driver.manage().timeouts().pageLoadTimeout(90,TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(90 ,TimeUnit.SECONDS);
				driver.manage().timeouts().setScriptTimeout(90,TimeUnit.SECONDS);	
				driver.manage().window().maximize();
		}

		driver.get("https://dev-sherian-fm-wam.azurewebsites.net/Account/Login");
	}
	
	@Test
	public void loginDemoTest() throws InterruptedException
	{
		System.out.println("Execution Start on azure again:");
		//Login Balnk 
				WebElement userNameBlank = driver.findElement(By.id("username"));
				userNameBlank.sendKeys("");
				WebElement passWordBlank = driver.findElement(By.id("password"));
				passWordBlank.sendKeys("");
				WebElement clickOnLoginButtonn = driver.findElement(By.xpath("//button[contains(@class,'liquid_btn btn-block')]"));
				clickOnLoginButtonn.click();
				Thread.sleep(6000);
		// Login With Invalid UserName
				System.out.println("Enter Invalid Username and Valid Password");
		WebElement userNameInvalid = driver.findElement(By.id("username"));
		userNameInvalid.clear();
		userNameInvalid.sendKeys("InValidAgent");
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.clear();
		passWord.sendKeys("Password1");
		WebElement clickOnLogin = driver.findElement(By.xpath("//button[contains(@class,'liquid_btn btn-block')]"));
		clickOnLogin.click();
		Thread.sleep(6000);
		// Login With Invalid Password
		driver.get("https://dev-sherian-fm-wam.azurewebsites.net/Account/Login");
		System.out.println("Enter valid Username and inValid Password");
		WebElement userNameValid = driver.findElement(By.id("username"));
		userNameValid.clear();
		userNameValid.sendKeys("Agent2");
		WebElement passWordInvalid = driver.findElement(By.id("password"));
		passWordInvalid.clear();
		passWordInvalid.sendKeys("");
		WebElement clickOnLoginButton = driver.findElement(By.xpath("//button[contains(@class,'liquid_btn btn-block')]"));
		clickOnLoginButton.click();
		Thread.sleep(6000);
		// Valid Login 
		driver.get("https://dev-sherian-fm-wam.azurewebsites.net/Account/Login");
		System.out.println("Valid Login");
				WebElement userNameValidd = driver.findElement(By.id("username"));
				userNameValidd.clear();
				userNameValidd.sendKeys("Agent2");
				WebElement passWordValid= driver.findElement(By.id("password"));
				passWordValid.clear();
				passWordValid.sendKeys("Password1");
				WebElement clickOnLoginButto = driver.findElement(By.xpath("//button[contains(@class,'liquid_btn btn-block')]"));
				clickOnLoginButto.click();
		
		
	}

	
	
}
