package com.ShopperStack.GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ShopperStack_POM.Home_Page;
import com.ShopperStack_POM.Login_page;
import com.ShopperStack_POM.Welcome_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Test {
	public File_Utility file = new File_Utility();
	public WebDriver driver;
	public static WebDriver sdriver;
	public Welcome_Page welcomePage;
	public Login_page loginPage;
	public Home_Page homePage;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public Java_Utility javaUtility=new Java_Utility();
	public WebDriver_Utility webdriverUtility=new WebDriver_Utility();
	public WebDriverWait wait;
    
    
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite");
		
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("@beforeTest");
		
		spark=new ExtentSparkReporter(FrameWorkConstants.extentReportspath+javaUtility.localDateTime()+".html");
		reports=new ExtentReports();
		reports.attachReporter(spark);
	}
	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("@BeforeClass");

		// Scanner sc=new scanner(System.in);
		// System.out.println("Enter Valid Browser Name");
		// String browser=sc.next();
		// System.out.println("Number of Browsers");

//		String browserName = file.readPropertyData("browserName");
//		String url = file.readPropertyData("url");

		String browserName = System.getProperty("browser"); //If  we dont want to use property file and we wanna use command line.
		String url = System.getProperty("url");
        
		if (browserName.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.contains("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.contains("edge")) {
			driver = new EdgeDriver();
		}

		else {
			System.out.println("Invalid Browser Name");
		}
		sdriver = driver;
		homePage=new Home_Page(driver);
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {
		System.out.println("@BeforeMethod");

		welcomePage = new Welcome_Page(driver);
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(25));
		wait.until(ExpectedConditions.elementToBeClickable(welcomePage.getLoginbutton()));
		Thread.sleep(2000);
		welcomePage.getLoginbutton().click();

		loginPage=new Login_page(driver);
		loginPage.getEmailTextField().sendKeys(file.readPropertyData("email"));
		loginPage.getPasswordTextField().sendKeys(file.readPropertyData("password"));
		loginPage.getLoginButton().click();
	}
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		System.out.println("@AfterMethod");
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(homePage.getAccountSettings()));
		homePage.getAccountSettings().click();
		homePage.getLogoutButton().click();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("@AfterClass");

		Thread.sleep(3000);
		driver.quit();
		
		}

	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");
		
		reports.flush();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite");
		
		
		
	}
}