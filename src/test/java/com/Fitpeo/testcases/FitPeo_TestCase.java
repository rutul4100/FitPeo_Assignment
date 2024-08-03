package com.Fitpeo.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.Fitpeo.pages.BaseTest;
import com.Fitpeo.pages.HomePage;
import com.Fitpeo.utlities.ConfigDataProvider;

public class FitPeo_TestCase extends BaseTest {
	ConfigDataProvider config = new ConfigDataProvider();
	@Test
	public void demo() throws Exception {
		//1.Open Browser & navigate to fitpeo homepage, validates homepage loaded successfully
		BaseTest bt=new BaseTest();
		Assert.assertEquals(driver.getTitle(), config.getHomePageTitle());
		
		//2.Navigate to the Revenue Calculator Page
		new HomePage(driver).navigateToRevenueCalculator();
		
		//3.Scroll Down to the Slider section
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,480)");
		
		//4.Adjust the Slider
		new HomePage(driver).moveSliderTo820();
		
		//5.Update the Text Field
		new HomePage(driver).addValue560ToTextField();
		
		//6.Validate Slider Value
		new HomePage(driver).validateSliderValue();
		
		//7.Select CPT Codes
		new HomePage(driver).selectCptCheckbox();
		
		//8.Validate Total Recurring Reimbursement
		new HomePage(driver).validate();
		
		//9.Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month: shows the value $110700
		new HomePage(driver).verifyHeader();
		
		
	}
}
