package Controler;

import Modele.MainModele;
import Modele.Oval;
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
        System.out.println("je dessine un oval");
    }

    @Override
    public void mousePressed(MouseEvent me) {
       this.xOrigin = me.getX();
       this.yOrigin = me.getY();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       DrawPanel drawPanel = (DrawPanel)me.getSource();
       Shape shape = new Ellipse2D.Float(this.xOrigin,this.yOrigin,me.getX()-this.xOrigin,me.getY()-this.yOrigin);
       Oval oval = new Oval(shape, Color.red, Color.BLUE);
       drawPanel.getModele().getShapesTab().add(oval);
       drawPanel.getModele().notifyObserver();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
}
