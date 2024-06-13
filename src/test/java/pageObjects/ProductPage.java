package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath="//h2[text()='Samsung galaxy s6']") WebElement samsungGalaxyS6_txt;
    @FindBy(xpath="//h2[text()='Nokia lumia 1520']") WebElement nokiaLumia_txt;
    @FindBy(xpath="//h2[text()='Nexus 6") WebElement nexus6_txt;

    @FindBy (xpath = "//h2[text()='2017 Dell 15.6 Inch']") WebElement dell2017_txt;

    @FindBy (xpath = "//h2[text()='Apple monitor 24']") WebElement appleMonitor_txt;


    @FindBy(xpath="//a[text()='Add to cart']") WebElement addToCart_btn;  //Add to cart button

    @FindBy(xpath = "//a[text()='Cart']") WebElement cart_btn;



    public boolean isSamSungDisplayed(){

        return (samsungGalaxyS6_txt.isDisplayed());
    }
    public boolean isNokiaLumiaDisplayed(){

        return (nokiaLumia_txt.isDisplayed());
    }

    public boolean isNexus6Displayed(){

        return (nexus6_txt.isDisplayed());
    }

    public boolean isDell2017Displayed(){

        return (dell2017_txt.isDisplayed());
    }

    public boolean isAppleMonitorDisplayed(){

        return (appleMonitor_txt.isDisplayed());
    }

    public void clickAddToCart(){

        addToCart_btn.click();

    }

    public void clickCart(){

        cart_btn.click();
    }

    public boolean isProductAdded(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String getAlertText = alert.getText();
        alert.accept();

        return (getAlertText.contains("Product added"));

    }

    public void navigateBack(){

        driver.navigate().back();
        driver.navigate().back();
    }




}
