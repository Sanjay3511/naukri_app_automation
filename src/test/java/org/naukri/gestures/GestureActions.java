package org.naukri.gestures;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;

public class GestureActions{
    AndroidDriver  driver;
    public GestureActions(AndroidDriver driver) {
        this.driver = driver;
    }


    public void LongPressAction(WebElement ele){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
                        "duration",20000));
    }
    public void scrollableToText(String text){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
    }
    public  void scrollToDown(){
        boolean canScrollMore;
        do
        {
            canScrollMore = (Boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of("left", 120, "top", 120,
                            "width", 200, "height", 200,
                            "direction", "down",
                            "percent", 3.89));
        }while(canScrollMore);
    }
    public  void scrollToTop(){
        boolean canScrollMore;
        do
        {
            canScrollMore = (Boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of("left", 100, "top", 100,
                            "width", 200, "height", 200,
                            "direction", "up",
                            "percent", 3.0));
        }while(canScrollMore);
    }
    public void swipe(WebElement ele,String dir){
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
                        "direction",dir,
                        "percent", 0.75));
    }
    public  void swipeTillEnd() {
        boolean swipeTillEnd;
        do {
            swipeTillEnd =(Boolean)((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                    ImmutableMap.of("direction", "left", "percent", 0.75));
        }while (swipeTillEnd);
    }
    public void dragAndDropAction(WebElement ele, double endX, double endY){
        ((JavascriptExecutor)driver).executeScript("mobile:dragGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
                        "endX", endX,
                        "endY", endY));
    }
    public Double removeDollar(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }
    public void customScroll(WebElement ele){
         ele = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@index='1']"));
        Point location = ele.getLocation();
        Dimension size = ele.getSize();

    }
    public void scrollToEnd(int scrollCount){
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd("+scrollCount+")"));
    }
    public void seekBar(){
        WebElement ele = driver.findElement(By.xpath("//android.widget.SeekBar[@index='2']"));
        int startX = ele.getLocation().getX();
        System.out.println(" start x " +startX );
        int startY = ele.getLocation().getY();
        System.out.println(" start Y " +startY );
        int endX = ele.getSize().getWidth();
        System.out.println("endX is"+endX);
        TouchAction touchAction = new TouchAction(driver);
        int moveToE = (int)(endX*0.62);
//        touchAction.longPress(PointOption.point(startX,startY)).moveTo(PointOption.point(moveToE,startY)).release().perform();
        touchAction.press(PointOption.point(startX,startY)).moveTo(PointOption.point(moveToE,startY)).release().perform();
    }
}
