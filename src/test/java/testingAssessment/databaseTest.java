package testingAssessment;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class databaseTest {
	
	static ExtentReports report = new ExtentReports("C:\\Users\\Faiza\\Desktop\\assessmentReports\\assessmentTests.html", true);
	ExtentTest test;
	ExtentTest test2;
	
	public WebDriver driver = null;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Faiza\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() {
	    // Write code here that turns the phrase above into concrete actions
		test = report.startTest("Creating a User");
		test.log(LogStatus.INFO, "Navigating to Jenkins Sign In");
		driver.get("http://localhost:8080/login?from=%2F");
		WebElement usernameInput = driver.findElement(By.name("j_username"));
		WebElement passwordInput = driver.findElement(By.name("j_password"));
		test.log(LogStatus.INFO, "Inputting Jenkins Information");
		usernameInput.sendKeys("Faizan");
		passwordInput.sendKeys("test");
		passwordInput.submit();
		test.log(LogStatus.INFO, "Navigating to the Add user page");
		driver.navigate().to("http://localhost:8080/securityRealm/addUser");
		test.log(LogStatus.PASS, "This is the create user page");
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() {
	    // Write code here that turns the phrase above into concrete actions
		test.log(LogStatus.INFO, "Inputting the users information");
		WebElement usernameInput = driver.findElement(By.id("username"));
		WebElement passwordInput = driver.findElement(By.name("password1"));
		WebElement confirmPField = driver.findElement(By.name("password2"));
		WebElement fullNameInput = driver.findElement(By.name("fullname"));
		WebElement emailFieldInput = driver.findElement(By.name("email"));
		usernameInput.sendKeys("testy");
		passwordInput.sendKeys("testy123");
		confirmPField.sendKeys("testy123");
		fullNameInput.sendKeys("testy McGee");
		emailFieldInput.sendKeys("testy@hotmail.com");
		
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		test.log(LogStatus.INFO, "Submitting data");
		WebElement emailFieldInput = driver.findElement(By.name("email"));
		emailFieldInput.click();
		emailFieldInput.submit();
		Thread.sleep(1000);
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() {
	    // Write code here that turns the phrase above into concrete actions
		test.log(LogStatus.INFO, "Navigating to database");
		driver.navigate().to("http://localhost:8080/asynchPeople/");
		//driver.findElement(By.linkText("User ID  ↑")).click();
		search searchUser = PageFactory.initElements(driver, search.class);
		if(searchUser.findTesty().getText().equals("testy")) {
			test.log(LogStatus.PASS, "The user is visible");
		} else {
			test.log(LogStatus.FAIL, "User is not visible");
		}
		assertEquals("testy", searchUser.findTesty().getText());
		report.endTest(test);
	}
	
	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, and \"([^\"]*)\" Fullname are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_and_Fullname_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4) {
	    // Write code here that turns the phrase above into concrete actions
		test2 = report.startTest("Creating multiple users");
		test2.log(LogStatus.INFO, "Inserting user " + arg1);
		driver.get("http://localhost:8080/securityRealm/addUser");
		WebElement usernameInput = driver.findElement(By.id("username"));
		WebElement passwordInput = driver.findElement(By.name("password1"));
		WebElement confirmPField = driver.findElement(By.name("password2"));
		WebElement fullNameInput = driver.findElement(By.name("fullname"));
		WebElement emailFieldInput = driver.findElement(By.name("email"));
		usernameInput.sendKeys(arg1);
		passwordInput.sendKeys(arg2);
		confirmPField.sendKeys(arg3);
		fullNameInput.sendKeys(arg4);
		emailFieldInput.sendKeys("test@hotmail.com");
		emailFieldInput.submit();
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		driver.navigate().to("http://localhost:8080/asynchPeople/");
		String username = driver.findElement(By.linkText(arg1)).getText();
		assertEquals(arg1, username);
		report.endTest(test2);
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		String username = driver.findElement(By.linkText(arg1)).getText();
		assertEquals(arg1, username);
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1){
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.linkText(arg1)).click();

	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		String username = driver.findElement(By.linkText(arg1)).getText();
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
	public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_NewFullName(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@After
	public void teardown() {
		driver.quit();
		report.flush();
	}

}
