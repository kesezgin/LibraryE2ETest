package com.library.pages;

import com.library.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BooksPage extends BasePage{

    public BooksPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//tbody//a")
    public List<WebElement> editBookButtons;

    @FindBy(css = "input[name='name']")
    public WebElement bookNameInput;

    @FindBy(css = "input[name='author']")
    public WebElement authorNameInput;

    @FindBy(css = "input[name='isbn']")
    public WebElement isbnInput;

    @FindBy(css = "input[name='year']")
    public WebElement yearInput;

    @FindBy(id = "description")
    public WebElement descriptionInput;

    @FindBy(id = "book_group_id")
    public WebElement bookCategoryDropdown;

    @FindBy(xpath = "//button[.='Save changes']")
    public WebElement saveChangesButton;

    @FindBy(xpath = "//button[.='Close']")
    public WebElement closeEditWindowButton;

    @FindBy(id="toast-container")
    public WebElement updateSuccessfulPopup;

}
