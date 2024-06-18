package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete {

    WebDriver driver;
    public CheckoutComplete(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "pony_express")
    private WebElement successTickMark;

    @FindBy(xpath = "//h2[@data-test='complete-header']")
    private WebElement successHeader;

    @FindBy(xpath = "//span[@data-test='title']")
    private WebElement title;

    public boolean isTickMarkPresent()
    {
        return successTickMark.isDisplayed();
    }

    public String getHeaderText()
    {
        return successHeader.getText();
    }
}
