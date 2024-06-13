package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;

    public Properties p;

    @Parameters({"os", "browser"})
    @BeforeClass(groups = {"sanity", "master"})
    public void setup(String os, String browser) throws IOException {

        FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
        p = new Properties();
        p.load(file);

        if(p.getProperty("execution_env").equalsIgnoreCase("remote")){

            DesiredCapabilities capabilities = new DesiredCapabilities();

            if(os.equalsIgnoreCase("windows")){

                capabilities.setPlatform(Platform.WINDOWS);
            }
            else if(os.equalsIgnoreCase("mac")){

                capabilities.setPlatform(Platform.MAC);
            }
            else{
                System.out.println("No matching OS");
                return;
            }

            switch (browser.toLowerCase()) {
                case "chrome" -> {
                    capabilities.setBrowserName("chrome");
                }
                case "edge" -> {
                    capabilities.setBrowserName("MicrosoftEdge");
                }
                case "safari" -> {
                    capabilities.setBrowserName("safari");
                }
                default -> {
                    System.out.println("No supporting Browser");
                    return;
                }
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }

        else if(p.getProperty("execution_env").equalsIgnoreCase("local")){

            switch (browser.toLowerCase()) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "safari" -> {
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                }
                default -> {
                    System.out.println("No supporting Browser");
                    return;
                }
            }

        }

        driver.manage().deleteAllCookies();
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String title = driver.getTitle();
        Assert.assertEquals(title, p.getProperty("pageTitle"));
    }

    @AfterClass(groups = {"sanity", "master"})
    public void closeBrowser(){

        driver.quit();
    }


    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        //sourceFile.renameTo(targetFile);
        FileHandler.copy(sourceFile, targetFile);

        return targetFilePath;
    }


    public String getRandomString(){

        return RandomStringUtils.randomAlphabetic(7);
    }

    public String getRandomNumber(){

        return RandomStringUtils.randomNumeric(8);
    }

    public String getRandomAlphaNumeric(){

        String generatedNumber = RandomStringUtils.randomNumeric(5);
        String generatedNumber2 = RandomStringUtils.randomNumeric(7);
        String generatedString = RandomStringUtils.randomAlphabetic(5);

        return generatedString + "@" + generatedNumber+ "#" + generatedNumber2;
    }










}
