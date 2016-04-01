package Controler;

import Modele.MyShape;
import View.DrawPanel;
import java.awt.Color;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

public class RectangleDrawPanelListener implements MouseListener{
    private int xOrigin;
    private int yOrigin;
    
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
