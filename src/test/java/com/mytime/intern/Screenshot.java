package com.mytime.intern;

import com.mytime.support.commons.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    private int filesCount = 1;

    private String cleanText(String text) {
        if (text != null) {
            text = text
                    .replace(".feature", "")
                    .replace("Scenario:", "")
                    .replaceAll(" ", "_")
                    .replaceAll("[^a-zA-Z0-9]", "")
                    .trim();
        } else {
            text = "";
        }
        return text;
    }

    public void printAfterForced(){
        printExecute("after", true);
    }

    public void printBefore(){
        printExecute("before", false);
    }

    public void printAfter(){
        printExecute("after", false);
    }

    public void printExecute(String action, boolean forced){
        if(Instances.getDetailed() || forced) {
            File screenshot;
            String scenarioName = cleanText(Instances.getScenarioName());
            String featureName = cleanText(Instances.getFeatureName());
            String stepName = cleanText(Instances.getStepName());
            String screenshotPath = Instances.getJenkinsEvidencesPath() + featureName + "/" + scenarioName + "/";

            screenshot = new File(screenshotPath + stepName + "_" + filesCount + ".png");
            try {
                if (!action.equals("after")) {
                    Instances.setScreenShotLocation("../evidencias/" + featureName + "/" + scenarioName + "/" + stepName + "_" + filesCount + ".png");
                } else {
                    Instances.setScreenShotLocationAfter("../evidencias/" + featureName + "/" + scenarioName + "/" + stepName + "_" + filesCount + ".png");
                }
                Log.logPurple("Screenshot count: " + stepName + "_" + filesCount + ".png");

                if (Instances.getWebDriver() != null && !Instances.getWebDriver().toString().contains("null") && (Instances.getLastTechnology().equals(Instances.Technology.WEB) || Instances.getLastTechnology().length() == 0)) {
                    FileUtils.moveFile(((TakesScreenshot) Instances.getWebDriver()).getScreenshotAs(OutputType.FILE), screenshot);
                }

                filesCount++;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (WebDriverException e) {
                Log.logYellow(e.getMessage());
            }
        }
    }

    public void print() {
        Log.logPurple("[DEPRECIATED]Old print call");
    }
}
