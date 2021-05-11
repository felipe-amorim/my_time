package com.mytime.support.web.find.combobox;

import com.mytime.intern.Instances;
import com.mytime.support.commons.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class GetterComboBox {
    public int size(){
        final int[] size = {0};
        Instances.getExecuteClassInstance().execute(()->{
            Select combobox = new Select(Instances.getWebLastElements().get(0));
            List<WebElement> elementos = combobox.getOptions();
            size[0] = elementos.size();});
        Log.log(Instances.getMessageComboBoxGetSize() + Instances.getWebLastXpath());

        return size[0];
    }

    public List<List<String>> firstSelectedText(){
        List<List<String>> retorno = new ArrayList<>();
        Instances.getExecuteClassInstance().execute(()->{
            Select combobox = new Select(Instances.getWebLastElements().get(0));
            List<String> lis1 = new ArrayList<>();
            lis1.add(combobox.getFirstSelectedOption().getText());
            retorno.add(lis1);
            });
        Log.log(Instances.getMessageComboBoxGetSize() + Instances.getWebLastXpath());
        return retorno;
    }

    public List<WebElement> elements(){
        List<List<WebElement>> e = new ArrayList<>();
        Instances.getExecuteClassInstance().execute(()->{
            Select combobox = new Select(Instances.getWebLastElements().get(0));
            e.add(combobox.getOptions());
        });
        Log.log(Instances.getMessageComboBoxGetSize() + Instances.getWebLastXpath());
        return e.get(0);
    }
}
