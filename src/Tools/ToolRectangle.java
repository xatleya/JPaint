package Tools;

import Controler.Tool;
import Modele.MyShape;
import View.DrawPanel;
import View.MainFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolRectangle extends JButton implements ActionListener, MouseListener, Tool{
    private MainFrame mainFrame;
    private String status;
    
    private int xOrigin;
    private int yOrigin;
    
    public ToolRectangle(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        String toolType = this.getClass().getName();
        this.status = toolType.substring(10, toolType.length());
        
        this.setPreferredSize(new Dimension(150, 100));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        
        ImageIcon imageIcon = new ImageIcon("src/Ressource/icon5.png");
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
       Shape shapeBackground;
       Shape shapeForeground;
       int xEnd = me.getX();
       int yEnd = me.getY();
       
       if(xEnd < this.xOrigin && yEnd < this.yOrigin) {
           shapeBackground = new Rectangle2D.Float(xEnd,yEnd,this.xOrigin-xEnd,this.yOrigin-yEnd);
           shapeForeground = new Rectangle2D.Float(xEnd+4,yEnd+4,this.xOrigin-xEnd-8,this.yOrigin-yEnd-8);
       }
       else if(yEnd < this.yOrigin) {
           shapeBackground = new Rectangle2D.Float(this.xOrigin,yEnd,xEnd-this.xOrigin,this.yOrigin-yEnd);
           shapeForeground = new Rectangle2D.Float(this.xOrigin+4,yEnd+4,xEnd-this.xOrigin-8,this.yOrigin-yEnd-8);
       }
       else if(xEnd < this.xOrigin) {
           shapeBackground = new Rectangle2D.Float(xEnd,this.yOrigin,this.xOrigin-xEnd,yEnd-this.yOrigin);
           shapeForeground = new Rectangle2D.Float(xEnd+4,this.yOrigin+4,this.xOrigin-xEnd-8,yEnd-this.yOrigin-8);
       }
       else{
           shapeBackground = new Rectangle2D.Float(this.xOrigin,this.yOrigin,me.getX()-this.xOrigin,me.getY()-this.yOrigin);
           shapeForeground = new Rectangle2D.Float(this.xOrigin+4,this.yOrigin+4,me.getX()-this.xOrigin-8,me.getY()-this.yOrigin-8);
       }
       Color backgroundColor = drawPanel.getMainFrame().getToolbar().getToolbarColorChoserPanel().getBackgroundButton().getBackground();
       Color foregroundColor = drawPanel.getMainFrame().getToolbar().getToolbarColorChoserPanel().getForegroundButton().getBackground();
       MyShape rectangle = new MyShape(drawPanel.getModele(), shapeForeground, shapeBackground, foregroundColor, backgroundColor, new String("Rectangle"));
       drawPanel.getModele().getShapesTab().add(rectangle);
       drawPanel.getModele().notifyObserver();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
