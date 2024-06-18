package com.saucedemo.pages;

import com.relevantcodes.extentreports.LogStatus;
import com.saucedemo.utils.ExtentManager;
import com.saucedemo.utils.GenericUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;
    GenericUtils genericUtils;
    public ProductPage(WebDriver driver)
    {
        this.driver=driver;
        genericUtils=new GenericUtils(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[div[a[div[text()='Sauce Labs Backpack']]]]/descendant::button[text()='Add to cart']")
    private WebElement addtocartBtn;

    @FindBy(xpath="//div[div[a[div[text()='Sauce Labs Backpack']]]]/descendant::div[@class='inventory_item_price']")
    private WebElement itemPrice;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cartIcon;

    public void clickOnAddToCartBtn()
    {
        genericUtils.waitForElementPresent(addtocartBtn);
        addtocartBtn.click();
    }

    public void clickOncartIcon()
    {
        genericUtils.waitForElementPresent(cartIcon);
        cartIcon.click();
        ExtentManager.test.log(LogStatus.INFO,"cart icon is clicked");
    }
}
