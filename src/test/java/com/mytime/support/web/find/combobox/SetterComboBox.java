package com.mytime.support.web.find.combobox;

import com.mytime.intern.Instances;
import com.mytime.support.commons.Log;
import org.openqa.selenium.support.ui.Select;

public class SetterComboBox {
    public void byText(String text){
        Instances.getExecuteClassInstance().execute(()->{
            Select combobox = new Select(Instances.getWebLastElements().get(0));
            combobox.selectByVisibleText(text);});
        Log.log(Instances.getMessageComboBoxText().replace("arg0", text) + Instances.getWebLastXpathLog());
    }

    public void byValue(String value){
        Instances.getExecuteClassInstance().execute(()->{
            Select combobox = new Select(Instances.getWebLastElements().get(0));
            combobox.selectByValue(value);});
        Instances.getScreenshotClassInstance().print();
        Log.log(Instances.getMessageComboBoxValue().replace("arg0", value) + Instances.getWebLastXpathLog());
    }

    public void byIndex(int index){
        Instances.getExecuteClassInstance().execute(()->{
            Select combobox = new Select(Instances.getWebLastElements().get(0));
            combobox.selectByIndex(index);});
        Instances.getScreenshotClassInstance().print();
        Log.log(Instances.getMessageComboBoxIndex().replace("arg0", String.valueOf(index)) + Instances.getWebLastXpathLog());
    }
}
