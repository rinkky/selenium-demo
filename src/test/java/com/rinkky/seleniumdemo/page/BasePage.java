package com.rinkky.seleniumdemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static WebDriver driver;
    public WebElement findElement(By by){
        return driver.findElement(by);
    }
    public WebElement findElement(By by, int timeOutInSeconds){
        waitVisible(by, timeOutInSeconds);
        return findElement(by);
    }
    public WebElement findClickable(By by, int timeOutInSeconds){
        waitClickable(by, timeOutInSeconds);
        return findElement(by);
    }
    public void waitVisible(By by, int timeOutInSeconds){
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitClickable(By by, int timeOutInSeconds){
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(by));
    }
}
