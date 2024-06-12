package org.example;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;


import static org.example.Stringhe.*;
import static org.example.Utility.*;
import static org.example.Xpath.*;

public class TestMeteo extends Listener {
    SoftAssert softAssert = new SoftAssert();
    
    
    @BeforeTest
    public void setup() {
            //FIREFOX
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
       
    }
   
    @Test
    public void meteo() throws IOException {
        driver.get("https://www.ilmeteo.it/meteo.php?citta_input=Viterbo");
        
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
        FileUtils.copyFile(screenshot, new File("./" + screenshotfilename + ".png"));
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
