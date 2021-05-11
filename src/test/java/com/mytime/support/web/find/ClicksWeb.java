package com.mytime.support.web.find;

import com.mytime.intern.Instances;
import com.mytime.support.commons.Log;

public class ClicksWeb {
    public void twice(){
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(Instances.getWebDriver());
        actions.doubleClick(Instances.getWebLastElements().get(0)).perform();
        Log.log(Instances.getMessageDoubleClick() + Instances.getWebLastXpath());
    }
}
