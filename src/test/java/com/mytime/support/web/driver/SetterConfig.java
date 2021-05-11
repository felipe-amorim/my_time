package com.mytime.support.web.driver;

import com.mytime.intern.Instances;

public class SetterConfig {
    public BrowserTypes browser(){
        return Instances.getBrowserTypesClassInstance();
    }

    public DriverOptions options(){
        return Instances.getDriverOptionsClassInstance();
    }
}
