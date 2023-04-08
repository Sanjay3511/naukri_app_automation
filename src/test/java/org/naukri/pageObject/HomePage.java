package org.naukri.pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.naukri.gestures.GestureActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends GestureActions {
    AndroidDriver driver;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
    public WebElement menu;
    @AndroidFindBy(id = "naukriApp.appModules.login:id/textViewContinue")
    public WebElement continueBtn;


    public HomePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public  void tapMenu()  {
        menu.click();
    }
    public void tapContinue(){
        continueBtn.click();
    }

}

