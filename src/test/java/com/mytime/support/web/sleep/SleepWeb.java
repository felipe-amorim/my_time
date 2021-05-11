package com.mytime.support.web.sleep;

import com.mytime.intern.Instances;
import com.mytime.support.commons.Log;

public class SleepWeb {
    public void until(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setMaxTime(int max){
        Instances.setDefaultWaitMilis(max);
    }

    public void setDefaultTime(){
        Instances.setDefaultWaitMilisBackUp();
    }

    public void untilDisapear(String xpath){
        long localWait = Instances.getDefaultWaitMilis();
        Instances.setDefaultWaitMilis(0);
        while (true){
            Instances.setWebLastXpath(xpath);
            if(Instances.getWebLastElements().size()<=0){
                break;
            }
            until(100);
            localWait = localWait-100;
            if(localWait<=0){
                Log.logRed(new NullPointerException(Instances.getMessageWaitDisapearStillHasElement()));
                break;
            }
        }
        Instances.setDefaultWaitMilisBackUp();
        Log.log(Instances.getMessageWaitDisapear() + Instances.getWebLastXpathLog());
    }

    public void untilAppear(String xpath){
        long localWait = Instances.getDefaultWaitMilis();
        //Log.logPurple("localwait: "+ Instances.getDefaultWaitMilis());
        Instances.getScreenshotClassInstance().printBefore();
        Instances.setDefaultWaitMilis(0);
        while (true){
            Instances.setWebLastXpath(xpath, false);
            if(Instances.getWebLastElements().size()>0){
                break;
            }
            until(100);
            localWait = localWait-100;
            if(localWait<=0){
                Log.logRed(new NullPointerException(Instances.getMessageWaitAppearStillHasElement()));
                break;
            }
        }
        Instances.setDefaultWaitMilisBackUp();
        //Log.logPurple("localwaitup: "+ Instances.getDefaultWaitMilis());
        Instances.getScreenshotClassInstance().printAfter();
        Log.log(Instances.getMessageWaitAppear() + Instances.getWebLastXpathLog());
    }

}
