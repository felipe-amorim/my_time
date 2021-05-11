package com.mytime.intern.plugin;

import com.mytime.intern.Instances;
import com.mytime.support.commons.Log;
import cucumber.api.PickleStepTestStep;
import cucumber.api.event.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListCucumberExecute{

    private static boolean started = false;
    private static boolean firstStep = true;
    private static boolean thenTagOpened = false;


    public static void testCaseStarted(TestCaseStarted event){
        String scenarioName = getScenarioName(event);
        String featureName = getFeatureName(event);

        String author = getAuthorName(event);
        String category = getCategory(event);
        String device = getDeviceName(event);

        if(!started){
            started = true;
            Instances.removeReportFolder();
            Instances.createANewReport();
        }

        Log.logCyan(" _____ STARTING FEATURE: " + featureName + " ______________ ");

        if(Instances.itsANewFeature(featureName)){
            Instances.createANewFeature(featureName);
        }

        Instances.createANewScenario(scenarioName, author, new String[]{category}, device);

        Log.logCyan(" ===== STARTING TEST CASE: " + event.testCase.getName() + " ============== ");
    }

    public static void testStepStarted(TestStepStarted event) {
        try {
            PickleStepTestStep testStep = (PickleStepTestStep) event.testStep;
            String keyword = getStepKeyword(event);
            if(keyword.equals("Given: ") || keyword.equals("When: ")){
                thenTagOpened = false;
            }
            if(keyword.equals("When: ")){
                Instances.setAtLeastOneWhen(true);
            }else{
                if(keyword.equals("Then: ")){
                    Instances.setAtLeastOneThen(true);
                    thenTagOpened = true;
                }
            }
            Log.logCyan("Step: " + keyword + testStep.getStepText());
            Instances.createANewStep(keyword + testStep.getStepText());
            if(firstStep){
                if(!keyword.equals("Given: ")){
                    Log.logYellow("The first keyword should be 'Given'.");
                }
                firstStep = false;
            }
        } catch (Exception ignored) {
        }
    }

    public static void testStepFinished(TestStepFinished event){
        if(thenTagOpened && !Instances.getThenTagAssert()){
            Log.logYellow("Every keyword 'Then' and 'And' that comes afterwards, must have at least one assertion.");
        }
        Instances.setThenTagAssert(false);
    }

    public static void testCaseFinished(TestCaseFinished event){
        if(!Instances.getAtLeastOneAssert()){
            Log.logYellow("Every scenario must have at least one assertion.");
        }
        if(!Instances.getAtLeastOneWhen()){
            Log.logYellow("Every scenario must have at least one 'When' keyword.");
        }
        if(!Instances.getAtLeastOneThen()){
            Log.logYellow("Every scenario must have at least one 'Then' keyword.");
        }
        if(!Instances.getAtLeastOneEvidence() && !Instances.getDetailed()){
            Log.logYellow("Every scenario must have at least one evidence, or execute on detailed mode.");
        }
        Log.logCyan("===== FINISHING TEST CASE ("+event.result.getStatus()+"): " + event.testCase.getName() +" ==============");
        Instances.killAllDrivers();//todo voltar
        if (
            event.result.getStatus().toString().equals("FAILED")
            && !event.result.getErrorMessage().contains("[FAIL]")
            && !event.result.getErrorMessage().contains("[ALERT]")
            && !event.result.getErrorMessage().contains("[ENVIRONMENT]")
        ) {
            Log.logRedNoPrintStack(event.result.getError());
        }
    }
    
    public static void testRunFinished(TestRunFinished event){
        Instances.killEnvironment();
    }

    private static String getProductName(TestCaseStarted event){
        String path = event.testCase.getUri();
        String productName;
        if(path.contains("products/features/")){
            productName = path.split("products/features/")[1];
        }else {
            productName = path.split("products/")[1];
        }
        return productName.split("/")[0];
    }

    private static String getScenarioName(TestCaseStarted event){
        String[] partesScenarioTitle = event.testCase.getName().split("Author:");
        return partesScenarioTitle[0].replace(",", "");
    }

    private static String getAuthorName(TestCaseStarted event){
        String[] partesScenarioTitle = event.testCase.getName().split("Author:");
        String[] partesScenarioAuthorAndCategory = partesScenarioTitle[1].split("Category:");
        return partesScenarioAuthorAndCategory[0].replace(",", "").trim().replace(" ", "_");
    }

    private static String getCategory(TestCaseStarted event){
        String[] partesScenarioTitle = event.testCase.getName().split("Author:");
        String[] partesScenarioAuthorAndCategory = partesScenarioTitle[1].split("Category:");
        String[] partesScenarioCategoryAndEnvironment = partesScenarioAuthorAndCategory[1].split("Device:");
        return partesScenarioCategoryAndEnvironment[0].replace(",", "").trim().replace(" ", "_");
    }

    private static String getDeviceName(TestCaseStarted event){
        String[] partesScenarioTitle = event.testCase.getName().split("Author:");
        String[] partesScenarioAuthorAndCategory = partesScenarioTitle[1].split("Category:");
        String[] partesScenarioCategoryAndEnvironment = partesScenarioAuthorAndCategory[1].split("Device:");
        return partesScenarioCategoryAndEnvironment[1].replace(",", "").trim().replace(" ", "_");
    }

    private static String getFeatureName(TestCaseStarted event){
        String[] path = event.testCase.getUri().split("/");
        return path[path.length - 1].replace(".feature", "");
    }

    private static String getStepKeyword(TestStepStarted event){
        String keyword = "";
        int lineNumber = ((PickleStepTestStep) event.testStep).getStepLine() -1;
        String filePath = ((PickleStepTestStep) event.testStep).getStepLocation().replace("file:", "").split(":")[0];
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filePath));

            List<String> linesFeature = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                linesFeature.add(line);
                line = br.readLine();
            }
            for(int i = 0; i < linesFeature.size(); i++){
                if(i==lineNumber){
                    keyword = linesFeature.get(i).trim();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] keywordSplitBySpaces = keyword.split(" ");
        keyword = keywordSplitBySpaces[0];
        return keyword+": ";
    }
    
}
