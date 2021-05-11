package com.mytime.support.web.driver;

import com.mytime.intern.Instances;

public class GetterConfig {
    public String browser(){
        return Instances.getWebdriverType();
    }

    public int[] resolution(){
        return Instances.getResolution();
    }

    public String activeUrl(){
        return Instances.getWebDriver().getCurrentUrl();
    }
}
