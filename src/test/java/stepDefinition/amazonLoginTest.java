package stepDefinition;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class amazonLoginTest {
	WebDriver driver;
	String parent;
	@Given("User is on the home page")
	public void user_is_on_the_home_page() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/?ref_=icp_country_from_us");
		parent=driver.getWindowHandle();
		Thread.sleep(2000);
	}
	@When("User searches for Headphones")
	public void user_searches_for_headphones() throws InterruptedException {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Headphones", Keys.ENTER);
		Thread.sleep(1000);
	}
	@When("User selects the first product")
	public void user_selects_the_first_product() throws InterruptedException {
		driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
		Set<String> ids=driver.getWindowHandles();
		ids.remove(parent);
		String childId = ids.iterator().next();
		driver.switchTo().window(childId);
		Thread.sleep(2000);
	    
	}
	@When("User clicks on Add to Cart button")
	public void user_clicks_on_add_to_cart_button() throws InterruptedException {
	    driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]")).click();
	    Thread.sleep(2000);
	}
	@Then("Product should be added to the cart-verify text of added to cart using isDisplayed")
	public void product_should_be_added_to_the_cart_verify_text_of_added_to_cart_using_is_displayed() {
	    WebElement addToCart= driver.findElement(By.xpath("//h1[contains(text(),'Added to cart')]"));
	    Assert.assertTrue(addToCart.isDisplayed(),"Not added to cart");
	    System.out.println("Successfully added to cart");
	    driver.quit();
	}



}
