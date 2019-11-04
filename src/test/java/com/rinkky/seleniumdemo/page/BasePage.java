package com.rinkky.seleniumdemo.page;

import com.rinkky.util.UiTextFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ResourceBundle;

public class BasePage {
    public static WebDriver driver;
    private static ResourceBundle uiTextRes;
    private static String lang;

    public ResourceBundle getUiRes(){
        return uiTextRes;
    }
    public static void setUiRes(ResourceBundle res){
        uiTextRes = res;
    }
    public static void setLang(String lang){
        BasePage.lang = lang;
        setUiRes(UiTextFactory.getRes(lang));
    }
    public static String getLang(){
        return lang;
    }

    public WebElement findElement(By by){
        return findElement(by, 5, driver);
    }
    public WebElement findElement(By by, SearchContext context){
        return findElement(by, 5, context);
    }
    public WebElement findElement(By by, int timeOutInSeconds){
        return findElement(by, timeOutInSeconds, driver);
    }
    public WebElement findElement(By by, int timeOutInSeconds, SearchContext context){
        WebElement element = context.findElement(by);
        waitVisible(element, timeOutInSeconds);
        return element;
    }

    public WebElement findClickable(By by){
        return findClickable(by, 5);
    }
    public WebElement findClickable(By by, SearchContext context){
        WebElement element = findElement(by, context);
        waitClickable(element, 5);
        return element;
    }
    public WebElement findClickable(By by, int timeOutInSeconds){
        WebElement element = findElement(by);
        waitClickable(element, timeOutInSeconds);
        return element;
    }
    public void waitVisible(WebElement element, int timeOutInSeconds){
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));
    }
    public void waitClickable(WebElement element, int timeOutInSeconds){
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(element));
    }
    public void wait(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
