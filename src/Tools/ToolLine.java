package Tools;

import Modele.MyShape;
import View.DrawPanel;
import View.MainFrame;import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;;


public class ToolLine extends JButton implements ActionListener, MouseListener {
    private MainFrame mainFrame;
    private String status;
    
    private int xOrigin;
    private int yOrigin;
    
    public ToolLine(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        String toolType = this.getClass().getName();
        this.status = toolType.substring(10, toolType.length());
        
        this.setPreferredSize(new Dimension(150, 100));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        
        ImageIcon imageIcon = new ImageIcon("src/Ressource/icon4.png");
        Image image = imageIcon.getImage();
        Image newimg =image.getScaledInstance(150, 100,  java.awt.Image.SCALE_SMOOTH); 
        this.setIcon(new ImageIcon(newimg));
        
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.mainFrame.getStatusPanel().setStatus(this.status);
        this.mainFrame.getDrawPanel().removeListeners();
        this.mainFrame.getDrawPanel().getModele().notifyObserver();
        this.mainFrame.getDrawPanel().addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
       this.xOrigin = me.getX();
       this.yOrigin = me.getY();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       DrawPanel drawPanel = (DrawPanel)me.getSource();
       Shape shapeForeground = new Line2D.Float(this.xOrigin,this.yOrigin,me.getX(),me.getY());
       Color foregroundColor = drawPanel.getMainFrame().getToolbar().getToolbarColorChoserPanel().getForegroundButton().getBackground();
       MyShape line = new MyShape(drawPanel.getModele(), shapeForeground, null, foregroundColor, null, new String("Line"));
       drawPanel.getModele().getShapesTab().add(line);
       drawPanel.getModele().notifyObserver();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
}
