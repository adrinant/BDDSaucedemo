package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.text.DecimalFormat;

public class CheckoutPage {
    public static WebDriver webDriver;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")
    private WebElement removeSauceLabsBikeLight;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='checkout_info']")
    private WebElement checkoutInfo;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement inputFirstName;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement inputLastName;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement inputZipCode;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private WebElement summaryTotal;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    @FindBy(xpath = "//img[@alt='Pony Express']")
    private WebElement thankYou;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement summarySubtotal;

    @FindBy(xpath = "//div[@class='cart_list']")
    private WebElement cartList;

    public void verifyCartPage(){
        cartList.isDisplayed();
        checkoutButton.isDisplayed();
    }

    public void clickRemoveFromCart(String itemTitle) {
        String button = "//div[.='" + itemTitle + "']/ancestor::div[1]/div[@class='item_pricebar']/button";
        webDriver.findElement(By.xpath(button)).click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public boolean verifyCheckoutOnePage() {
        boolean a = checkoutInfo.isDisplayed();
        boolean b = inputFirstName.isDisplayed();
        return a && b;
    }

    public void inputCheckoutInfo(String firstName, String lastName, String zipCode) {
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputZipCode.sendKeys(zipCode);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public boolean verifySummaryTotal() {
        return summaryTotal.isDisplayed();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public boolean verifyThankYou() {
        return thankYou.isDisplayed();
    }

    public double getSubtotalAsDouble() {
        // Get the text value of the WebElement
        String subtotalText = summarySubtotal.getText();

        // Remove semua non-numeric karakter \d adalah digit 0-9, ^ adalah not
        subtotalText = subtotalText.replaceAll("[^\\d.]", "");

        // Convert text yang udah dibersihkan ke double
        double subtotal = Double.parseDouble(subtotalText);

        return subtotal;
    }

    public double calculateTax(){
        // Get subtotal
        double subtotal = getSubtotalAsDouble();

        // Calculate tax (8% dari subtotal)
        double taxPercentage = 0.08; // 8%
        double taxAmount = subtotal * taxPercentage;

        // Bulatkan tax amount ke 2 angka dibelakang .
        DecimalFormat df = new DecimalFormat("#.##");
        double roundedTaxAmount = Double.parseDouble(df.format(taxAmount));

        return roundedTaxAmount;
    }

    public String calcTotalAsString(){
        // Get subtotal and tax
        double subtotal = getSubtotalAsDouble();
        double tax = calculateTax();

        // Calculate total
        double total = subtotal + tax;

        // menambahkan "Total: $" prefix
        String totalString = "Total: $" + total;

        return totalString;
    }

    public String getSummaryTotal(){
        return summaryTotal.getText();
    }

}
