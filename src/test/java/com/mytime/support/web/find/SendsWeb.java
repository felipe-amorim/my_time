package com.mytime.support.web.find;

import com.mytime.intern.Instances;
import com.mytime.support.commons.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class SendsWeb {

    public SendsWeb pageDown(){
        fire(Keys.PAGE_DOWN, "PADE_DOWN");
        return this;
    }

    public SendsWeb space(){
        fire(Keys.SPACE, "SPACE");
        return this;
    }


    public SendsWeb arrowDown(){
        fire(Keys.ARROW_DOWN, "ARROW_DOWN");
        return this;
    }

    public SendsWeb esc(){
        fire(Keys.ESCAPE, "ESCAPE");
        return this;
    }

    public SendsWeb enter(){
        fire(Keys.ENTER, "ENTER");
        return this;
    }

    public SendsWeb tabEnter(){
        fire(Keys.TAB, Keys.ENTER, "TAB+ENTER");
        return this;
    }

    public SendsWeb tab(){
        fire(Keys.TAB, "TAB");
        return this;
    }

    public SendsWeb delete(){
        fire(Keys.DELETE, "DELETE");
        return this;
    }

    public SendsWeb end(){
        fire(Keys.END, "END");
        return this;
    }

    public SendsWeb home(){
        fire(Keys.HOME, "HOME");
        return this;
    }

    public SendsWeb backspace(){
        fire(Keys.BACK_SPACE, "BACK_SPACE");
        return this;
    }

    public SendsWeb text(String text){
        fire(text);
        return this;
    }

    public SendsWeb setValueThroughJavaScript(String value){
        JavascriptExecutor jse = (JavascriptExecutor) Instances.getWebDriver();
        Instances.getExecuteClassInstance().execute(()-> {
            jse.executeScript("arguments[0].value='" + value + "';", Instances.getWebLastElements().get(0));
        });
        return this;
    }

    private void fire(Keys key1, Keys key2, String keyName){
        Instances.getExecuteClassInstance().execute(() -> {
            Instances.getWebLastElements().get(0).sendKeys(key1, key2);
        });
        Log.log(Instances.getMessageSend().replace("arg0", keyName) + Instances.getWebLastXpathLog());
    }

    private void fire(Keys key, String keyName){
        Instances.getExecuteClassInstance().execute(() -> {
            Instances.getWebLastElements().get(0).sendKeys(key);
        });
        Log.log(Instances.getMessageSend().replace("arg0", keyName) + Instances.getWebLastXpathLog());
    }

    private void fire(String text){
        Instances.getExecuteClassInstance().execute(() -> {
            Instances.getWebLastElements().get(0).sendKeys(text);
        });
        Log.log(Instances.getMessageSend().replace("arg0", text) + Instances.getWebLastXpathLog());
    }

}
