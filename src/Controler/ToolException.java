package Controler;

public class ToolException extends Exception{
    public ToolException() {
        
    }

    @Override
    public String getMessage() {
        return new String("This class is not a Tool");
    }   
}
