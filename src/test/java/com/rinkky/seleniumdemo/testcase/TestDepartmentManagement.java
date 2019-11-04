package com.rinkky.seleniumdemo.testcase;

import com.rinkky.seleniumdemo.page.ContactsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import org.hamcrest.Matchers;

import static org.junit.Assert.assertThat;

public class TestDepartmentManagement extends MultiLanguageCase{

    private ContactsPage page;
    public TestDepartmentManagement(String lang) throws Exception {
        super(lang);
    }

    @Before
    public void before() throws Exception {
        page = getApp().toContactsPage();
    }
    @Test
    public void testManageDepartment() throws Exception {
        page.renameRoot("ricky");
        page.addDepartmentFromDialog("test-1", new String[]{"ricky"})
                .addDepartmentFromDialog("test-1-1", new String[]{"ricky", "test-1"})
                .addDepartmentFromDialog("test-1-2", new String[]{"ricky", "test-1"})
                .addDepartmentFromDialog("test-1-3", new String[]{"ricky", "test-1"})
                .addDepartmentFromDialog("test-2", new String[]{"ricky"});
        List<String> secondLevelNames = page.getChildDepartments(new String[]{"ricky"});
        assertThat(secondLevelNames, Matchers.contains("test-1", "test-2"));

        List<String> names = page.getChildDepartments(new String[]{"ricky", "test-1"});
        assertThat(names, Matchers.contains("test-1-1", "test-1-2", "test-1-3"));

        page.moveUpDepartment(new String[]{"ricky", "test-1", "test-1-3"});
        names = page.getChildDepartments(new String[]{"ricky", "test-1"});
        assertThat(names, Matchers.contains("test-1-1", "test-1-3", "test-1-2"));

        page.deleteDepartment(new String[]{"ricky", "test-1", "test-1-3"});
        names = page.getChildDepartments(new String[]{"ricky", "test-1"});
        assertThat(names, Matchers.not(Matchers.hasItem("test-1-3")));
    }
}
