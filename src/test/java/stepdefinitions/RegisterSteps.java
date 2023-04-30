package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.Product;
import utils.ReportLog;
import utils.CommonMethods;
import net.serenitybdd.core.pages.PageObject;


public class RegisterSteps extends PageObject {

	@Steps
	HomePage home;
	@Steps
	LoginPage login;
	@Steps
	RegisterPage register;
	@Steps
	ReportLog report;
	@Steps
	Product search;
	@Steps
	CommonMethods common;



	@Given("User launches Loblaws url")
	public void user_launches_loblaws_url() {

		home.openApplication();


	}
	@When("User clicks on Sign In page")
	public void user_clicks_on_sign_in_page() {
		home.clickSignIn();


	}
	@Then("User Clicks on Create PC id")
	public void user_clicks_on_create_pc_id() {
		login.clickCreatePCId();


	}


	@Then("User creates an account by providing enter {string},{string} and {string}")
	public void user_creates_an_account_by_providing_enter_and(String email, String password, String confirmPassword) {


		login.EnterUsername1(email);
		register.Registerpassword(password);
		register.ConfirmPassword(confirmPassword);
		System.out.println("password details entered");

		if (!password.equals(confirmPassword)) {
			System.out.println("Password not matching");
		}
	}

	@Then("validates the error message on register page")
	public void validates_the_error_message_on_register_page() {
		register.ConfirmPasswordError();
	}


	@Then("user clicks on Agree checkbox")
	public void user_clicks_on_agree_checkbox() {
		register.clickAgreeCheckbox();
		
		
	}

	@Then("user clicks creates PC id button")
	public void user_clicks_creates_pc_id_button() {
		register.clickCreatePCId();
		common.closebrowser();
	}


	@Then("User enters {string} and {string} to login")
	public void user_enters_and_to_login(String email, String password) {
		waitABit(3000);
		login.EnterUsername(email);
		login.Enterpassword(password);
		login.clickSignIn();
	}
	@Then("User click on My Account")
	public void user_click_on_my_account() {
		home.clickMyAccount();  
	}

	@Then("User click on {string} in My Account")
	public void user_click_on_in_my_account(String Options) {
		home.selectOptionsFromMyAccount(Options);
	}


	@Then("Get FirstName LastName and PhoneNumber from profile")
	public void get_first_name_last_name_and_phone_number_from_profile() {

	}

	@When("user searched {string} in search for product bar")
	public void user_searched_in_search_for_product_bar(String productName) {
		home.searchProduct(productName);
	}

	@Then("search results are displayed")
	public void search_results_are_displayed() {
		search.getListOfProducts();

	}
	@Then("user clicks on sorting dropdown and validate all values in dropdown are displayed")
	public void user_clicks_on_sorting_dropdown_and_validate_all_values_in_dropdown_are_displayed() {
		home.validateSortDropdown();
	}

	@Then("user selects {string} from dropdown")
	public void user_selects_from_dropdown(String SortOption) {
		home.selectSortByOption(SortOption);

	}

	@Then("user add {string} to the cart")
	public void user_add_to_the_cart(String selectedProduct) {
		search.AddToCart(selectedProduct);

	}
	
	@Given("User launches Loblaws url for page navigation")
	public void user_launches_loblaws_url_for_page_navigation() {
		
		home.openApplication();
		home.clickSignIn();
		common.navigateBackward();
		common.navigateForward(); // came back to signIn page
		login.clickCreatePCId();
		common.navigateBackward(); //came back to signIn page
		common.navigateForward(); // went back to register page
		common.refreshPage();
		common.closebrowser();
		

		
	}

}
