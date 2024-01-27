package info.bytecraft.logger;

import java.util.Date;
import java.text.*;

public class TimestampLogger extends AbstractLogger
{

    @Override
    public void log(LogLevel level, String message)
    {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm");
        
        StringBuilder builder = new StringBuilder(256);
        
        builder.append(df.format(date) + " ");
        
        builder.append(level.name());
        builder.append(" [").append(getCategory()).append("] ");
        builder.append(message);
        
        System.out.println(builder.toString());
    }

}
