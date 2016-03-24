package Controler;

import Modele.MainModele;
import Modele.MyShape;
import View.DrawPanel;
import java.awt.Color;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

public class OvalDrawPanelListener implements MouseListener{
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
       Shape shapeBackground = new Ellipse2D.Float(this.xOrigin,this.yOrigin,me.getX()-this.xOrigin,me.getY()-this.yOrigin);
       Shape shapeForeground = new Ellipse2D.Float(this.xOrigin+2,this.yOrigin+2,me.getX()-this.xOrigin-4,me.getY()-this.yOrigin-4);
       Color backgroundColor = drawPanel.getMainFrame().getToolbar().getToolbarColorChoserPanel().getBackgroundButton().getBackground();
       Color foregroundColor = drawPanel.getMainFrame().getToolbar().getToolbarColorChoserPanel().getForegroundButton().getBackground();
       MyShape ellipse = new MyShape(shapeForeground, shapeBackground, foregroundColor, backgroundColor);
       drawPanel.getModele().getShapesTab().add(ellipse);
       drawPanel.getModele().notifyObserver();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
}
