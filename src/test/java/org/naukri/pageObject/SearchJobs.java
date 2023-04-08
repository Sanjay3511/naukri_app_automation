package org.naukri.pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.naukri.gestures.GestureActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchJobs extends GestureActions {
    AndroidDriver driver;
    @AndroidFindBy(id = "naukriApp.appModules.login:id/et_skills")
    public WebElement skill;
    @AndroidFindBy(id="naukriApp.appModules.login:id/et_loc")
    public WebElement location;
    @AndroidFindBy(id = "naukriApp.appModules.login:id/b_search")
    public WebElement searchJobBtn;


    public SearchJobs(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public void setSkill(String skills){
        skill.sendKeys(skills);
        scrollableToText(skills);
    }

    public void setLocation(String locations){
        location.sendKeys(locations);
        scrollableToText(locations);
    }
    public ListJobsPage searchJob(){
        searchJobBtn.click();
        return new ListJobsPage(driver);
    }

}
