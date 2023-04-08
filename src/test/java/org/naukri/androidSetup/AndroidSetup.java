package org.naukri.androidSetup;

import io.appium.java_client.android.AndroidDriver;
import org.naukri.appPath.AppSetup;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidSetup {
    public DesiredCapabilities caps;
    public  AndroidDriver driver;
    public String apkPath =  new AppSetup().appUrl();
    public String appUrl = "http://127.0.0.1:4723/wd/hub";


    @BeforeTest
    public void setCaps() throws MalformedURLException {
        caps =  new DesiredCapabilities();
        caps.setCapability("deviceName","emulator-5554");
        caps.setCapability("platFormName","Android");
        caps.setCapability("app", apkPath);
        caps.setCapability("automationName","UIAutomator2");
        driver = new AndroidDriver(new URL(appUrl), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
