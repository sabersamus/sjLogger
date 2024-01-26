package info.bytecraft.logger;

public class Log
{
    private static AbstractLogger logger = new SimpleLogger();
    
    private static LogLevel logLevel = LogLevel.INFO;
    
    public static void setLogger(AbstractLogger logger) {
        Log.logger = logger;
    }
    
    public static AbstractLogger getLogger()
    {
        return logger;
    }
    
    public static void info(String message) 
    {
        logger.log(LogLevel.INFO, message);
    }
    
    public static void warn(String message) 
    {
        logger.log(LogLevel.WARNING, message);
    }
    
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
