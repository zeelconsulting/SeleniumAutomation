@TestRegister
Feature: Test Lowblaws website


@Register
Scenario Outline: To test Register functionality
Given User launches Loblaws url
When User clicks on Sign In page
Then User Clicks on Create PC id
Then User creates an account by providing enter "<Email>","<Password>" and "<confirmPassword>"
Then user clicks on Agree checkbox
#Then user clicks creates PC id button

Examples:
|Email|Password|confirmPassword|
|John_Singh01@gmail.com|FirstTest@001|FirstTest@001|
#|John_Singh01@gmail.com|FirstTest@001|FirstTest@0012|


@RegisterError
Scenario Outline: To test Error message on Register Page
Given User launches Loblaws url
When User clicks on Sign In page
Then User Clicks on Create PC id
Then User creates an account by providing enter "<Email>","<Password>" and "<confirmPassword>"
Then validates the error message on register page

Examples:
|Email|Password|confirmPassword|
|John_Singh01@gmail.com|FirstTest@001|FirstTest@0012|


@Login
Scenario: To test login functionality
Given User launches Loblaws url
When User clicks on Sign In page
Then User enters "Contact@zeelconsulting.com" and "Discover@123" to login
#Then User click on My Account
#Then User click on "Sign Out" in My Account


@ProfileDetails
Scenario: To test Profile details
Given User launches Loblaws url
When User clicks on Sign In page
Then User enters "Contact@zeelconsulting.com" and "Discover@123" to login
Then User click on My Account
Then User click on "Profile" in My Account
Then Get FirstName LastName and PhoneNumber from profile 

@Addtocart
Scenario: To test Add to cart functionality
Given User launches Loblaws url
#When user searched "milk" in search for product bar
#Then user clicks on sorting dropdown and validate all values in dropdown are displayed
Then user selects "Newest to Oldest Products" from dropdown
Then search results are displayed
#Then user add "Partly Skimmed Milk 2% MF" to the cart


@TestNavigation
Scenario Outline: To test page navigation
Given User launches Loblaws url for page navigation







