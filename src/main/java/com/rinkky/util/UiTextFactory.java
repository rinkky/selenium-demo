package com.rinkky.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class UiTextFactory {
    private  UiTextFactory(){
    }
    private static HashMap<String, ResourceBundle> mapRes = new HashMap<String, ResourceBundle>();
    public static ResourceBundle getRes(String lang){
        Locale locale = new Locale(lang);
        if(lang.isEmpty() || lang.equals("en")){
            locale = Locale.ROOT;
        }
        return getRes(locale);
    }
    public static ResourceBundle getRes(Locale locale){
        String key = locale.getLanguage();
        if(key.isEmpty()){
            key = "en";
        }
        if(mapRes.containsKey(key)){
            return mapRes.get(key);
        }
        ResourceBundle res = ResourceBundle.getBundle("uitext", locale, new XMLResourceBundleControl());
        mapRes.put(key, res);
        return res;
    }
}
