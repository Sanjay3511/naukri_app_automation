package org.naukri.pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.naukri.gestures.GestureActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends GestureActions {
    AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Login']")
    public WebElement login;

    public void tapLogin(){
        login.click();
    }
}
