package View;
import Controler.SelectDrawPanelListener;
import Observe.Observer;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements Observer{
    public DrawPanel() {
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.addMouseListener(new SelectDrawPanelListener());  //par default mode select
    }

    @Override
    public void update() {
        
    }
}
