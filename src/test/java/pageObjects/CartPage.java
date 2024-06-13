package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{


    public CartPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "(//a[text()='Delete'])[2]") WebElement delete_btn;

    @FindBy(xpath = "//button[text()='Place Order']") WebElement place_order_btn;


    @FindBy(xpath="//input[@id='name']") WebElement name_input;
    @FindBy(xpath="//input[@id='country']") WebElement country_input;
    @FindBy(xpath="//input[@id='city']") WebElement city_input;
    @FindBy(xpath="//input[@id='card']") WebElement creditCard_input;
    @FindBy(xpath="//input[@id='month']") WebElement month_input;
    @FindBy(xpath="//input[@id='year']") WebElement year_input;

    @FindBy(xpath="//button[normalize-space()='Purchase']") WebElement purchase_btn;

    @FindBy (xpath = "//h2[text()='Thank you for your purchase!']") WebElement thankYouForYourPurchase_txt;

    @FindBy(xpath="//button[normalize-space()='OK']") WebElement oK_btn;

    @FindBy(xpath = "//button[text()='OK']") WebElement ok_btn;


    public void clickPlaceOrder(){

        place_order_btn.click();
    }

    public void setName_input(String testName){

        name_input.sendKeys(testName);
    }

    public void setCountry_input(String country){

        country_input.sendKeys(country);
    }

    public void setCity_input(String city){

        city_input.sendKeys(city);
    }

    public void setCreditCard_input(String creditCard){

        creditCard_input.sendKeys(creditCard);
    }

    public void setMonth_input(String month){

        month_input.sendKeys(month);
    }

    public void setYear_input(String year){

        year_input.sendKeys(year);
    }

    public void clickPurchaseButton(){

        purchase_btn.click();
    }

    public boolean isThankYouPageDisplayed(){

        return (thankYouForYourPurchase_txt.isDisplayed());
    }

    public void confirmPurchase(){

        ok_btn.click();
    }





}
