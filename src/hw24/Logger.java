package hw24;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance;
    private List<String> logs = new ArrayList<>();

    private Logger() {}

    public static Logger getInstance(){
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }
    public void log(String msg){
        logs.add("LOG: " + msg);
        System.out.println("LOG: " + msg);
    }

    public void getAllLogs() {
        System.out.println("\nPrinting all logs");
        for (String log : logs){
            System.out.println(log);
        }
    }
}
