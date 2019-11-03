package com.rinkky.seleniumdemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class App extends BasePage{
    public final String url = "https://work.weixin.qq.com/";
    public static ResourceBundle res;

    public App() throws Exception {
        res = ResourceBundle.getBundle("uitext", new Locale(""));
        loginWithCookie();
    }

    public App(ResourceBundle res) throws Exception {
        App.res = res;
        loginWithCookie();
    }

    public App loginWithCookie() throws IOException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.linkText(res.getString("languageBtnText"))).click();
        driver.findElement(By.linkText(res.getString("loginBtnText"))).click();
        Properties prop = new Properties();
        prop.load(new FileInputStream("/conf/seleniumdemo/cookie.conf"));
        for (Object key : prop.keySet()){
            System.out.println(key.toString());
            System.out.println(prop.get(key).toString());
            driver.manage().addCookie(new Cookie(key.toString(), prop.get(key).toString()));
        }
        driver.navigate().refresh();
        return this;
    }

    public App changeLanguage(String lang){
        findClickable(By.cssSelector(".i18n_dropdown"), 5).click();
        findClickable(By.linkText(lang), 5).click();
        return this;
    }
    public ContactsPage toContactsPage(){
        return new ContactsPage();
    }
}
