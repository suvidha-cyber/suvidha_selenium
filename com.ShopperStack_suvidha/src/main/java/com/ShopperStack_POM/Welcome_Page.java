package com.ShopperStack_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Welcome_Page {
public Welcome_Page(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
	
}

@FindBy(id = "loginBtn")
private WebElement loginbutton;

public WebElement getLoginbutton() {
	return loginbutton;
}


}