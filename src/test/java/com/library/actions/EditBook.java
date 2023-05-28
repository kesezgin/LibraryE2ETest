package com.library.actions;

import com.library.pages.BooksPage;
import com.library.utils.BrowserUtils;

public class EditBook {

    private static final BooksPage booksPage = new BooksPage();

    public static void editBook(String bookName, String isbn, int year, String authorName, String bookCategory, String description){
        BrowserUtils.waitForGivenSeconds(0.5);
        BrowserUtils.sendKeysAfterClear(booksPage.bookNameInput,bookName);
        BrowserUtils.waitForGivenSeconds(0.5);
        BrowserUtils.sendKeysAfterClear(booksPage.isbnInput,isbn);
        BrowserUtils.waitForGivenSeconds(0.5);
        BrowserUtils.sendKeysAfterClear(booksPage.yearInput,year);
        BrowserUtils.waitForGivenSeconds(0.5);
        BrowserUtils.sendKeysAfterClear(booksPage.authorNameInput,authorName);
        BrowserUtils.waitForGivenSeconds(0.5);
        BrowserUtils.selectFromDropdown(booksPage.bookCategoryDropdown, bookCategory);
        BrowserUtils.waitForGivenSeconds(0.5);
        BrowserUtils.sendKeysAfterClear(booksPage.descriptionInput,description);
    }

}
