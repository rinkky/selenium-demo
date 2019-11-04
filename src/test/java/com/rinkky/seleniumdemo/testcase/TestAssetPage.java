package com.rinkky.seleniumdemo.testcase;

import com.rinkky.seleniumdemo.page.AssetPage;
import com.rinkky.seleniumdemo.page.ContactsPage;
import org.junit.Test;
import org.hamcrest.Matchers;

import static org.junit.Assert.assertThat;

public class TestAssetPage extends MultiLanguageCase {
    public TestAssetPage(String lang) throws Exception {
        super(lang);
    }

    @Test
    public void upload() throws Exception {
        AssetPage page = getApp().toAssetPage();
        page.uploadImg("C:\\rinkky\\seleniumdemo_case\\res\\test.jpg");
        assertThat(page.getUploadedFileNames(), Matchers.hasItem("test.jpg"));
    }
}
