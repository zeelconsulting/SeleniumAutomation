package pages;


import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utils.ReportLog;

public class RegisterPage extends PageObject{
	
	@Steps
	ReportLog report;
	
	@FindBy(id= "newPassword")
	WebElementFacade Newpassword;
	
	
	@FindBy(id= "confirmPassword")
	WebElementFacade confirmPassword;
	
	@FindBy(css = "button[type='submit']")
	WebElementFacade createPcId;

	
	@FindBy(className= "checkbox-group__input-wrapper")
	WebElementFacade agreeCheckbox;
	
	@FindBy(id= "confirmPassword__error")
	WebElementFacade confirmPasswordError;
			
	
	@FindBy(xpath = "//span[text()='Sign In']")
	WebElementFacade signInOnRegisterPage;
	
	
	public void Registerpassword(String Password) {
		Newpassword.sendKeys(Password);
		report.LOG("password is entered");
	}
	
	@Step
	public void clickAgreeCheckbox() {

		
		boolean isSelected = agreeCheckbox.isSelected();
		boolean isDisplayed = agreeCheckbox.isDisplayed();
		boolean isEnabled = agreeCheckbox.isEnabled();
		
		System.out.println(isSelected);
		//performing click operation if element is not checked
		if(isSelected == false) {
			agreeCheckbox.click();
			System.out.println("Checkbox is clicked");
			waitABit(2000);
		}
		
		System.out.println("---------------------");
		System.out.println(isSelected);
		
		if(isSelected == true) {
			agreeCheckbox.click();
			System.out.println("Checkbox is unchecked");
			waitABit(2000);
		}
		
		
		
		// performing click operation if element is displayed
//		if(isDisplayed == true) {
//			agreeCheckbox.click();
//		}
//		// performing click operation if element is enabled
//		if(isEnabled == true) {
//			agreeCheckbox.click();
//		}
		
		waitABit(2000);
		report.LOG("T&C checkbox is clicked");
		System.out.println("T&C checkbox is clicked");
		
		
	}

	@Step
	public void clickCreatePCId() {
		
		createPcId.click();
		report.LOG("Clicked on Create PC Id");

	}

	@Step
	public void clickSignInOnRegisterPage() {
		signInOnRegisterPage.click();
	}
	
	
	public void ConfirmPassword(String Password) {
		confirmPassword.sendKeys(Password);
		report.LOG("password is entered again");
		
		
		
		
	}
	
	public void ConfirmPasswordError() {
		
		String actualText = confirmPasswordError.getText();
		System.out.println(actualText);
		String expectedText = "The passwords above don't match.";
		
		Assert.assertEquals(expectedText, actualText);
	}
	

}
