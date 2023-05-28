package com.library.utils;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    /**
     * This method selects an option from given dropdown according to the visible text
     * @param dropdown - dropdown located as a web element
     * @param visibleText - visible text of one of the options in the dropdown
     */
    public static void selectFromDropdown(WebElement dropdown, String visibleText){
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    /**
     * This method clears the input box and send keys to it
     * @param inputBox - input box located to send keys
     * @param value - value to send as keys to the input box
     */
    public static void sendKeysAfterClear(WebElement inputBox, Object value){
        inputBox.clear();
        inputBox.sendKeys(String.valueOf(value));
    }

    /**
     * This method waits the driver for given seconds
     * @param second - desired seconds to wait
     */
    public static void waitForGivenSeconds(double second){
        try {
            Thread.sleep((long) (second * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
