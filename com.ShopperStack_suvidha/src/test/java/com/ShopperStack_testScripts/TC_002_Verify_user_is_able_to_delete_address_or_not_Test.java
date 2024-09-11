package com.ShopperStack_testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ShopperStack.GenericUtility.Base_Test;
import com.ShopperStack_POM.MyAddress_Page;
import com.ShopperStack_POM.My_ProfilePage;

public class TC_002_Verify_user_is_able_to_delete_address_or_not_Test extends Base_Test {
	@Test
	public void deleteAddress() throws InterruptedException, IOException {

		homePage.getAccountSettings().click();
		homePage.getMyprofileButton().click();

		My_ProfilePage myProfilePage = new My_ProfilePage(driver);
		myProfilePage.getMyAddressButton().click();

		Thread.sleep(2000);
		MyAddress_Page myAddressPage = new MyAddress_Page(driver);
		myAddressPage.getDeleteButton().click();
		Thread.sleep(2000);
		myAddressPage.getYesButton().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		webdriverUtility.takeWebPageScreenShot();

	}
}