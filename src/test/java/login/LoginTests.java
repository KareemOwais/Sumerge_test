package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends BaseTests {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"Talent", "Program", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"standard_user", "secret_sauce", null},
        };
    }
    @Test
    public void fieldExistTest(){

        Assert.assertTrue(loginPage.nameFieldExsit(),"Name field doesn't exsit");
        Assert.assertTrue(loginPage.passwordFieldExsit(),"Password field doesn't exsit");
        Assert.assertTrue(loginPage.buttonExsit(),"button doesn't exsit");

    }
        @Test(dataProvider = "loginData")
        public void LoginTests(String UserName,String Password,String msg){
        loginPage.setUserName(UserName);
        loginPage.setUserPassword(Password);
        HomePage homePage= loginPage.clickLogin();
        if(msg == null) {
            //Successful login test
            Assert.assertTrue(homePage.titleText().contains("Swag Labs"),
                    "text incorrect the correct text is : Swag Labs ");
        } else if (msg.equals("Epic sadface: Username and password do not match any user in this service")) {
            // WrongCredentials test
            Assert.assertEquals(loginPage.FailedLoginMess(),
                    "Epic sadface: Username and password do not match any user in this service",
                    "the Test failed");
        } else if (msg.equals("Epic sadface: Username is required")) {
            //empty Username test
            Assert.assertEquals(loginPage.FailedLoginMess(),"Epic sadface: Username is required",
                    "Test went wrong");
        } else if (msg.equals("Epic sadface: Password is required")) {
            //empty Password
            Assert.assertEquals(loginPage.FailedLoginMess(),"Epic sadface: Password is required"
                    , "Test went wrong");
        }
        }
}
