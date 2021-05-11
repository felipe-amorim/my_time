package com.mytime.support.commons;

import com.mytime.intern.Instances;
import org.json.JSONObject;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

public class Log {

    public void setLocator(LinkedHashMap<String, String> locator) {
        Instances.setLocator(locator);
    }

    public void updateLocator(LinkedHashMap<String, String> locator, String previousKey, String newKey) {
        String value = locator.get(previousKey);
        locator.put(newKey, value);
        Instances.setLocator(locator);
    }

    private static String logFilePath = "";

    public static void logRedNoPrintStack(Throwable arg0) {
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        logPrintOnly(ANSI_RED + "[ERROR] " + arg0 + ANSI_RESET);
        Instances.actionFail(arg0);
        file("[ERROR] " +arg0);
    }

    public static void logRed(Throwable arg0) {
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        logPrintOnly(ANSI_RED + "[ERROR] " + arg0 + ANSI_RESET);
        Instances.actionFail(arg0);
        file("[ERROR] " +arg0);
        arg0.printStackTrace();
    }

    public static void logRed(String arg0) {
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        logPrintOnly(ANSI_RED + "[ERROR] " + arg0 + ANSI_RESET);
        Instances.actionFail(arg0);
        file("[ERROR] " +arg0);
        throw new NullPointerException(arg0);
    }

    public static void logYellow(String arg0) {
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RESET = "\u001B[0m";
        logPrintOnly(ANSI_YELLOW + "[WARNING] "+ arg0 + ANSI_RESET);
        Instances.actionWarning(arg0);
        file("[WARNING] "+arg0);
    }

    public static void logPurple(Throwable arg0) {
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_RESET = "\u001B[0m";
        logPrintOnly(ANSI_PURPLE + "[INFO] "+ arg0 + ANSI_RESET);
        file("[INFO] "+arg0);
    }

    public static void logPurple(String arg0) {
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_RESET = "\u001B[0m";
        logPrintOnly(ANSI_PURPLE + "[INFO] "+ arg0 + ANSI_RESET);
        file("[INFO] "+arg0);
    }

    public static void logCyan(String arg0) {
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_RESET = "\u001B[0m";
        logPrintOnly(ANSI_CYAN + arg0 + ANSI_RESET);
        file(arg0);
    }

    private static void logPrintOnly(String log){
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        System.out.println("["+df.format(today)+"] "+log);
    }

    public static void logGenericCodeBlock(String log){
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        file("["+df.format(today)+"] "+log);
        System.out.println("["+df.format(today)+"] "+log);
        Instances.actionGenericCodeBlock(log);
    }

    public static void logJson(JSONObject log){
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        file("["+df.format(today)+"] "+log);
        System.out.println("["+df.format(today)+"] "+log);
        Instances.actionJsonCodeBlock(String.valueOf(log));
    }

    public static void log(String log){
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        file("["+df.format(today)+"] "+log);
        System.out.println("["+df.format(today)+"] "+log);
        Instances.actionPass(log);
    }

    public static void file(String log){
        File logDir = new File(System.getProperty("user.dir")+"/src/test/resources/logs/");
        if(!logDir.exists()){
            logDir.mkdirs();
        }

        if(logFilePath.length()==0){
            DateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
            Date today = Calendar.getInstance().getTime();
            logFilePath = System.getProperty("user.dir")+"/src/test/resources/logs/"+df.format(today)+".log";
        }

        File logFile = new File(logFilePath);
        try {
            FileWriter fr = new FileWriter(logFile, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);

            pr.println(log);
            pr.close();
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
