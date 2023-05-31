package Utils;

import org.apache.log4j.Logger;
import org.apache.commons.math3.analysis.function.Log;


public class Logs {

    public static Logger log = Logger.getLogger(Log.class.getName());

    //When the test starts, I shout print the logs
    //When my tests stops, I should print the logs
    //If I want to print any message in between, I should print the logs

    public static void startTestCase(String testCaseName){
        log.info("*****************************");
        log.info("*****************************");
        log.info("************"+ testCaseName + "*****************");
    }

    public static void endTestCase(String testCaseName){

        log.info("################################");
        log.info("################################");
        log.info("###########"+ testCaseName +"#####################");

    }

    public static void info(String message){

        log.info(message);
    }

    public static void warning(String message){

    }
}
