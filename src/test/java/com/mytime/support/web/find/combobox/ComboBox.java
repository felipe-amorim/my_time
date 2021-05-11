package com.mytime.support.web.find.combobox;

import com.mytime.intern.Instances;

public class ComboBox {
    public SetterComboBox set(){
        return Instances.getSetterComboBoxClassInstance();
    }

    public GetterComboBox get(){
        return Instances.getGetterComboBoxClassInstance();
    }
}
