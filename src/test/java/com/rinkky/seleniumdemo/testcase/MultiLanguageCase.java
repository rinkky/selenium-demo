package com.rinkky.seleniumdemo.testcase;

import com.rinkky.seleniumdemo.page.App;
import com.rinkky.util.UiTextFactory;
import com.rinkky.util.XMLResourceBundleControl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@RunWith(Parameterized.class)
public class MultiLanguageCase {
    private static App app;
    private static ResourceBundle resourceBundle;
    private static String lang;

    public MultiLanguageCase(String lang) throws Exception {
        setLang(lang);
    }

    @Parameterized.Parameters
    public static List data(){
        return Arrays.asList(new String[][]{{"zh"}, {"en"}});
    }

    public static App getApp() throws Exception {
        if(app == null){
            return new App(lang);
        }
        return app;
    }

    public static void setLang(String lang){
        MultiLanguageCase.lang = lang;
    }

    @AfterClass
    public static void afterAll() throws Exception {
        app.quit();
        app = null;
    }
}
