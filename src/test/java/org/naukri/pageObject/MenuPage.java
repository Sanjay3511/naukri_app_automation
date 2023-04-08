package org.naukri.pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.naukri.gestures.GestureActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends GestureActions {
    AndroidDriver driver;
    @AndroidFindBy(xpath="//android.widget.CheckedTextView[@text='Search jobs']")
    public WebElement searchJobs;
    public MenuPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public void tapSearchJobs(){
        searchJobs.click();
    }

}
