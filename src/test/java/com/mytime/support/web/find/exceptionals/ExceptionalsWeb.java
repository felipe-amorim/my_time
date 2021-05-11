package com.mytime.support.web.find.exceptionals;

import com.mytime.intern.Instances;


public class ExceptionalsWeb {
    public PopUps popUp(){
        return Instances.getPopUpsClassInstance();
    }

    public FramesWeb frame(){
        return Instances.getFramesWebClassInstance();
    }
}
