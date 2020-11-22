package Login_stepDDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class step {

	WebDriver driver = null;
	
	@Given("^Open Browser$")
	public void open_Browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}

	@When("^Open URL \"([^\"]*)\"$")
	public void open_URL(String arg1) throws Throwable {
	    driver.get(arg1);
	}

	@And("^Click on MyAccount$")
	public void click_on_MyAccount() throws Throwable {
		driver.findElement(By.linkText("My Account")).click();
		Thread.sleep(2000);
	}

	@And("^Enter Username and Password$")
	public void enter_Username_and_Password(DataTable arg1) throws Throwable {
	    List <List <String>> data= arg1.raw();
	    driver.findElement(By.id("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.id("password")).sendKeys(data.get(0).get(1));
	}

	@And("^Click on Login$")
	public void click_on_Login() throws Throwable {
		driver.findElement(By.name("login")).click();
	}

	@Then("^Test Case Passed$")
	public void test_Case_Passed() throws Throwable {
		String capText=driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li/strong")).getText();
		if(capText.contains("ERROR")) {
			Assert.assertTrue("Invalid input - Error Page", true);
		}
		else{
			Assert.assertTrue(false);
		}
	}
}
