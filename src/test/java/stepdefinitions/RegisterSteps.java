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



	@Given("User launches Loblaws url")
	public void user_launches_loblaws_url() {
		
		home.openApplication();
		
//		open();
//		waitABit(1000);
//		getDriver().manage().window().maximize();
//		waitABit(7000);
//		System.out.println("User launches Loblaws url");
//		report.LOG("User launches Loblaws url");
		

	}
	@When("User clicks on Sign In page")
	public void user_clicks_on_sign_in_page() {
			home.clickSignIn();
		

	}
	@Then("User Clicks on Create PC id")
	public void user_clicks_on_create_pc_id() {
		login.clickCreatePCId();
		

	}
	@Then("User creates an account by providing enter {string} and {string}")
	public void user_creates_an_account_by_providing_enter_and(String email, String password) {
		
		login.setEmail1(email);
		login.EnterUsername1();
		register.Registerpassword(password);
		register.ConfirmPassword(password);
		

	}
	@Then("user clicks on Agree checkbox and creates PC id")
	public void user_clicks_on_agree_checkbox_and_creates_pc_id() {
		
		register.clickAgreeCheckbox();
		register.clickCreatePCId();
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

}
