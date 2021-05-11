package com.mytime.support.web.driver;

import com.mytime.intern.Instances;
import com.mytime.support.commons.Log;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriver {
    public SetterConfig set() {
        return Instances.getSetterConfigClassInstance();
    }

    public GetterConfig get() {
        return Instances.getGetterConfigClassInstance();
    }

    public void navigate(String url) {
        Instances.setWebDriver();
        Instances.getWebDriver().navigate().to(url);
        Capabilities cap = ((RemoteWebDriver) Instances.getWebDriver()).getCapabilities();
        Log.logPurple("Browser version: " + cap.getVersion());
        Log.log(Instances.getMessageNavigate() + url);
    }

    public WebDriver newTab(){
        Instances.webDriverIndex = Instances.webDriver.size();
        Instances.setWebDriver();
        return this;
    }

    public WebDriver useTab(int index){
        Instances.webDriverIndex = index;
        return this;
    }

    public void kill(){
        Instances.killAllDrivers();
    }

    public void refresh(){
        Instances.getWebDriver().navigate().refresh();
    }
}
