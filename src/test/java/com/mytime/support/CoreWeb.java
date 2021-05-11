package com.mytime.support;

import com.mytime.intern.Instances;
import com.mytime.support.commons.Log;
import com.mytime.support.web.ScrollWeb;
import com.mytime.support.web.driver.WebDriver;
import com.mytime.support.web.find.ActionsWeb;
import com.mytime.support.commons.AssertThat;
import com.mytime.support.web.find.exceptionals.ExceptionalsWeb;
import com.mytime.support.web.sleep.SleepWeb;

public abstract class CoreWeb {

    public ActionsWeb find(String xpath){
        Instances.setLastTechnology(Instances.Technology.WEB);
        Instances.setWebLastXpath(xpath);
        return Instances.getActionsClassInstance();
    }

    public ExceptionalsWeb find(){
        Instances.setLastTechnology(Instances.Technology.WEB);
        return Instances.getExceptionalsWebClassInstance();
    }

    public ScrollWeb scroll(){
        return Instances.getScrollWebClassInstance();
    }

    public SleepWeb sleep(){
        return Instances.getSleepWebClassInstance();
    }

    public WebDriver webDriver(){
        return Instances.getWebDriverClassInstance();
    }

    public Log log(){
        return Instances.getLogClassInstance();
    }

    public void evidence(String complemento){
        Instances.getScreenshotClassInstance().printAfterForced();
        Instances.setAtLeastOneEvidence(true);
        Log.log(Instances.getMessageScreenshotForced()+complemento);
    }

    public Error error(){
        return Instances.getErrorClassInstance();
    }

    protected CoreWeb help(){
        return this;
    }

    public AssertThat assertThat(String text){
        Instances.setAssertionText(text);
        Instances.setAtLeastOneAssert(true);
        Instances.setThenTagAssert(true);
        Instances.setSoftAssert(false);
        return Instances.getAssertThatClassInstance();
    }
}
