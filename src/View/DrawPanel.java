package View;
import Observe.Observer;
import java.awt.Color;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements Observer{
    public DrawPanel() {
        this.setBackground(Color.white);
    }

    @Override
    public void update() {
        
    }
}
