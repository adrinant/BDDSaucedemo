package org.example.pageObject;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

//    public static WebDriver webDriver;
//
//    public LoginPage(WebDriver driver){
//        PageFactory.initElements(driver, this);
//        webDriver = driver;
//    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //inisiasi locator
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement fieldUserName;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement fieldPassword;
    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;
    @FindBy(xpath = "//h3")
    private WebElement errorMessage;

    public void inputFieldUserName(String userName){
        fieldUserName.sendKeys(userName);
    }

    public void inputFieldPassword(String password){
        fieldPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        isDisplayed(loginButton);
        click(loginButton);
    }


    public boolean verifyLoginPage(){
        boolean a = fieldUserName.isDisplayed();
        boolean b = fieldPassword.isDisplayed();
        boolean c = loginButton.isDisplayed();
        return a && b && c;
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

}
