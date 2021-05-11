package com.mytime.intern;

import com.mytime.support.commons.Log;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LocatorWeb {
    List<WebElement> elements = new ArrayList<>();
    int localTime = 0;
    String input = "";
    int logInterval = 5000;
    int logIntervalDefault = 5000;

    public void locate(String input) {
        this.input = input;

        paintPreviousElementsAsOrange();

        elements = new ArrayList<>();
        locateElement();
        if(elements.size()<=0){
            localTime = Instances.getDefaultWaitMilis();
            while (true) {
                long ti = Calendar.getInstance().getTimeInMillis();
                locateElement();
                if (elements.size() > 0) {
                    break;
                }
                checkTimeLeft(ti);
                if (localTime <= 0) {
                    break;
                }
            }
        }


        int count = elements.size();
        if(Instances.getPrintLog()){
            if (count > 1) {
                Log.logPurple("The xpath '" + input + "' returned " + count + " elements");
            } else if (count == 1) {
                Log.logPurple("The xpath '" + input + "' returned one element");
            } else {
                String msg = "The xpath '" + input + "' returned no elements";
                Instances.setWebLastLocatorResult(msg);
                Log.logPurple(msg);
            }
        }


        Instances.setWebLastElements(elements);

        if(count>0){
            paintCurrentElementsRed();
        }
    }

    private void paintCurrentElementsRed(){
        JavascriptExecutor js = (JavascriptExecutor) Instances.getWebDriver();
        for (WebElement element : elements) {
            js.executeScript("arguments[0].style.border='3px solid red'", element);
        }
    }

    private void paintPreviousElementsAsOrange() {
        JavascriptExecutor js = (JavascriptExecutor) Instances.getWebDriver();
        if (Instances.getWebLastElements() != null) {
            try {
                for (WebElement element : Instances.getWebLastElements()) {
                    js.executeScript("arguments[0].style.border='1px solid orange'", element);
                }
            } catch (WebDriverException e) {
                Log.logPurple("exception painting element as orange ");
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
            Log.logPurple("Remaining time - locator web: " + localTime);
        }
    }

    private void locateElement() {
        elements = new ArrayList<>();
        try {
            if (input.startsWith("/") || input.startsWith("(")) {
                elements = Instances.getWebDriver().findElements(By.xpath(input));
            } else {
                elements = Instances.getWebDriver().findElements(By.id(input));
            }
        } catch (IllegalArgumentException e1) {
            Instances.getWebDriver().switchTo().alert();
        } catch (NoAlertPresentException ignored) {
        }
    }
}
