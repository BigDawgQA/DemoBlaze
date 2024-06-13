package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.TestBase;

import java.io.IOException;

public class TC_006_Validate_Broken_Links extends TestBase {


    @Test(groups = {"master"})
    public void validateBrokenLinks() throws IOException {

        HomePage homePage = new HomePage(driver);

        Assert.assertFalse(homePage.anyBrokenLinks());


    }

}
