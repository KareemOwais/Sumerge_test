package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class HomePage {
    private WebDriver driver;
    private By App_Name = By.className("app_logo");

   // private By Text = By.linkText()
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public String titleText(){
        String state = driver.findElement(App_Name).getText();
        return state;
    }
}
