package com.ShopperStack.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {
    Java_Utility javaUtility=new Java_Utility();
	
    public void takeWebPageScreenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) Base_Test.sdriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameWorkConstants.screenshotPath+javaUtility.localDateTime());
		FileHandler.copy(temp, dest);
	}

	public void takeWebElementScreenshot(WebElement element) throws IOException {

		File temp = element.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameWorkConstants.screenshotPath+javaUtility.localDateTime()+".png");
		FileHandler.copy(temp, dest);
	}
	public void selectByValue(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
		
	}
	
	public void selectByIndex(WebElement element,int value)
	{
		Select select = new Select(element);
		select.selectByIndex(value);
		
	}
	
	public void selectByVisibleText(WebElement element,String value)
	{
		Select select = new Select(element);
		select.selectByVisibleText(value);
				
	}
	
	public void deselectByValue (WebElement element,String value)
	{
		
		Select select = new Select(element);
		select.deselectByValue(value);
		
	}
	
	public void deselectByIndex(WebElement element,int value)
	{
		Select select = new Select(element);
		select.deselectByIndex(value);
		
	}
	
	public void deselectByVisibleText(WebElement element,String value)
	{
		Select select = new Select(element);
		select.deselectByVisibleText(value);
				
	}
	
	public void deselectAll(WebElement element)
	{
		
		Select select = new Select(element);
		select.deselectAll();
	}
	
	
	}


