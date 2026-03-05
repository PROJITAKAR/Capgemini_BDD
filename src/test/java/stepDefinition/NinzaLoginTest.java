package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NinzaLoginTest {
	WebDriver driver;
	@Given("Launch the browser")
	public void launch_the_browser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	    
	}
	@Given("Navigate to Application")
	public void navigate_to_application() {
	    driver.get("http://49.249.28.218:8098/");
	}
	@When("Enter username and password")
	public void enter_username_and_password() {
	    driver.findElement(By.id("username")).sendKeys("rmgyantra");
	    driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	}
	@When("Click on login button")
	public void click_on_login_button() {
	    driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}
	@Then("Verify the homepage")
	public void verify_the_homepage() {
		System.out.println("homepage displayed");
		driver.quit();
	}

}
