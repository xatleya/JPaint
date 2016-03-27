package Controler;

import Modele.MyShape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelectDrawPanelListener implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("yay");
        MyShape myShape = (MyShape)me.getSource();
        for(MyShape current : myShape.getModele().getShapesTab()) {
            current.setSelected(false);
        }
        myShape.setSelected(true);
        myShape.getModele().getShapesTab().remove(myShape);
        myShape.getModele().getShapesTab().add(myShape);
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
