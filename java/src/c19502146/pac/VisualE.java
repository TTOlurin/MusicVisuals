package c19502146.pac;

public class VisualE extends Throwable
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private String message;
    
    public VisualE(String message)
    {
        this.message = message;
    }

    public String toString()
    {
        return message;
    }
}