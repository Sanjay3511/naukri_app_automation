package org.naukri.pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.naukri.gestures.GestureActions;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GestureActions {
    AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
}
