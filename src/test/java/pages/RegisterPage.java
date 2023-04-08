package pages;

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
	
	@FindBy(css = "label[for='termsAndConditions']")
	WebElementFacade agreeCheckbox;
	
	@FindBy(id= "termsAndConditions")
	WebElementFacade agree;
			
	
	@FindBy(xpath = "//span[text()='Sign In']")
	WebElementFacade signInOnRegisterPage;
	
	
	public void Registerpassword(String Password) {
		Newpassword.sendKeys(Password);
		report.LOG("password is entered");
	}
	
	@Step
	public void clickAgreeCheckbox() {
		agreeCheckbox.click();
		report.LOG("T&C checkbox is clicked");
	}

	@Step
	public void clickCreatePCId() {
		createPcId.click();
		agree.click();
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

}
