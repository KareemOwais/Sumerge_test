package base;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;


public class BaseTests {
    private WebDriver driver;
    protected LoginPage loginPage;
    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage =new LoginPage(driver);

        //driver.quit();
    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
