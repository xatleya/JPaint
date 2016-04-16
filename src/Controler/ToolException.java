package Controler;

public class ToolException extends Exception{   //exception pour savoir si un .class est un outil ou non
    public ToolException() {
        
    }

    @Override
    public String getMessage() {
        return new String("This class is not a Tool");
    }   
}
