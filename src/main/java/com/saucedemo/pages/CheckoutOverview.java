package com.saucedemo.pages;

import com.relevantcodes.extentreports.LogStatus;
import com.saucedemo.utils.ExtentManager;
import com.saucedemo.utils.GenericUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverview {

    WebDriver driver;
    GenericUtils genericUtils;
    public CheckoutOverview(WebDriver driver)
    {
        this.driver=driver;
        genericUtils=new GenericUtils(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@data-test='total-info-label']")
    private WebElement priceTotal;

    @FindBy(xpath = "//div[@data-test='shipping-info-value']")
    private WebElement shippingInfoValue;

    @FindBy(xpath = "//div[@data-test='shipping-info-label']")
    private WebElement shippingInfoLabel;

    @FindBy(xpath = "//div[@data-test='payment-info-value']")
    private WebElement paymentInfoValue;

    @FindBy(xpath = "inventory_item_name")
    private WebElement inventoryName;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    public void clickFinishBtn()
    {
        genericUtils.waitForElementPresent(finishBtn);
        finishBtn.click();
        ExtentManager.test.log(LogStatus.INFO,"Finish btn is clicked");
    }
}
