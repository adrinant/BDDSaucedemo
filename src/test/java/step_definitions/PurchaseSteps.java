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
    @And("User add to cart button for {string}")
    public void userAddToCartButtonFor(String itemTitle) {
        inventoryPage.clickAddtoCartItem(itemTitle);
    }

    @Then("User click shopping cart badge")
    public void userClickShoppingCartBadge() {
        inventoryPage.clickShoppingCartIcon();
    }

    @And("User remove {string} from shopping cart")
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

    @And("User input {string} as FirstName {string} as LastName {string} as ZipCode")
    public void userInputAsFirstNameAsLastNameAsZipCode(String firstName, String lastName, String zipCode) {
        checkoutPage.inputCheckoutInfo(firstName, lastName, zipCode);
    }

    @And("User click Continue button")
    public void userClickContinueButton() {
        checkoutPage.clickContinueButton();
    }

    @Then("User redirected to Checkout Step Two page")
    public void userRedirectedToCheckoutStepTwoPage() {
        Assert.assertEquals(checkoutPage.getSumarryTotal(),checkoutPage.calcTotalAsString());
    }

    @And("User click Finish button")
    public void userClickFinishButton() {
        checkoutPage.clickFinishButton();
    }

    @Then("User redirected to Checkout Complete page")
    public void userRedirectedToCheckoutCompletePage() {
        Assert.assertTrue(checkoutPage.verifyThankYou());
    }

    //@Login-Purchase-2
    @Given("User is logged in and on the inventory page")
    public void UserIsLoggedInAndOnTheInventoryPage(){
        Assert.assertTrue(loginPage.verifyLoginPage());
        loginPage.inputFieldUserName("standard_user");
        loginPage.inputFieldPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(inventoryPage.verifyInventoryContainer());
    }

    @When("User sorts products by {string}")
    public void userSortsProductsBy(String textSortBy) {
        inventoryPage.selectSortProduct(textSortBy);
    }

    @And("User adds {string} and {string} to the cart")
    public void userAddsAndToTheCart(String itemTitle1, String itemTitle2) {
        inventoryPage.clickAddtoCartItem(itemTitle1);
        inventoryPage.clickAddtoCartItem(itemTitle2);
    }

    @Then("User click shopping cart badge to go to shopping cart")
    public void userGoToShoppingCart(){
        inventoryPage.clickShoppingCartIcon();
    }

    @And("User removes {string} from the cart")
    public void userRemovesFromTheCart(String itemTitle) {
        checkoutPage.clickRemoveFromCart(itemTitle);
    }

    @Then("User clicks the Checkout button")
    public void clickCheckoutButton(){
        checkoutPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.verifyCheckoutOnePage());
    }

    @And("User fill the information needed to Continue")
    public void fillInformationNeeded(){
        checkoutPage.inputCheckoutInfo("Franklin", "Richards", "64182");
        checkoutPage.clickContinueButton();
    }

    @When("User redirected to Overview and Checkout Complete page")
    public void userCheckout() {
        Assert.assertEquals(checkoutPage.getSumarryTotal(),checkoutPage.calcTotalAsString());
        checkoutPage.clickFinishButton();
        Assert.assertTrue(checkoutPage.verifyThankYou());
    }
}
