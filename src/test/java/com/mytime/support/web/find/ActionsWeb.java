package com.mytime.support.web.find;

import com.mytime.intern.Instances;
import com.mytime.support.commons.Log;
import com.mytime.support.web.find.combobox.ComboBox;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;

public class ActionsWeb {

    private void throwExceptionNoElement() {
        if (Instances.getWebLastElements().size() <= 0) {
            Log.logRed(new NoSuchElementException("The xpath " + Instances.getWebLastXpath() + " returned no elements"));
        }
    }

    public ClicksWeb click() {
        throwExceptionNoElement();

        Instances.getExecuteClassInstance().execute(() -> {
            Instances.getWebLastElements().get(0).click();
        });
        Log.log(Instances.getMessageClick() + Instances.getWebLastXpathLog());

        return Instances.getClicksClassInstance();
    }


    public boolean exists() {
        boolean exist = false;
        if (Instances.getWebLastElements().size() > 0) {
            exist = true;
        }
        Log.log(Instances.getMessageExists() + Instances.getWebLastXpathLog() + " ["+exist+"]");
        return exist;
    }

    public int count() {
        return Instances.getWebLastElements().size();
    }

    public SendsWeb send() {
        throwExceptionNoElement();
        return Instances.getSendsClassInstance();
    }

    public void clear() {
        throwExceptionNoElement();
        Instances.getExecuteClassInstance().execute(() -> {
            Instances.getWebLastElements().get(0).clear();
        });
        Log.log(Instances.getMessageClear() + Instances.getWebLastXpathLog());
    }

    public void move() {
        throwExceptionNoElement();
        Instances.getExecuteClassInstance().execute(() -> {
            Actions action = new Actions(Instances.getWebDriver());
            action.moveToElement(Instances.getWebLastElements().get(0)).perform();
        });
        Log.log(Instances.getMessageMove() + Instances.getWebLastXpathLog());
    }


    public ComboBox comboBox() {
        throwExceptionNoElement();
        return Instances.getComboBoxClassInstance();
    }

    public GetterActionsWeb get() {
        throwExceptionNoElement();
        return Instances.getFindGetterClassInstance();
    }

}
