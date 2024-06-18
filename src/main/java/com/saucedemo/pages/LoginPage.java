package com.saucedemo.pages;

import com.relevantcodes.extentreports.LogStatus;
import com.saucedemo.utils.ExtentManager;
import com.saucedemo.utils.GenericUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    GenericUtils genericUtils;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        genericUtils=new GenericUtils(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "login_logo")
    private WebElement loginLogo;

    @FindBy(id="user-name")
    private WebElement usernameEdit;

    @FindBy(id="password")
    private WebElement passwordEdit;

    @FindBy(id="login-button")
    private WebElement loginBtn;

    public void login()
    {
        genericUtils.waitForElementPresent(usernameEdit);
        usernameEdit.sendKeys("standard_user");
        passwordEdit.sendKeys("secret_sauce");
        loginBtn.click();
        ExtentManager.test.log(LogStatus.INFO,"Login is successful");
    }

}
