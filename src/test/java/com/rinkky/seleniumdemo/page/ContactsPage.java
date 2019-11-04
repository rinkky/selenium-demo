package com.rinkky.seleniumdemo.page;

import com.rinkky.util.UiTextFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ContactsPage extends BasePage{
    public ContactsPage renameRoot(String name){
        WebElement root = findElement(By.cssSelector(".jstree")).findElement(By.xpath("./ul/li/a"));
        root.click();
        findClickable(By.xpath("./span"), root).click();
        WebElement menu = getDepartmentMenu();
        findClickable(By.linkText(getUiRes().getString("changeDepartmentNameBtnText")), menu).click();
        findElement(By.name("name")).sendKeys(name);
        findClickable(By.xpath("//a[@d_ck=\"submit\"]")).click();
        wait(500);
        return this;
    }
    public ContactsPage addDepartmentFromDialog(String name, String[] hierarchy){
        getTopAddBtn().click();
        findClickable(By.linkText(getUiRes().getString("addDepartmentBtnText"))).click();
        findClickable(By.name("name")).sendKeys(name);
        findElement(By.linkText(getUiRes().getString("chooseDepartmentBtnTxt"))).click();
        WebElement form = findElement(By.tagName("form"));
        expandAllList(form);
        findHierarchy(hierarchy, form).click();
        findClickable(By.xpath("//a[@d_ck=\"submit\"]")).click();
        wait(500);
        return this;
    }
    public ContactsPage deleteDepartment(String[] hierarchy){
        openContextMenu(hierarchy);
        findClickable(By.linkText(getUiRes().getString("deleteDepartmentBtnText")), getDepartmentMenu()).click();
        findClickable(By.xpath("//a[@d_ck=\"submit\"]")).click();
        return this;
    }
    public ContactsPage moveUpDepartment(String[] hierarchy){
        openContextMenu(hierarchy);
        findClickable(By.linkText(getUiRes().getString("moveUpBtnText")), getDepartmentMenu()).click();
        return this;
    }
    public ContactsPage moveDownDepartment(String[] hierarchy){
        openContextMenu(hierarchy);
        findClickable(By.linkText(getUiRes().getString("moveDownBtnText")), getDepartmentMenu()).click();
        return this;
    }
    public ContactsPage openContextMenu(String[] hierarchy){
        WebElement container = findElement(By.cssSelector(".jstree"));
        expandAllList(container);
        WebElement node = findHierarchy(hierarchy, container);
        node.click();
        findClickable(By.xpath("./span"), node).click();
        return this;
    }
    public WebElement getTopAddBtn(){
        return findClickable(By.cssSelector(".member_colLeft_top_addBtnWrap"));
    }
    public ContactsPage expandAllList(SearchContext context){
        while(true){
            try {
                WebElement expandIcon = findElement(By.xpath(".//li[@aria-expanded=\"false\"]/i"), context);
                waitClickable(expandIcon, 5);
                expandIcon.click();
                Thread.sleep(300);
            }catch(Exception e){
                break;
            }
        }
        return this;
    }

    public WebElement findHierarchy(String[] hierarchy, SearchContext context){
        WebElement node = findClickable(By.linkText(hierarchy[0]), context);
        if(hierarchy.length == 1){
            return node;
        }
        WebElement newContext = findElement(By.xpath("./../ul"), node);
        String[] newHierarchy = Arrays.copyOfRange(hierarchy, 1, hierarchy.length);
        return findHierarchy(newHierarchy, newContext);
    }
    public List<String> getChildDepartments(String[] hierarchy){
        WebElement container = findElement(By.cssSelector(".jstree"));
        expandAllList(container);
        WebElement elem = findHierarchy(hierarchy, container);
        List<WebElement> children = elem.findElements(By.xpath("./../ul/li/a"));
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < children.size(); i++) {
            names.add(children.get(i).getText());
        }
        return names;
    }
    private WebElement getDepartmentMenu(){
        return findElement(By.xpath("//body/ul"));
    }
}
