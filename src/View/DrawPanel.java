package View;
import Controler.SelectDrawPanelListener;
import Modele.MainModele;
import Modele.MyShape;
import Observe.Observer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
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
        //this.addMouseListener(new SelectDrawPanelListener());  //par default mode select
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        
        //ajout des panels de nos shapes
        int i = this.modele.getShapesTab().size()-1;
        while(i!=-1) {
            MyShape current = this.modele.getShapesTab().get(i);
            if(current.getType().equals("Ellipse") || current.getType().equals("Rectangle")) {
                if(current.isSelected()) {
                    current.setLocation(new Point(current.getxOrigin(), current.getyOrigin()));
                }
                else {
                    this.remove(current);
                    //current.setBorder(null);
                    current.setBounds(current.getxOrigin(), current.getyOrigin(), (int)current.getShapeForeground().getBounds2D().getWidth(), (int)current.getShapeForeground().getBounds2D().getHeight());
                    this.add(current);
                }
            }
            i--;
        }
        
        i=this.modele.getShapesTab().size()-1;
        while(i!=-1) {
            MyShape current = this.modele.getShapesTab().get(i);
            if(current.getType().equals("Line")) {
                if(current.isSelected()) {
                    current.setLocation(new Point(current.getxOrigin(), current.getyOrigin()));
                }
                else {
                    //current.setBorder(null);
                    current.setBounds(current.getxOrigin(), current.getyOrigin(), (int)current.getShapeForeground().getBounds2D().getWidth(), (int)current.getShapeForeground().getBounds2D().getHeight());
                    this.add(current);
                }
            }
            i--;
        }
        
        //ajout de nos shapes
        for(MyShape current : this.modele.getShapesTab()) {
            if(current.getShapeBackground() != null) {
                g2d.setPaint(current.getBackgroundColor());
                g2d.fill(current.getShapeBackground()); 
                g2d.draw(current.getShapeBackground());
            }
            
            if(current.isSelected()) {
                Color selectedColor = current.getForegroundColor();
                selectedColor = selectedColor.brighter();
                g2d.setPaint(current.getForegroundColor().darker());
            }
            else {
                g2d.setPaint(current.getForegroundColor());
            }
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
        this.revalidate();
        this.repaint();
    }
}
