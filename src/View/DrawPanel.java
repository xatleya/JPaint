package View;
import Controler.SelectDrawPanelListener;
import Modele.MainModele;
import Modele.MyShape;
import Observe.Observer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class DrawPanel extends JPanel implements Observer{
    private MainModele modele;
    private MainFrame mainFrame;
    
    public DrawPanel(MainModele modele, MainFrame mainFrame) {
        this.modele = modele;
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.addMouseListener(new SelectDrawPanelListener());  //par default mode select
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        for(MyShape current : this.modele.getShapesTab()) {
            g2d.setPaint(current.getBackgroundColor());
            g2d.fill(current.getShapeBackground());          
            g2d.draw(current.getShapeBackground());
            
            g2d.setPaint(current.getForegroundColor());
            g2d.fill(current.getShapeForeground());
            g2d.draw(current.getShapeForeground());
        }
    }

    public MainModele getModele() {
        return modele;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    @Override
    public void update() {
        this.repaint();
    }
}
