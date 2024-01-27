package info.bytecraft.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.*;
import java.util.Date;

/**
 * A logger that uses a file to log into.
 */
public class FileLogger extends AbstractLogger
{
    private DateFormat fileFormat = new SimpleDateFormat("MM-dd-yyyy");
    private DateFormat timeStamp = new SimpleDateFormat("HH:mm:ss");
    private File file;
    
    /**
     * Creates the default FileLogger.
     * This uses the default file which is a datestamp.log file found in the runtime/logs folder
     */
    public FileLogger()
    {
        super("Logger");
        File folder = new File(System.getProperty("user.dir"), "/logs");
        if(!folder.exists()) {
            folder.mkdirs();
        }
        file = new File(folder, fileFormat.format(new Date()) + ".log");
    }
    
    /**
     * Creates a default FileLogger with the specified file
     * @param file - The file to log to
     */
    public FileLogger(File file) 
    {
        this(file, "Logger");
    }
    
    /**
     * Creates a FileLogger with the specified file and category
     * @param file
     * @param category
     */
    public FileLogger(File file, String category)
    {
        super(category);
        this.file  = file;
    }
    

    @Override
    public void log(LogLevel level, String message)
    {
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                new SimpleLogger().log(LogLevel.WARNING, e.getMessage());
            }
        }
        
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            
            writer.append(timeStamp.format(new Date()));
            writer.append(" " + level.name());
            writer.append(" [" + getCategory() + "] ");
            writer.append(message + "\n");
            writer.close();
            
        } catch (IOException e) {
            new SimpleLogger().log(LogLevel.WARNING, e.getMessage());
        }
    }

}
