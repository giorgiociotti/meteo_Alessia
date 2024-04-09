package org.example;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utility {
    public static WebDriver driver;
    public static final String driverpath = "C:\\Users\\gciot\\IdeaProjects\\chromedriver-win64\\chromedriver.exe";
    public static final String username = "g.ciotti";
    public static final String password = "Giorgio01.";
    
    //METODO CHE CLICCA UN ELEMENTO
    public static void cliccaxpath(String xpath) {
        WebElement element = waitxpath(xpath);
        
        element.click();
    }
    
    public static void cliccaWebelement(WebElement webelement) {
        WebElement element = waitelement(webelement);
        
        element.click();
    }
    
    //METODO CHE DIGITA UNA STRINGA
    public static void digitaXpath(String stringa, String xpath) {
        WebElement element = waitxpath(xpath);
        
        if (element != null) {
            element.sendKeys(stringa);
        }
    }
    
    public static void digitaWebElement(String stringa, WebElement element) {
        WebElement element1 = waitelement(element);
        
        if (element1 != null) {
            element1.sendKeys(stringa);
        }
    }
    
    //METODO CHE CONVERTE DA WEBELEMENT A STRING
    public static List<String> converts(List<WebElement> lista) {
        List<String> liststring = new ArrayList<>();
        for (WebElement element : lista) {
            liststring.add(element.getText());
        }
        return liststring;
    }
    
    public static String convert(WebElement webelement) {
        return webelement.getText();
    }
    
    //METODI FIND
    public static WebElement find(String xpath) {
        
        return waitxpath(xpath);
        
    }
    
    public static WebElement findclick(String xpath) {
        
        return waitxpathclick(xpath);
        
    }
    
    
    public static List<WebElement> finds(String xpath) {
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return driver.findElements(By.xpath(xpath));
    }
    
    //METODI WAIT
    public static WebElement waitxpath(String xpath) {
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        
        return element;
        
    }
    
    public static WebElement waitxpathclick(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return element;
    }
    
    public static WebElement waitelement(WebElement webelement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(webelement));
        return element;
    }
    
    public static WebElement waitelementclick(WebElement webelement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webelement));
        return element;
    }
    
    
    public static void ctrla(WebElement element) {
        waitelement(element);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));//CTRL+A
        
        
    }
    
    //METODO CHE SCROLLA VERSO UN ELEMENTO
    public static void scroll(WebElement element) {
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    public static void getScreenshot() throws IOException {
        Date currentdate = new Date();
        String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + screenshotfilename + ".png"));
    }
    
    
    public static boolean isModalOpenOrClosed(WebElement modale) {
        try {
            return modale != null && modale.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return true;
        }
    }
    
}
