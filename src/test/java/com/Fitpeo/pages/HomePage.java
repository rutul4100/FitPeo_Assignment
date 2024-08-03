package com.Fitpeo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest{
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	
	@FindBy(xpath="//div[text()='Revenue Calculator']")
	WebElement revenueCalculator;
	
	@FindBy(xpath="//body/div/div/header/div/p[4]/p")
	WebElement totalReccuringReimbursement;
	
	@FindBy(xpath="//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-sy3s50']")
	WebElement slider;
	
	@FindBy(xpath="//body/div/div/div/div[2]/div/div/div/div/input")
	WebElement textField;
	
	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	WebElement CPT99091CheckBox;
	
	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	WebElement CPT99453CheckBox;
	
	@FindBy(xpath="(//input[@type='checkbox'])[3]")
	WebElement CPT99454CheckBox;
	
	@FindBy(xpath="(//input[@type='checkbox'])[8]")
	WebElement CPT99474CheckBox;
	
	@SuppressWarnings("deprecation")
	public void navigateToRevenueCalculator() {
		revenueCalculator.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void moveSliderTo820() {
		int target=820;
		String textFieldValue = textField.getAttribute("value");
		Actions act = new Actions(driver);
		act.clickAndHold(slider).build().perform();
		while(Integer.parseInt(textFieldValue) != target-1)
		{
			textFieldValue = textField.getAttribute("value");
			act.sendKeys(Keys.ARROW_RIGHT).build().perform();
		}
		if(Integer.parseInt(textFieldValue)==target-1) {
			System.out.println("Bottom text field value updated to 820");
		}
	}
	
	public void addValue560ToTextField() throws InterruptedException {
		Actions act = new Actions(driver);
		textField.click();
		int length = textField.getAttribute("value").length(); 
		for(int i = 1 ; i <= length ; i++) {
			act.sendKeys(Keys.BACK_SPACE).build().perform();
		}
		textField.sendKeys("560");
	}
	
	public void validateSliderValue() throws InterruptedException {
		if(Integer.parseInt(textField.getAttribute("value"))==560) {
			System.out.println("Slider's position is updated to reflect the value 560");
		}
		Thread.sleep(2500);
	}
	
	public void selectCptCheckbox() throws InterruptedException {
		Actions act = new Actions(driver);
			act.scrollToElement(CPT99091CheckBox).build().perform();
			CPT99091CheckBox.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			CPT99453CheckBox.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			CPT99454CheckBox.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			act.scrollToElement(CPT99474CheckBox).build().perform();
			CPT99474CheckBox.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(2500);
			
	}
	public void validate() {
		Actions act = new Actions(driver);
		act.scrollToElement(textField).build().perform();
		textField.click();
		int length = textField.getAttribute("value").length(); 
		for(int i = 1 ; i <= length ; i++) {
			act.sendKeys(Keys.BACK_SPACE).build().perform();
		}
		textField.sendKeys("820");
	}
	
	public void verifyHeader() {
		Actions act = new Actions(driver);
		act.scrollToElement(CPT99454CheckBox).build().perform();
		System.out.println( totalReccuringReimbursement.getText());
		String totalReccuringValue = totalReccuringReimbursement.getText();
		if(totalReccuringValue.equalsIgnoreCase("$110700")) {
			System.out.println("Total Recurring Reimbursement for all Patients Per Month:"+totalReccuringValue);
		}
	}
}
