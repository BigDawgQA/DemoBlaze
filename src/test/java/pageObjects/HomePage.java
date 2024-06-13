package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy (xpath = "//a/span[@class='carousel-control-next-icon']") WebElement homePage_img_arrow_btn;

    @FindBy (xpath = "//div/div/img[@class='d-block img-fluid']") List<WebElement> homePage_images;  //validate 3 images


    //Categories
    @FindBy(xpath="//a[text()='Phones']") WebElement phones_cat_btn;
    @FindBy(xpath="//a[text()='Laptops']") WebElement laptops_cat_btn;
    @FindBy(xpath="//a[text()='Monitors']") WebElement monitors_cat_btn;

    //Phone Categories Filter
    @FindBy (xpath = "//div[@class='col-lg-4 col-md-6 mb-4']/div/a[contains(@href, 'prod')]") List<WebElement> phone_cat_elements;
    @FindBy (xpath = "//div[@class='col-lg-4 col-md-6 mb-4']/div/a[contains(@href, 'prod')]") List<WebElement> laptops_cat_elements;
    @FindBy (xpath = "//div[@class='col-lg-4 col-md-6 mb-4']/div/a[contains(@href, 'prod')]") List<WebElement> monitor_cat_elements;

    //Phone Elements
    @FindBy(xpath="//a[normalize-space()='Samsung galaxy s6']") WebElement samsungGalaxyS6;
    @FindBy(xpath="//a[normalize-space()='Nokia lumia 1520']") WebElement nokiaLumia1520;
    @FindBy(xpath="//a[normalize-space()='Nexus 6']") WebElement nexus6;


    //Laptops Elements
    @FindBy(xpath = "//a[text()='2017 Dell 15.6 Inch']") WebElement dell2017;

    //Monitor Elements
    @FindBy(xpath = "//a[text()='Apple monitor 24']") WebElement appleMonitor;


    //Cart Button
    @FindBy(xpath = "//a[text()='Cart']") WebElement cart_btn;


    //Contact
    @FindBy(xpath = "//a[text()='Contact']") WebElement contact_btn;
    @FindBy(id = "recipient-email") WebElement contact_email_input;
    @FindBy(id = "recipient-name") WebElement contact_name_input;
    @FindBy(id = "message-text") WebElement message_input;
    @FindBy(xpath = "//button[text()='Send message']") WebElement sendMessage_btn;

    //Sign-Up
    @FindBy(xpath = "//a[text()='Sign up']") WebElement signUp;
    @FindBy(id = "sign-username") WebElement username_input;
    @FindBy(id = "sign-password") WebElement password_input;
    @FindBy(xpath = "//button[text()='Sign up']") WebElement signUp_btn;


    //Login
    @FindBy(xpath = "//a[text()='Log in']") WebElement login_btn;
    @FindBy(id = "loginusername") WebElement login_username_input;
    @FindBy(id = "loginpassword") WebElement login_password_input;
    @FindBy(xpath = "//button[text()='Log in']") WebElement complete_login_btn;

    @FindBy(xpath = "//a[contains(text(), 'Welcome')]") WebElement welcome_txt;


    //All Links
    @FindBy(xpath = "//a") List<WebElement> allLinks;


    //LogOut
    @FindBy(id = "logout2") WebElement logOut_btn;




    public boolean checkHomePageImages(){

        int numberOfImages = homePage_images.size();
        if(numberOfImages == 3){

            for(int i=0; i<= numberOfImages; i++){

                homePage_img_arrow_btn.click();
            }

            return true;
        }
        return false;
    }

    public void scrollByImages(){

        for(int i=0; i<3; i++){

            homePage_img_arrow_btn.click();
        }
    }

    public void clickPhoneCategory(){

        phones_cat_btn.click();
    }

    public boolean checkPhoneCategories(){

        for(WebElement i: phone_cat_elements){
            if(!i.isDisplayed()){
                return false;
            }
        }
        return true;
    }

    public void clickLaptopsCategory(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(laptops_cat_btn));
        laptops_cat_btn.click();
    }
    public boolean checkLaptopCategories(){

        for(WebElement i: laptops_cat_elements){
            if(!i.isDisplayed()){
                return false;
            }
        }
        return true;
    }

    public void clickMonitorsCategory(){

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.elementToBeClickable(monitors_cat_btn));
        monitors_cat_btn.click();
    }
    public boolean checkMonitorsCategories(){

        for(WebElement i: monitor_cat_elements){
            if(!i.isDisplayed()){
                return false;
            }
        }
        return true;
    }

    public void clickSamSungS6(){

        samsungGalaxyS6.click();
    }

    public void clickNokiaLumia(){

        nokiaLumia1520.click();
    }

    public void clickNexus6(){

        nexus6.click();
    }

    public void clickDell2017(){

        dell2017.click();
    }

    public void clickAppleMonitor(){

        appleMonitor.click();
    }

    public void clickCart(){

        cart_btn.click();
    }

    public void clickContact(){

        contact_btn.click();
    }

    public void setContact_email_input(String email){

        contact_email_input.sendKeys(email);
    }

    public void setContact_name_input(String name){

        contact_name_input.sendKeys(name);
    }

    public void setMessage_input(String message){

        message_input.sendKeys(message);
    }

    public void clickSendMessage(){

        sendMessage_btn.click();
    }

    public boolean isMessageSent(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        alert.accept();

        return (alertMessage.equals("Thanks for the message!!"));
    }

    public void click_signUp(){

        signUp.click();
    }

    public void setUsername_input(String username){

        username_input.sendKeys(username);
    }

    public void setPassword_input(String password){

        password_input.sendKeys(password);
    }

    public void clickCompleteSignUp(){

        signUp_btn.click();
    }

    public Boolean doesUsernameExists(){

        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert  alert = driver.switchTo().alert();
            String alertMessage = alert.getText();

            if(alertMessage.contains("This user already exist")){

                alert.accept();
                return true;
            }

        } catch (Exception e){

            e.printStackTrace();
        }

        //System.out.println("Username does not exist");
        return false;
    }

    public Boolean isSignUpSuccessful(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();

        return (alertMessage.contains("Sign up successful"));
    }

    public void clickLoginButton(){

        login_btn.click();
    }

    public void setLogin_username_input(String username){

        login_username_input.sendKeys(username);
    }

    public void setLogin_password_input(String password){

        login_password_input.sendKeys(password);
    }

    public void clickCompleteLoginButton(){

        complete_login_btn.click();
    }

    public boolean anyBrokenLinks() throws IOException {

        int count=0;

        for(WebElement linkElement: allLinks){

            String hrefValue = linkElement.getAttribute("href");

            if(hrefValue == null || hrefValue.isEmpty()){

                //System.out.println(hrefValue + " Is empty");
                continue;
            }

            URL linkUrl = new URL(hrefValue);

            HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();

            connection.connect();

            if(connection.getResponseCode() >= 400) {

               count++;
            }
        }

        return count > 1;  //return false if broken link is less than 1 (should be less than 1)
    }

    public void logOut(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();" , logOut_btn);
        //logOut_btn.click();
    }

}
