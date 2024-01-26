package info.bytecraft.logger;

public class SimpleLogger extends AbstractLogger
{
    private final long startTime = System.currentTimeMillis();

    public SimpleLogger()
    {
        super();
    }
    
    @Override
    public void log(LogLevel level, String message)
    {
        StringBuilder builder = new StringBuilder(256);
        
        long time = System.currentTimeMillis() - startTime;
        long minutes = time / (1000 * 60L);
        long seconds = time / (1000) % 60;
        
        if (minutes <= 9) builder.append('0');
        builder.append(minutes);
        builder.append(':');
        if (seconds <= 9) builder.append('0');
        builder.append(seconds);
        
        builder.append(" " + level.name() + " ");

        builder.append("[" + getCategory() + "] ");
        
        builder.append(message);
        System.out.println(builder.toString());
    }
}
