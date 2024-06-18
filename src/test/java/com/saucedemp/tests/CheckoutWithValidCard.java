package com.saucedemp.tests;

import com.saucedemo.basetest.BaseTest;
import com.saucedemo.pages.*;
import com.saucedemo.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutWithValidCard extends BaseTest {



    @Test
    public void test_checkout_with_single_item() throws InterruptedException {
        driver.get(Constants.URL);
        loginPage.login();
        Thread.sleep(2000);
        productPage.clickOnAddToCartBtn();
        productPage.clickOncartIcon();
        cartPage.clickOnCheckoutBtn();
        checkout.enterCheckoutDetails();
        checkout.clickOnContinueBtn();
        checkoutOverview.clickFinishBtn();
        boolean bool=checkoutComplete.isTickMarkPresent();
        String strActualHeaderText=checkoutComplete.getHeaderText();
        Assert.assertTrue(bool);
        Assert.assertEquals(strActualHeaderText,"Thank you for your order!");
    }
}
