package com.saucedemo.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class GenericUtils {

    public static WebDriver driver;
    WebDriverWait webDriverWait;
    public GenericUtils(WebDriver driver)
    {
        this.driver=driver;
    }


    public boolean waitForElementPresent(WebElement webElement)
    {
        try{
            webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(30l));
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    public static String takeScreenshot(String screenshotName){
        String filepath = System.getProperty("user.dir")+"/src/main/resources/Reports/screenshots";
        screenshotName = screenshotName.replace(":", "_");

        String fullyQualifiedScreenshot = filepath+"/"+screenshotName+".png";
        String srcfile="";
        try{
            srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        }catch(Exception e) {

        }
        return "data:image/jpg;base64, " + srcfile ;

    }
}
