package com.mytime.support.web.find;

import com.mytime.intern.Instances;
import org.openqa.selenium.WebElement;

public class GetterActionsWeb {

    public String text() {
        final String[] ret = {""};
        Instances.getExecuteClassInstance().execute(() -> {
            WebElement e = Instances.getWebLastElements().get(0);
            int waitingTimeBefore = Instances.getDefaultWaitMilis();
            ret[0] = e.getText();
            Instances.setDefaultWaitMilis(0);
            Instances.setWebLastXpath(Instances.getWebLastXpath() + "/*");
            if (Instances.getWebLastElements().size() > 0) {
                WebElement child = Instances.getWebLastElements().get(0);
                ret[0] = ret[0].replace(child.getText(), "");
            }
            Instances.setDefaultWaitMilis(waitingTimeBefore);
        });

        return ret[0].trim();
    }

    public String type() {
        return Instances.getWebLastElements().get(0).getTagName();
    }

    public String value() {
        return Instances.getWebLastElements().get(0).getAttribute("value");
    }

    public String attribute(String attribute) {
        return Instances.getWebLastElements().get(0).getAttribute(attribute);
    }


}
