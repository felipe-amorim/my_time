package com.mytime.support.commons;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class Commons {

    public static String getProjectFolder(){
        return System.getProperty("user.dir")+"/";
    }

    public static String getUsersFolder(){
        return System.getProperty("user.home")+"/";
    }

    public static String getDownloadsFolder(){
        return getUsersFolder()+"Downloads/";
    }

    public static String getProjectDownloadsFolder(){
        return System.getProperty("user.dir") + "/src/test/resources/downloads/";
    }

    public static void resetDownloadsFolder(){
        File path = new File(Commons.getProjectDownloadsFolder());

        try {
            FileUtils.deleteDirectory(path);
        } catch (IOException ignored) {

        }

        if(path.mkdirs()){
            Log.logPurple("criou downloads");
        }else {
            Log.logPurple("xabu ao criar downloads");
        }
    }

    public static String readFile(String filePath){
        String retorno = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line).append("\n");
                line = br.readLine();
            }
            retorno = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public static String executeCmd(String command) {
        Process proc = null;
        StringBuilder retorno = new StringBuilder();
        try {
            Log.log("Executing the command '"+command+"'");
            proc = Runtime.getRuntime().exec(new String[] {"/bin/bash", "-c", command});
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String line = "";
            while((line = reader.readLine()) != null) {
                retorno.append(line).append("\n");
            }

            proc.waitFor();
            Log.log("Command output:");
            Log.logGenericCodeBlock(retorno.toString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return retorno.toString();
    }
}
