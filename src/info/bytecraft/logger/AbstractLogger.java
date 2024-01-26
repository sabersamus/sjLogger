package info.bytecraft.logger;

public abstract class AbstractLogger
{
    
    private String category;
    
    public AbstractLogger() 
    {
        this("Logger");
    }
    
    public AbstractLogger(String category)
    {
        this.setCategory(category);
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }
    
    
    public abstract void log(LogLevel level, String message);
    
}
