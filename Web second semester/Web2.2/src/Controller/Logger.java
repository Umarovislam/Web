package Controller;

import org.apache.log4j.LogManager;

public class Logger {
    public static void info(String msg){
        LogManager.getLogger("info").info(msg);
    }
}
