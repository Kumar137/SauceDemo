package com.saucedemo.basetest;

import com.saucedemo.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;
    public LoginPage loginPage;
    public ProductPage productPage;
    public CheckoutComplete checkoutComplete;
    public CheckoutOverview checkoutOverview;
    public Checkout checkout;
    public CartPage cartPage;

    @BeforeClass
    public void setUp()
    {
        driver=new ChromeDriver();
        loginPage=new LoginPage(driver);
        productPage=new ProductPage(driver);
        checkoutComplete=new CheckoutComplete(driver);
        checkoutOverview=new CheckoutOverview(driver);
        checkout=new Checkout(driver);
        cartPage=new CartPage(driver);
    }

    @AfterClass
    public void closeBrowser()
    {
        driver.quit();
    }

}
