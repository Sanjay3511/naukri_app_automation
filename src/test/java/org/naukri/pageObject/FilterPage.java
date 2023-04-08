package org.naukri.pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.naukri.gestures.GestureActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FilterPage extends GestureActions {
    AndroidDriver driver;

    public FilterPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id="naukriApp.appModules.login:id/imageViewFilter")
    public WebElement filter;

    public void tapFilter(){
        filter.click();
    }
    public void setDepartment(){
        driver.findElement(By.xpath("//android.widget.TextView[@text='Department']")).click();
        driver.findElement(By.xpath("//android.widget.CheckBox[@text='Engineering - Software & QA']")).click();

    }
    public void setWorkMode(){
        driver.findElement(By.xpath("//android.widget.TextView[@text='Work mode']")).click();
        driver.findElement(By.xpath("//android.widget.CheckBox[@text='Hybrid']")).click();
    }
    public void setExperience(){
        driver.findElement(By.xpath("//android.widget.TextView[@text='Experience']")).click();
        seekBar();
    }
    public void setSalary(){
        driver.findElement(By.xpath("//android.widget.TextView[@text='Salary']")).click();
        driver.findElement(By.xpath("//android.widget.CheckBox[@text='6-10 Lakhs']")).click();
    }
    public void setRole(){
        driver.findElement(By.xpath("//android.widget.TextView[@text='Role']")).click();
        driver.findElement(By.xpath("//android.widget.CheckBox[@text='Automation Test Engineer']")).click();
    }
    public void  setFreshness(){
        driver.findElement(By.xpath("//android.widget.TextView[@text='Freshness']")).click();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Last 30 days']")).click();
    }
    public void tapApplyFilter(){
        driver.findElement(By.xpath("//android.widget.TextView[@text='Apply filters']")).click();
    }



}
