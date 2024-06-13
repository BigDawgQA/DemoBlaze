package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.TestBase;

public class TC_007_Validate_CheckOut extends TestBase {

    @Test(groups = {"sanity", "master"})
    public void Valid_CheckOut() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        ProductPage pg01 = new ProductPage(driver);
        CartPage cp01 = new CartPage(driver);

        Assert.assertTrue(homePage.checkHomePageImages());

        homePage.clickLoginButton();
        homePage.setLogin_username_input(p.getProperty("login_username"));
        homePage.setLogin_password_input(p.getProperty("password"));
        homePage.clickCompleteLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginSuccessful());

        homePage.clickPhoneCategory();
        Assert.assertTrue((homePage.checkPhoneCategories()));
        homePage.clickSamSungS6();

        Assert.assertTrue(pg01.isSamSungDisplayed());

        pg01.clickAddToCart();
        Assert.assertTrue(pg01.isProductAdded());
        pg01.navigateBack();

        //HomePage hp02 = new HomePage(driver);
        homePage.clickLaptopsCategory();
        Assert.assertTrue((homePage.checkLaptopCategories()));
        homePage.clickDell2017();

        Assert.assertTrue(pg01.isDell2017Displayed());
        pg01.clickAddToCart();
        Assert.assertTrue(pg01.isProductAdded());
        pg01.navigateBack();

        homePage.clickMonitorsCategory();
        Assert.assertTrue((homePage.checkMonitorsCategories()));
        homePage.clickAppleMonitor();

        Assert.assertTrue(pg01.isAppleMonitorDisplayed());
        pg01.clickAddToCart();
        Assert.assertTrue(pg01.isProductAdded());
        pg01.navigateBack();

        homePage.clickCart();

        cp01.clickPlaceOrder();

        cp01.setName_input(p.getProperty("login_username"));
        cp01.setCountry_input(p.getProperty("country"));
        cp01.setCity_input(p.getProperty("city"));
        cp01.setCreditCard_input(p.getProperty("creditCard"));
        cp01.setMonth_input(p.getProperty("month"));
        cp01.setYear_input(p.getProperty("year"));

        cp01.clickPurchaseButton();

        Assert.assertTrue(cp01.isThankYouPageDisplayed());

        cp01.confirmPurchase();

        homePage.logOut();

    }




}
