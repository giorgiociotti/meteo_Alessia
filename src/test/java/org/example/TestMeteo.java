package org.example;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;


import static org.example.Stringhe.*;
import static org.example.Utility.*;
import static org.example.Xpath.*;

public class TestMeteo extends Listener {
    SoftAssert softAssert = new SoftAssert();
    Xpath xpath = new Xpath();
    
    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browser) {
        
        if ("firefox".equals(browser)) {//if browser null o pippo
            //FIREFOX
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        } else if ("chrome".equals(browser)) {
            //CHROME
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
    }
    @Test(priority = 1)
    public void login(){
    driver.get("https://www.ilmeteo.it/meteo.php?citta_input=Roma");
    }
    @Test(priority = 2)
    public void meteo() throws IOException {
        WebElement tbody= find(tableTbody);
        int x = tbody.getLocation().getX();
        int y = tbody.getLocation().getY();
        int width = tbody.getSize().getWidth();
        int height = tbody.getSize().getHeight();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
        // Ritaglia l'immagine per includere solo l'elemento desiderato
        BufferedImage fullImg = ImageIO.read(screenshot);
        BufferedImage elementScreenshot = fullImg.getSubimage(x, y, width, height);
        ImageIO.write(elementScreenshot, "png", screenshot);
        Date currentdate = new Date();
        String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
        // Salva lo screenshot come file
        FileUtils.copyFile(screenshot, new File(".//screenshot//" + screenshotfilename + ".png"));
    }
    
    @AfterTest
    public void fine() {
        
        driver.quit();
        
        try {
            softAssert.assertAll();
            System.out.println(assertSucces);
        } catch (AssertionError ae) {
            System.out.println(ae);
            
        }
    }
}
