package org.naukri.pageObject;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.naukri.gestures.GestureActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListJobsPage extends GestureActions {
    AndroidDriver driver;
    public ListJobsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id="naukriApp.appModules.login:id/textViewCompanyName")
    public List<WebElement> companyList;

    public void getCompanyName() throws IOException {
        try {
            FileWriter csvWriter = new FileWriter(new File("/home/sanjay/practice/naukri_app/src/companyList/companyname.csv"));
            int companyCount = companyList.size();
            for(int i= 0; i<companyCount; i++){
                List<String> names = Collections.singletonList(companyList.get(i).getText());
                csvWriter.append(String.join(",",names));
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
            System.out.println("Succeddfully Tranfered");
        }
        catch (IOException e){
            System.out.println("Error While exporting to csvFile "+ e.getMessage());
        }
    }
    public void scrollCompanies(){
//        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
        scrollToDown();
    }
    public void companyData() throws IOException {
        try {
            FileWriter csvWriter = new FileWriter(new File("/home/sanjay/practice/naukri_app/src/companyList/companyname.csv"));
            String lastCompanyName = "";
            int consecutiveCount = 0;
            while (true) {
                int companyCount = companyList.size();
                for (int i = 0; i < companyCount; i++) {
                    String companyName = companyList.get(i).getText();
                    if (companyName.equals(lastCompanyName)) {
                        consecutiveCount++;
                        if (consecutiveCount >= 4) {
                            csvWriter.flush();
                            csvWriter.close();
                            System.out.println("Stopped scrolling as the same company name appeared more than thrice in a row.");
                            return;
                        }
                    } else {
                        consecutiveCount = 1;
                    }
                    List<String> names = Collections.singletonList(companyName);
                    csvWriter.append(String.join(",", names));
                    csvWriter.append("\n");
                    lastCompanyName = companyName;
                }
                driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(" + companyCount + ")"));
                companyList = driver.findElements(MobileBy.id("naukriApp.appModules.login:id/textViewCompanyName"));
            }
        } catch (IOException e) {
            System.out.println("Error While exporting to csvFile " + e.getMessage());
        }
    }
    }

