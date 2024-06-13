package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_003_Validate_SignUp extends TestBase {


    @Test(groups = {"sanity", "master"})
    public void signUp() throws InterruptedException {

        HomePage homePage = new HomePage(driver);

        homePage.click_signUp();

        homePage.setUsername_input(getRandomAlphaNumeric());
        String rndNum= getRandomNumber();
        homePage.setPassword_input(rndNum);

        homePage.clickCompleteSignUp();

        Assert.assertFalse(homePage.doesUsernameExists());

        Assert.assertTrue(homePage.isSignUpSuccessful());


    }
}
