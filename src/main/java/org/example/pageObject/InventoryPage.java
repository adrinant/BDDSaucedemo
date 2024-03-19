package org.example.pageObject;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage {

//    public static WebDriver webDriver;
//
//    public InventoryPage(WebDriver driver){
//        PageFactory.initElements(driver, this);
//        webDriver = driver;
//    }

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortProduct;
    @FindBy(xpath = "//div[@class='inventory_container']")
    private WebElement inventoryContainer;
    @FindBy(xpath = "//div[@id='shopping_cart_container']/a[1]")
    private WebElement shoppingCartIcon;


    public boolean verifyInventoryContainer(){
        return inventoryContainer.isDisplayed();
    }

    public void selectSortProduct(String textSortBy){
        selectByVisibleText(sortProduct, textSortBy);
    }

    public void clickAddtoCartItem(String item){
        String button = "//div[text()='"+item+"']/ancestor::div[@class='inventory_item_description']//button[text()='Add to cart']";
        //webDriver.findElement(By.xpath(button)).click();
        WebElement buttonElement = driver.findElement(By.xpath(button));
        click(buttonElement);
    }

    public void clickShoppingCartIcon() {
        shoppingCartIcon.click();
    }

}
