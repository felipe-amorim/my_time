package com.mytime.intern;

import com.mytime.support.commons.Log;
import com.mytime.support.web.ScrollWeb;
import org.openqa.selenium.WebDriverException;

import java.util.Calendar;


public class Execute {
    int localTime = 0;
    int logInterval = 5000;
    int logIntervalDefault = 5000;

    public void execute(Runnable runnable){
        execute(runnable, false, false);
    }

    public void execute(Runnable runnable, boolean isAvailable){execute(runnable, isAvailable, false); }


    public void execute(Runnable runnable, boolean isAvailable, boolean isExceptional){
        String erroE = "";
        int scrollSwitch = 1;
        ScrollWeb scrollWeb = new ScrollWeb();
        int amoutToScroll = 50;
        int scrollInterval = 50;
        boolean executed = false;
        Throwable t = null;
        Instances.getScreenshotClassInstance().printBefore();
        while (true){
            long ti = Calendar.getInstance().getTimeInMillis();
            try {
                runnable.run();
                Instances.setIsAvailable(true);
                executed = true;
                Instances.getScreenshotClassInstance().printAfter();
                break;
            } catch (WebDriverException e){
                erroE = e.getMessage();
                t = e;
                if(erroE.contains("element click intercepted:")) {
                    if (scrollSwitch > 0) {
                        scrollWeb.up(amoutToScroll);
                    } else {
                        scrollWeb.down(amoutToScroll);
                    }
                    amoutToScroll += scrollInterval;
                    scrollSwitch = scrollSwitch * -1;
                }else{
                    Log.logCyan(erroE);
                }
            }

            checkTimeLeft(ti);
            if (localTime <= 0) {
                break;
            }
        }
        if(!executed){
            if(!isAvailable) {
                Log.logRed(t);
            }else {
                Instances.setIsAvailable(false);
            }
        }
    }

    private void checkTimeLeft(long ti){
        long tf = Calendar.getInstance().getTimeInMillis();
        int tr = (int) (tf - ti);

        localTime = localTime - tr;

        logInterval = logInterval - tr;
        if(logInterval<=0) {
            logInterval = logIntervalDefault;
            Log.logPurple("Remaining time - execute: " + localTime);
        }
    }
}

