package org.naukri.testCase;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.naukri.androidSetup.AndroidSetup;
import org.naukri.gestures.GestureActions;
import org.naukri.pageObject.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class LoginTest extends AndroidSetup {
    @Test
    public void login() throws InterruptedException, IOException {
        /* Please Make sure Login using your credentials*/
        ListJobsPage listJobsPage = new ListJobsPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.tapContinue();
        homePage.tapMenu();
        MenuPage menuPage = new MenuPage(driver);
        menuPage.tapSearchJobs();
        SearchJobs searchJobs = new SearchJobs(driver);
        searchJobs.setSkill("Software Test Engineer");
        searchJobs.setLocation("Bangalore/Bengaluru");
        listJobsPage=searchJobs.searchJob();
        FilterPage fp = new FilterPage(driver);
        fp.tapFilter();
        fp.setWorkMode();
        fp.setDepartment();
        fp.setExperience();
        fp.setSalary();
        fp.setFreshness();
        fp.tapApplyFilter();
        Thread.sleep(1000);
        listJobsPage.companyData();
        Thread.sleep(10000);
    }
}
