package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[contains(text(), 'Welcome')]") WebElement welcome_txt;


    public Boolean isLoginSuccessful(){

        return (welcome_txt.isDisplayed());

    }






}
