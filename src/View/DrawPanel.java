package View;
import Observe.Observer;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements Observer{
    String typeButton = new String("SELECT");
    
    public DrawPanel() {
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public void update() {
        
    }

    public void setTypeButton(String typeButton) {
        this.typeButton = typeButton;
    }

    public String getTypeButton() {
        return typeButton;
    }
}
