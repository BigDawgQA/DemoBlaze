package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_002_Validate_SendContactMessage extends TestBase {

    @Test (groups = {"master"})
    public void SendMessage() throws InterruptedException {

        HomePage homePage = new HomePage(driver);

        homePage.clickContact();
        homePage.setContact_email_input(p.getProperty("contact_email"));
        homePage.setContact_name_input(p.getProperty("customerName"));
        homePage.setMessage_input(p.getProperty("message"));

        homePage.clickSendMessage();

        Assert.assertTrue(homePage.isMessageSent());





    }
}
