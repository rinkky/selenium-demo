package com.rinkky.seleniumdemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AssetPage extends BasePage {
    public AssetPage uploadImg(String imgPath){
        findClickable(By.cssSelector(".ww_icon_GrayPic")).click();
        findClickable(By.cssSelector(".js_upload_file_selector")).click();
        driver.findElement(By.id("js_upload_input")).sendKeys(imgPath);
        while(true){
            try {
                WebElement elem = findElement(By.xpath("//div[@file-id=\"NaN\"]"));
                Thread.sleep(1000);
            } catch (NoSuchElementException e) {
                break;
            } catch (InterruptedException e) { }
        }
        findElement(By.xpath("//a[@d_ck=\"submit\"]")).click();
        return this;
    }
    public List<String> getUploadedFileNames(){
        List<WebElement> elems = driver.findElements(By.cssSelector(".material_picCard_text"));
        ArrayList<String> names = new ArrayList<String>();
        for (WebElement elem: elems) {
            names.add(elem.getText());
        }
        return names;
    }
}
