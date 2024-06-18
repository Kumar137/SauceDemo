package com.saucedemo.pages;

import com.relevantcodes.extentreports.LogStatus;
import com.saucedemo.utils.ExtentManager;
import com.saucedemo.utils.GenericUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    WebDriver driver;
    GenericUtils genericUtils;
    public CartPage(WebDriver driver)
    {
        this.driver=driver;
        genericUtils=new GenericUtils(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBys(@FindBy(className="cart_item"))
    List<WebElement> lstWebelement;

    @FindBy(className = "inventory_item_price")
    WebElement inventoryItemPrice;

    @FindBy(id="checkout")
    WebElement checoutBtn;

    public void clickOnCheckoutBtn()
    {
        genericUtils.waitForElementPresent(checoutBtn);
        checoutBtn.click();
        ExtentManager.test.log(LogStatus.INFO,"checkout btn is clicked");
    }

}
