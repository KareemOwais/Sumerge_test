package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    private WebDriver driver;
    private By userNameField = By.id("user-name");
    private By userPasswordField = By.id("password");
    private By loginButton =By.id("login-button");
    private By failedLogin = By.cssSelector(".error-message-container.error");


    public String FailedLoginMess(){
        return driver.findElement(failedLogin).getText();
    }
    public Boolean FailedLoginButton(){
        return driver.findElement(failedLogin).isDisplayed();
    }
    public LoginPage(WebDriver driver){
        this.driver =driver;
    }
    public boolean nameFieldExsit(){
        return driver.findElement(userNameField).isDisplayed();
    }
    public boolean passwordFieldExsit(){
        return driver.findElement(userPasswordField).isDisplayed();
    }
    public boolean buttonExsit(){
        return driver.findElement(loginButton).isDisplayed();
    }
    public void setUserName(String UserName){
        driver.findElement(userNameField).sendKeys(UserName);
    }
    public void RemoveUserName(){
        driver.findElement(userNameField).clear();
    }
    public void RemovePassword(){
        driver.findElement(userPasswordField).clear();
    }
    public void setUserPassword(String Password){
        driver.findElement(userPasswordField).sendKeys(Password);
    }
    public HomePage clickLogin(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
