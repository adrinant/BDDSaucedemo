package step_definitions;

import com.sun.tools.javac.comp.Check;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.CheckoutPage;
import org.example.pageObject.InventoryPage;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PurchaseSteps {
    private final WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    //@Login-Purchase-1
    @And("User click shopping cart badge")
    public void userClickShoppingCartBadge() {
        inventoryPage.clickShoppingCartIcon();
    }
    @Then("User redirected to shopping cart page")
    public void userRedirectedToShoppingCartPage() {
        checkoutPage.verifyCartPage();
    }

    @When("User remove {string} from shopping cart")
    public void userRemoveFromShoppingCart(String itemTitle) {
        checkoutPage.clickRemoveFromCart(itemTitle);
    }

    @And("User click Checkout button")
    public void userClickCheckoutButton() {
        checkoutPage.clickCheckoutButton();
    }

    @Then("User redirected to Checkout Step One page")
    public void userRedirectedToCheckoutStepOnePage() {
        Assert.assertTrue(checkoutPage.verifyCheckoutOnePage());
    }

    @When("User input {string} as FirstName {string} as LastName {string} as ZipCode")
    public void userInputAsFirstNameAsLastNameAsZipCode(String firstName, String lastName, String zipCode) {
        checkoutPage.inputCheckoutInfo(firstName, lastName, zipCode);
    }

    @And("User click Continue button")
    public void userClickContinueButton() {
        checkoutPage.clickContinueButton();
    }

    @Then("User redirected to Checkout Step Two page")
    public void userRedirectedToCheckoutStepTwoPage() {
        Assert.assertEquals(checkoutPage.getSummaryTotal(),checkoutPage.calcTotalAsString());
    }

    @When("User click Finish button")
    public void userClickFinishButton() {
        checkoutPage.clickFinishButton();
    }

    @Then("User redirected to Checkout Complete page")
    public void userRedirectedToCheckoutCompletePage() {
        Assert.assertTrue(checkoutPage.verifyThankYou());
    }

}
