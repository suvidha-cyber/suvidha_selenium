package com.ShopperStack_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//span[contains(@class,'BaseBadge-badge')]")
	private WebElement accountSettings;
	
	@FindBy(xpath="//li[text()='My Profile']")
	private WebElement myprofileButton;
	
	@FindBy(xpath="//li[text()='Logout']")
	private WebElement logoutButton;

	public WebElement getAccountSettings() {
		return accountSettings;
	}

	
	public WebElement getMyprofileButton() {
		return myprofileButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	

}
