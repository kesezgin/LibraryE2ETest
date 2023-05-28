package com.library.step_definitions;

import com.library.actions.EditBook;
import com.library.actions.Login_Logout;
import com.library.pages.BooksPage;
import com.library.utils.APIUtils;
import com.library.utils.ConfigurationReader;
import com.library.utils.DBUtils;
import com.library.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.Matchers.*;

public class EditBookStepDefinitions {

    BooksPage booksPage = new BooksPage();
    private static String BOOK;
    private static String AUTHOR;
    private static String TOKEN;
    private static int ID;

    @Given("Librarian is logged in the application")
    public void librarianIsLoggedInTheApplication() {
        Login_Logout.login(ConfigurationReader.getProperty("librarian.email"),
                ConfigurationReader.getProperty("librarian.password"));
    }

    @When("^Librarian clicks (Home|Dashboard|Users|Books|User) button$")
    public void librarianClicksBooksButton(String button) {
        switch (button) {
            case "Books":
                booksPage.booksButton.click();
                break;
            case "Home":
                booksPage.homeButton.click();
                break;
        }
    }

    @And("Clicks the {int}. Edit Book button to edit the book")
    public void clicksTheFirstEditBookButtonToEditTheBook(int number) {
        booksPage.editBookButtons.get(number).click();
    }

    @And("Enters {string} {string} {int} {string} {string} and {string}")
    public void entersYearAnd(String bookName, String isbn,int year, String authorName, String bookCategory, String description){
        BOOK = bookName;
        AUTHOR = authorName;
        EditBook.editBook(bookName,isbn,year,authorName,bookCategory,description);
    }

    @And("^Clicks (Save changes|Close) button$")
    public void clicksSaveChangesButton(String buttonName) {
        switch (buttonName) {
            case "Save changes":
                booksPage.saveChangesButton.click();
                break;
            case "Close":
                booksPage.closeEditWindowButton.click();
        }

    }

    @Then("Librarian sees the update successful message")
    public void librarianSeesTheBookEditedProperly() {
        assertTrue(booksPage.updateSuccessfulPopup.isDisplayed());
    }

    @And("The updated book exists in database")
    public void theUpdatedBookExistsInDatabase() {
        Map<String, Object> createdBook = DBUtils.getFirstRowMap(
                "select *\n" +
                        "from books\n" +
                        "where author = '"+AUTHOR+"' and name = '"+BOOK+"';");
        assertEquals(BOOK,createdBook.get("name"));
        assertEquals(AUTHOR,createdBook.get("author"));
    }

    @And("Librarian logs out successfully")
    public void librarianLogsOutSuccessfully() {
        Login_Logout.logout();
        assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
    }

    @And("The updated book is returned by API")
    public void theUpdatedBookIsReturnedByAPI() {

        TOKEN = APIUtils.getToken(ConfigurationReader.getProperty("librarian.email"),
                ConfigurationReader.getProperty("librarian.password"));

        ID = DBUtils.getIDofBook(
                "select *\n" +
                        "from books\n" +
                        "where author = '"+AUTHOR+"' and name = '"+BOOK+"';","id");

        APIUtils.getBookByID(TOKEN, ID)
                .then().statusCode(200)
                .body("name",is(BOOK))
                .body("author",is(AUTHOR));

    }
}
