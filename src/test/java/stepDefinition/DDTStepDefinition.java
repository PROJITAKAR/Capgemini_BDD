package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DDTStepDefinition {
	WebDriver driver;
	String detail;
	@Given("As a user I want to Launch the browser")
	public void as_a_user_i_want_to_launch_the_browser() {
	    driver= new EdgeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Given("load the URL as {string}")
	public void load_the_url_as(String url) {
	    driver.get(url);
	}
	@When("login page is displayed enter username {string}")
	public void login_page_is_displayed_enter_username(String string) {
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");
	}
	@When("enter password as {string}")
	public void enter_password_as(String string) {
	   driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}
	@When("Click on Login button")
	public void click_on_login_button() {
	    driver.findElement(By.id("login-button")).click();
	}
	@Then("Validate for Home Page")
	public void validate_for_home_page() {
	    Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed());
	}
	
	@Given("Click on a Product {string}")
	public void click_on_a_product(String item) {
		String path = String.format("//div[contains(text(),'%s')]", item);
		driver.findElement(By.xpath(path)).click();
	}
	@Given("Click on add product to cart button")
	public void click_on_add_product_to_cart_button() {
	    driver.findElement(By.id("add-to-cart")).click();
	}
	@When("Cart is updated navigate to cart button")
	public void cart_is_updated_navigate_to_cart_button() {
	   driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	}
	@When("capture product details")
	public void capture_product_details() {
	   detail= driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
	}
	@Then("I validate the product name with {string}")
	public void i_validate_the_product_name_with(String string) {
		Assert.assertTrue(detail.contains(string));
		driver.quit();
	}

	@Given("Click on the Product {string}")
	public void click_on_the_product(String item) {
		String path = String.format("//div[contains(text(),'%s')]", item);
		driver.findElement(By.xpath(path)).click();	}
	@When("Product page is displayed click on add to cart")
	public void product_page_is_displayed_click_on_add_to_cart() {
		driver.findElement(By.id("add-to-cart")).click();
	}
	@Then("Navigate to Cart page")
	public void navigate_to_cart_page() {
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	}
	@Then("Validate for the product {string}")
	public void validate_for_the_product(String string) {
		detail= driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		Assert.assertTrue(detail.contains(string));
		driver.quit();
	}	
	
}
