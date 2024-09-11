package com.ShopperStack_testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.ShopperStack.GenericUtility.Base_Test;
import com.ShopperStack_POM.AddressForm_Page;
import com.ShopperStack_POM.MyAddress_Page;
import com.ShopperStack_POM.My_ProfilePage;
import com.aventstack.extentreports.Status;

public class TC_001_Verify_user_is_able_to_add_address_or_not_Test extends Base_Test {
	@Test
	public void addAddresses() throws EncryptedDocumentException, IOException, InterruptedException {
		test = reports.createTest("AddAddress");
		test.log(Status.PASS, "Login Done Successfully");

		homePage.getAccountSettings().click();
		homePage.getMyprofileButton().click();

		test.log(Status.INFO, "Navigated to My Profile Page");

		My_ProfilePage myProfilePage = new My_ProfilePage(driver);
		myProfilePage.getMyAddressButton().click();

		test.log(Status.INFO, "Navigated to My Address Page");

		MyAddress_Page myAddressPage = new MyAddress_Page(driver);
		myAddressPage.getAddAddressButton().click();

		test.log(Status.INFO, "Navigated to My Address Form Page");

		AddressForm_Page addressFormPage = new AddressForm_Page(driver);
		addressFormPage.getOfficeButton().click();

		addressFormPage.getNameTextField().sendKeys(file.readExcelData("Sheet1", 1, 0));
		addressFormPage.getHouseTextField().sendKeys(file.readExcelData("Sheet1", 1, 1));
		addressFormPage.getStreetTextField().sendKeys(file.readExcelData("Sheet1", 1, 2));
		addressFormPage.getLandmarkTextField().sendKeys(file.readExcelData("Sheet1", 1, 3));

		webdriverUtility.selectByValue(addressFormPage.getCountryDropDown(), file.readExcelData("Sheet1", 1, 4));
		webdriverUtility.selectByValue(addressFormPage.getStateDropDown(), file.readExcelData("Sheet1", 1, 5));
		webdriverUtility.selectByValue(addressFormPage.getCitydropDown(), file.readExcelData("Sheet1", 1, 6));

		addressFormPage.getPincodeTextField().sendKeys(file.readExcelData("Sheet1", 1, 7));
		addressFormPage.getPhoneNumberTextField().sendKeys(file.readExcelData("Sheet1", 1, 8));
		addressFormPage.getAddAddressButton().click();
		Thread.sleep(3000);
		webdriverUtility.takeWebPageScreenShot();

	}
}