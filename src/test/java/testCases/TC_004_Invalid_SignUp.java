package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_004_Invalid_SignUp extends TestBase {


    @Test (groups = {"master"})
    public void invalidSignUp() throws InterruptedException {

        HomePage homePage = new HomePage(driver);

        homePage.click_signUp();

//        homePage.setUsername_input(p.getProperty("alreadyUsedUsername"));
//        homePage.setPassword_input(p.getProperty("password"));

        try{

            homePage.setUsername_input(p.getProperty("alreadyUsedUsername"));
            homePage.setPassword_input(p.getProperty("password"));
            homePage.clickCompleteSignUp();

            Assert.assertTrue(homePage.doesUsernameExists());

        } catch (Exception e){

            System.err.println(e.getMessage());
            e.printStackTrace();
        }

//        homePage.clickCompleteSignUp();

//        Thread.sleep(4000);
//
//        Assert.assertTrue(homePage.doesUsernameExists());

    }
}
