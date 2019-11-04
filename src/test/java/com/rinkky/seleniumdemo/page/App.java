package com.rinkky.seleniumdemo.page;

import com.rinkky.util.UiTextFactory;
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
    private final String url = "https://work.weixin.qq.com/";
    private static String confPath = "/conf/seleniumdemo/cookie.conf";

    public App() throws Exception {
        this("");
    }

    public App(String lang) throws Exception {
        setLang(lang);
        loginWithCookie();
    }

    public App loginWithCookie() throws IOException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        findElement(By.linkText(getUiRes().getString("languageBtnText"))).click();
        findElement(By.linkText(getUiRes().getString("loginBtnText"))).click();
        Properties prop = new Properties();
        prop.load(new FileInputStream(confPath));
        for (Object key : prop.keySet()){
            driver.manage().addCookie(new Cookie(key.toString(), prop.get(key).toString()));
        }
        driver.navigate().refresh();
        return this;
    }

    public App changeLanguage(String lang){
        setLang(lang);
        findClickable(By.cssSelector(".i18n_dropdown"), 5).click();
        findClickable(By.linkText(lang), 5).click();
        return this;
    }
    public ContactsPage toContactsPage(){
        findClickable(By.id("menu_contacts")).click();
        return new ContactsPage();
    }
    public AssetPage toAssetPage(){
        findClickable(By.id("menu_manageTools")).click();
        findClickable(By.cssSelector(".ww_icon_AppMaterialBig")).click();
        return new AssetPage();
    }
    public void quit(){
        driver.quit();
    }
}
