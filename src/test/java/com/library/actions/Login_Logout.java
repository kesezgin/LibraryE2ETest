package com.library.actions;

import com.library.pages.BooksPage;
import com.library.pages.LoginPage;
import com.library.utils.BrowserUtils;
import com.library.utils.ConfigurationReader;
import com.library.utils.Driver;

public class Login_Logout {

    private static final LoginPage loginPage = new LoginPage();
    private static final BooksPage booksPage = new BooksPage();

    public static void login(String email,String password){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.emailBox.sendKeys(email);
        loginPage.passwordBox.sendKeys(password);
        loginPage.signInButton.click();
    }

    public static void logout(){
        BrowserUtils.waitForGivenSeconds(5);
        booksPage.userDropdown.click();
        booksPage.logOutButton.click();
    }

}
