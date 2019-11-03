package com.rinkky.seleniumdemo.testcase;

import com.rinkky.seleniumdemo.page.App;
import com.rinkky.seleniumdemo.page.BasePage;
import com.rinkky.util.XMLResourceBundleControl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@RunWith(Parameterized.class)
public class TestDepartmentManagement{
    public static App app;
    private static ResourceBundle resourceBundle;

    public TestDepartmentManagement(String lang) throws Exception {
        resourceBundle = ResourceBundle.getBundle("uitext", new Locale(lang), new XMLResourceBundleControl());
        app = getApp(resourceBundle);
        app.changeLanguage(resourceBundle.getString("languageBtnText"));
    }

    @Parameterized.Parameters
    public static List data(){
        return Arrays.asList(new String[][]{{"zh"},{""}});
    }

    public static App getApp(ResourceBundle res) throws Exception {
        if(app != null){
            return app;
        }
        return new App(res);
    }

    @AfterClass
    public static void afterAll(){
        app.driver.close();
    }

    @Test
    public void demo() throws InterruptedException {
        Thread.sleep(10000);
        assert true;
    }

    @Test
    public void createDepartment(){

    }
}
