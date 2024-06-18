package com.saucedemo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    public WebDriver webDriver;
    public  WebDriver getWebDriverInstance(){
        try {
            if(Constants.BROWSER.equalsIgnoreCase("CHROME")) {
                System.setProperty("webdriver.chrome.driver", "DriverFiles/chromedriver.exe");
                webDriver = new ChromeDriver();
            }
            else if (Constants.BROWSER.equalsIgnoreCase("FIREFOX")){
                System.setProperty("webdriver.gecko.driver", "DriverFiles/geckodriver");
                webDriver = new FirefoxDriver();

            }
        }catch(Exception e){
        }
        return webDriver;
    }
}