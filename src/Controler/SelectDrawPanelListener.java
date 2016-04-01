package Controler;

import Modele.MyShape;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class SelectDrawPanelListener implements MouseListener, MouseMotionListener{
    static int xFirstClick;
    static int yFirstClick;

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        MyShape myShape = (MyShape)me.getSource();
        for(MyShape current : myShape.getModele().getShapesTab()) {
            current.setSelected(false);
        }
        myShape.setSelected(true);
        myShape.getModele().getShapesTab().remove(myShape);
        myShape.getModele().getShapesTab().add(myShape);
        myShape.getModele().notifyObserver();
        this.xFirstClick = me.getX();
        this.yFirstClick = me.getY();
        System.out.println("x = " + this.xFirstClick + " y = " + this.yFirstClick);
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

    @Override
    public void mouseDragged(MouseEvent me) {
        System.out.println("x = " + this.xFirstClick + " y = " + this.yFirstClick);
        MyShape myShape = (MyShape)me.getSource();
        int x = myShape.getxOrigin()-this.xFirstClick+me.getX();
        myShape.setxOrigin(x);
        int y = myShape.getyOrigin()-this.yFirstClick+me.getY();
        myShape.setyOrigin(y);
        
        Shape shapeBackground;
        Shape shapeForeground;
        if(myShape.getType().equals("Ellipse")) {
           shapeBackground = new Ellipse2D.Float(x,y,(int)myShape.getShapeBackground().getBounds2D().getWidth(),(int)myShape.getShapeBackground().getBounds2D().getHeight());
           shapeForeground = new Ellipse2D.Float(x+2,y+2,(int)myShape.getShapeBackground().getBounds2D().getWidth()-4,(int)myShape.getShapeBackground().getBounds2D().getHeight()-4);
        }
        else if(myShape.getType().equalsIgnoreCase("Rectangle")){
            shapeBackground = new Rectangle2D.Float(x,y,(int)myShape.getShapeBackground().getBounds2D().getWidth(),(int)myShape.getShapeBackground().getBounds2D().getHeight());
            shapeForeground = new Rectangle2D.Float(x+2,y+2,(int)myShape.getShapeBackground().getBounds2D().getWidth()-4,(int)myShape.getShapeBackground().getBounds2D().getHeight()-4);
        }
        else if(myShape.getType().equalsIgnoreCase("Line")){
            Line2D temp = (Line2D) myShape.getShapeForeground();
            shapeBackground = null;
            Double diffx =Math.abs(temp.getX1()-temp.getX2())/2;
            Double diffy =Math.abs(temp.getY1()-temp.getY2())/2;
            Double x2=x+diffx;
            Double y2=y+diffy;
            shapeForeground = new Line2D.Double(x2+diffx,y2+diffy,x2-diffx,y2-diffy);
        }
        else {
            shapeBackground = null;
            shapeForeground = null;
        }
        myShape.setShapeBackground(shapeBackground);
        myShape.setShapeForeground(shapeForeground);
        myShape.getModele().notifyObserver(); 
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }
}
