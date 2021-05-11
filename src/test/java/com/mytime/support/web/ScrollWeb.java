package com.mytime.support.web;

import com.mytime.intern.Instances;
import org.openqa.selenium.JavascriptExecutor;

public class ScrollWeb {
    public void inside(String xpath){
        //Instances.setWebLastModalXpath(xpath);
        //Instances.getLocatorWebClassInstance().locate(xpath, true);
    }

    public void up(int amount){
        JavascriptExecutor js = (JavascriptExecutor) Instances.getWebDriver();
        js.executeScript("window.scrollBy(0,-" + amount + ")");
    }

    public void down(int amount){
        JavascriptExecutor js = (JavascriptExecutor) Instances.getWebDriver();
        js.executeScript("window.scrollBy(0," + amount + ")");
    }
}
