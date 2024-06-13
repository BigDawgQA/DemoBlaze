package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.TestBase;

public class TC_005_Validate_Login extends TestBase {

    @Test(groups = {"sanity", "master"})
    public void valid_Login() throws InterruptedException {

        try{

            HomePage homePage = new HomePage(driver);

            homePage.clickLoginButton();

            homePage.setLogin_username_input(p.getProperty("login_username"));
            homePage.setLogin_password_input(p.getProperty("password"));

            homePage.clickCompleteLoginButton();

            LoginPage loginPage = new LoginPage(driver);

            Assert.assertTrue(loginPage.isLoginSuccessful());

        } catch (Exception e){

            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
