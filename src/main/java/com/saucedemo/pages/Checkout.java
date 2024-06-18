package com.saucedemo.pages;

import com.relevantcodes.extentreports.LogStatus;
import com.saucedemo.utils.ExtentManager;
import com.saucedemo.utils.GenericUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {

    WebDriver driver;
    GenericUtils genericUtils;
    public Checkout(WebDriver driver)
    {
        this.driver=driver;
        genericUtils=new GenericUtils(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="first-name")
    private WebElement firstNameEdit;

    @FindBy(id="last-name")
    private WebElement lastNameEdit;

    @FindBy(id="postal-code")
    private WebElement postalCodeEdit;

    @FindBy(id="continue")
    private WebElement continueBtn;

    public void enterCheckoutDetails()
    {
        firstNameEdit.sendKeys("Kumar");
        lastNameEdit.sendKeys("Shubham");
        postalCodeEdit.sendKeys("815351");
    }

    public void clickOnContinueBtn()
    {
        continueBtn.click();
        ExtentManager.test.log(LogStatus.INFO,"chekout details page continue btn is successful");
    }

}
