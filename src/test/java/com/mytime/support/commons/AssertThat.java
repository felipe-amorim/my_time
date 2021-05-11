package com.mytime.support.commons;

import com.mytime.intern.Instances;

public class AssertThat {

    public boolean isNotEqualTo(String text){
        if(Instances.getSoftAssert()){
            text = text.toLowerCase();
            Instances.setAssertionText(Instances.getAssertionText().toLowerCase());
        }
        if(!Instances.getAssertionText().equals(text)){
            Log.log(Instances.getMessageAssertFailEquals().replace("arg0", Instances.getAssertionText()).replace("arg1", text));
            softly(false);
            return false;
        }
        Log.logYellow(Instances.getMessageAssertEquals().replace("arg0", Instances.getAssertionText()).replace("arg1", text));
        softly(false);
        return true;
    }

    public boolean isHigherThan(int second){
        int first = Integer.parseInt(Instances.getAssertionText());
        if(first<=second){
            Log.logYellow(Instances.getMessageAssertFailHigherThan().replace("arg0", Instances.getAssertionText()).replace("arg1", String.valueOf(second)));
            softly(false);
            return false;
        }
        Log.log(Instances.getMessageAssertHigherThan().replace("arg0", Instances.getAssertionText()).replace("arg1", String.valueOf(second)));
        softly(false);
        Instances.setAtLeastOneAssert(true);
        return true;
    }

    public boolean isLowerThan(int second){
        int first = Integer.parseInt(Instances.getAssertionText());
        if(first<=second){
            Log.logYellow(Instances.getMessageAssertFailLowerThan().replace("arg0", Instances.getAssertionText()).replace("arg1", String.valueOf(second)));
            return false;
        }
        Log.log(Instances.getMessageAssertLowerThan().replace("arg0", Instances.getAssertionText()).replace("arg1", String.valueOf(second)));
        return true;
    }

    public boolean isEqualTo(String text){
        if(Instances.getSoftAssert()){
            text = text.toLowerCase();
            Instances.setAssertionText(Instances.getAssertionText().toLowerCase());
        }
        if(!Instances.getAssertionText().equals(text)){
            Log.logYellow(Instances.getMessageAssertFailEquals().replace("arg0", Instances.getAssertionText()).replace("arg1", text));
            return false;
        }
        Log.log(Instances.getMessageAssertEquals().replace("arg0", Instances.getAssertionText()).replace("arg1", text));
        return true;
    }

    public boolean notContains(String text){
        if(Instances.getSoftAssert()){
            text = text.toLowerCase();
            Instances.setAssertionText(Instances.getAssertionText().toLowerCase());
        }
        if(!Instances.getAssertionText().contains(text)){
            Log.log(Instances.getMessageAssertNotContains().replace("arg0", Instances.getAssertionText()).replace("arg1", text));
            return true;
        }
        Log.logYellow(Instances.getMessageAssertFailNotContains().replace("arg0", Instances.getAssertionText()).replace("arg1", text));
        return false;
    }

    public boolean contains(String text){
        if(Instances.getSoftAssert()){
            text = text.toLowerCase();
            Instances.setAssertionText(Instances.getAssertionText().toLowerCase());
        }
        if(!Instances.getAssertionText().contains(text)){
            Log.logYellow(Instances.getMessageAssertFailContains().replace("arg0", Instances.getAssertionText()).replace("arg1", text));
            return false;
        }
        Log.log(Instances.getMessageAssertContains().replace("arg0", Instances.getAssertionText()).replace("arg1", text));
        return true;
    }

    public boolean startsWith(String text){
        if(Instances.getSoftAssert()){
            text = text.toLowerCase();
            Instances.setAssertionText(Instances.getAssertionText().toLowerCase());
        }
        if(!Instances.getAssertionText().startsWith(text)){
            Log.logYellow(Instances.getMessageAssertFailStartsWith().replace("arg0", Instances.getAssertionText()).replace("arg1", text));
            return false;
        }
        Log.log(Instances.getMessageAssertStartsWith().replace("arg0", Instances.getAssertionText()).replace("arg1", text));
        return true;
    }

    public boolean endsWith(String text){
        if(Instances.getSoftAssert()){
            text = text.toLowerCase();
            Instances.setAssertionText(Instances.getAssertionText().toLowerCase());
        }
        if(!Instances.getAssertionText().endsWith(text)){
            Log.logYellow(Instances.getMessageAssertFailEndsWith().replace("arg0", Instances.getAssertionText()).replace("arg1", text));
            return false;
        }
        Log.log(Instances.getMessageAssertEndsWith().replace("arg0", Instances.getAssertionText()).replace("arg1", text));
        return true;
    }

    public AssertThat softly(boolean status){
        Instances.setSoftAssert(status);
        return this;
    }
}
