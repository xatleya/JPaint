package View;
import Controler.SelectDrawPanelListener;
import Modele.MainModele;
import Modele.MyShape;
import Observe.Observer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements Observer{
    private MainModele modele;
    
    public DrawPanel(MainModele modele) {
        this.modele = modele;
        this.setLayout(null);
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.addMouseListener(new SelectDrawPanelListener());  //par default mode select
        //this.modele.getShapesTab().add(new Rectangle2D.Float(100,100,100,100));
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        for(MyShape current : this.modele.getShapesTab()) {
            g2d.setPaint(current.getForegroundColor());
            g2d.fill(current.getShape());
            g2d.draw(current.getShape());
        }
    }

    public MainModele getModele() {
        return modele;
    }

    @Override
    public void update() {
        this.repaint();
    }
}
