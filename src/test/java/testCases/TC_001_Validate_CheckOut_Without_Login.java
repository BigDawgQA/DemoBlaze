package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import testBase.TestBase;

public class TC_001_Validate_CheckOut_Without_Login extends TestBase {

    @Test(groups = {"master"})
    public void CheckOutWithoutLogin()  {

        HomePage hp01 = new HomePage(driver);
        ProductPage pg01 = new ProductPage(driver);
        CartPage cp01 = new CartPage(driver);


        Assert.assertTrue(hp01.checkHomePageImages());

        hp01.clickPhoneCategory();
        Assert.assertTrue((hp01.checkPhoneCategories()));
        hp01.clickSamSungS6();

        Assert.assertTrue(pg01.isSamSungDisplayed());
        pg01.clickAddToCart();
        Assert.assertTrue(pg01.isProductAdded());
        pg01.navigateBack();

        //HomePage hp02 = new HomePage(driver);
        hp01.clickLaptopsCategory();
        Assert.assertTrue((hp01.checkLaptopCategories()));
        hp01.clickDell2017();

        Assert.assertTrue(pg01.isDell2017Displayed());
        pg01.clickAddToCart();
        Assert.assertTrue(pg01.isProductAdded());
        pg01.navigateBack();

        hp01.clickMonitorsCategory();
        Assert.assertTrue((hp01.checkMonitorsCategories()));
        hp01.clickAppleMonitor();

        Assert.assertTrue(pg01.isAppleMonitorDisplayed());
        pg01.clickAddToCart();
        Assert.assertTrue(pg01.isProductAdded());
        pg01.navigateBack();

        hp01.clickCart();

        cp01.clickPlaceOrder();

        cp01.setName_input(p.getProperty("customerName"));
        cp01.setCountry_input(p.getProperty("country"));
        cp01.setCity_input(p.getProperty("city"));
        cp01.setCreditCard_input(p.getProperty("creditCard"));
        cp01.setMonth_input(p.getProperty("month"));
        cp01.setYear_input(p.getProperty("year"));

        cp01.clickPurchaseButton();

        Assert.assertTrue(cp01.isThankYouPageDisplayed());



    }


}
