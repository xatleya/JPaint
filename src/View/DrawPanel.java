package View;
import Observe.Observer;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements Observer{
    public DrawPanel() {
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public void update() {
        
    }
}
