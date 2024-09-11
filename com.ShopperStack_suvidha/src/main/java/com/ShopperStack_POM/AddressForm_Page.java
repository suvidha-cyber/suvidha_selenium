package com.ShopperStack_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressForm_Page {
public AddressForm_Page(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
@FindBy(id="Office")
private WebElement officeButton;

@FindBy(id="Name")
private WebElement nameTextField;

@FindBy(xpath="//input[contains(@id,'House')]")
private WebElement houseTextField;

@FindBy(xpath="//input[contains(@id,'Street')]")
private WebElement streetTextField;

@FindBy(xpath="//input[@id='Landmark']")
private WebElement landmarkTextField;

@FindBy(id="Country")
private WebElement countryDropDown;

@FindBy(id="State")
private WebElement stateDropDown;

@FindBy(id="City")
private WebElement citydropDown;

@FindBy(id="Pincode")
private WebElement pincodeTextField;

@FindBy(id="Phone Number")
private WebElement phoneNumberTextField;

@FindBy(id="addAddress")
private WebElement addAddressButton;

public WebElement getOfficeButton() {
	return officeButton;
}

public WebElement getNameTextField() {
	return nameTextField;
}

public WebElement getHouseTextField() {
	return houseTextField;
}

public WebElement getStreetTextField() {
	return streetTextField;
}

public WebElement getLandmarkTextField() {
	return landmarkTextField;
}

public WebElement getCountryDropDown() {
	return countryDropDown;
}

public WebElement getStateDropDown() {
	return stateDropDown;
}

public WebElement getCitydropDown() {
	return citydropDown;
}

public WebElement getPincodeTextField() {
	return pincodeTextField;
}

public WebElement getPhoneNumberTextField() {
	return phoneNumberTextField;
}

public WebElement getAddAddressButton() {
	return addAddressButton;
}


}
