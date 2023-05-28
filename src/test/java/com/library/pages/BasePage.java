package com.library.pages;

import com.library.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "ul[id='menu_item']>li:nth-of-type(1)")
    public WebElement dashboardButton;

    @FindBy(css = "ul[id='menu_item']>li:nth-of-type(2)")
    public WebElement usersButton;

    @FindBy(css = "ul[id='menu_item']>li:nth-of-type(3)")
    public WebElement booksButton;

    @FindBy(id="navbarDropdown")
    public WebElement userDropdown;

    @FindBy(className = "navbar-brand")
    public WebElement homeButton;

    @FindBy(xpath = "//a[.='Log Out']")
    public WebElement logOutButton;

}
