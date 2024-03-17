package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.pageObject.InventoryPage;
import org.example.pageObject.LoginPage;
import org.openqa.selenium.WebDriver;

public class InventorySteps {

    private final WebDriver driver = Hooks.driver;

    InventoryPage inventoryPage = new InventoryPage(driver);

    @When("User sort product by {string}")
    public void sortProduct(String textSortBy){
        inventoryPage.selectSortProduct(textSortBy);
    }


    @And("User click add to cart button for {string}")
    public void userClickAddToCartButtonFor(String itemTitle) {
        inventoryPage.clickAddtoCartItem(itemTitle);
    }
}
