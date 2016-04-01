package Controler;

import Modele.MyShape;
import View.ToolbarColorChoserPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FillDrawPanelListener implements MouseListener{
    private ToolbarColorChoserPanel toolbarColorChoserPanel;
    
    public FillDrawPanelListener(ToolbarColorChoserPanel toolbarColorChoserPanel) {
        this.toolbarColorChoserPanel = toolbarColorChoserPanel;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        MyShape myShape = (MyShape)me.getSource();
        Color newBackgroundColor = this.toolbarColorChoserPanel.getBackgroundButton().getBackground();
        myShape.setBackgroundColor(newBackgroundColor);
        Color newForegroundColor = this.toolbarColorChoserPanel.getForegroundButton().getBackground();
        myShape.setForegroundColor(newForegroundColor);
        myShape.getModele().notifyObserver();
    }

    @Override
    public void mousePressed(MouseEvent me) {
       
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
}
