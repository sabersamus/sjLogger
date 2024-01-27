package info.bytecraft.logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * The master class for the sjLogger library
 * 
 * Log uses an instance of {@link SimpleLogger} by default.
 * @see {@link AbstractLogger}
 */
public class Log
{
    private Log() {}
    
    //Default logger
    private static AbstractLogger logger;
    
    //A map of loggers to use with logAll(String);
    private static Map<Integer, AbstractLogger> loggerList = new HashMap<Integer, AbstractLogger>();
    
    private static LogLevel logLevel = LogLevel.INFO;
    
    static {
        setDefaultLogger(new SimpleLogger());
    }
    
    /**
     * Set your own logger to use
     * @param logger
     */
    public static void setDefaultLogger(AbstractLogger logger) 
    {
        Log.logger = logger;
        Log.addLogger(logger);
    }
    
    
    public static AbstractLogger getDefaultLogger()
    {
        return logger;
    }
    
    public static void addLogger(AbstractLogger logger) 
    {
        if(!loggerList.containsValue(logger))
        loggerList.put(loggerList.size()+1, logger);
    }
    
    public static void removeLogger(AbstractLogger logger)
    {
        for(int i = 0; i < loggerList.size(); i++) {
            if(loggerList.get(i) == logger) {
                loggerList.remove(i);
            }
        }
    }
    
    public static Collection<AbstractLogger> getLoggers()
    {
        return loggerList.values();
    }
    
    /**
     * Logs a message with a {@link LogLevel} of INFO
     * Useful for general messages and use in production
     * @param message
     */
    public static void info(String message) 
    {
        logger.log(LogLevel.INFO, message);
    }
    
    /**
     * Logs an error message
     * @param message
     */
    public static void warn(String message) 
    {
        logger.log(LogLevel.WARNING, message);
    }
    
    /**
     * Logs a debugging message
     * @param message
     */
    public static void debug(String message) 
    {
        logger.log(LogLevel.DEBUG, message);
    }
    
    public static void severe(String message)
    {
        logger.log(LogLevel.SEVERE, message);
    }
    
    public static void log(LogLevel level, String message)
    {
        logger.log(level, message);
    }
    
    public static void setLogLevel(LogLevel level)
    {
        Log.logLevel = level;
    }
    
    public static LogLevel getLogLevel()
    {
        return Log.logLevel;
    }
}
