package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.InventoryPage;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private final WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);

    @Given("User open the saucedemo website")
    public void userOpenTheWebsiteSaucedemo() {
        Assert.assertTrue(loginPage.verifyLoginPage());
    }

    @When("User input {string} as a userName {string} as a password")
    public void inputCredential(String userName, String password){
        loginPage.inputFieldUserName(userName);
        loginPage.inputFieldPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("User redirected to inventory page")
    public void userRedirectedToInventoryPage() {
        Assert.assertTrue(inventoryPage.verifyInventoryContainer());
    }

    @Then("User see error {string} on login page")
    public void userSeeErrorOnLoginPage(String errorText) {
        Assert.assertEquals(errorText, loginPage.getErrorMessage());
    }

}
