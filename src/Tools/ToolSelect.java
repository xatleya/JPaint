package Tools;

import Controler.Tool;
import Modele.MyShape;
import View.MainFrame;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolSelect extends JButton implements ActionListener, MouseListener, MouseMotionListener, Tool{
    private MainFrame mainFrame;
    private String status;
    
    static int xFirstClick;
    static int yFirstClick;
    
    public ToolSelect(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        String toolType = this.getClass().getName();
        this.status = toolType.substring(10, toolType.length());
        
        this.setPreferredSize(new Dimension(150, 100));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        
        ImageIcon imageIcon = new ImageIcon("src/Ressource/icon1.png");
        Image image = imageIcon.getImage();
        Image newimg =image.getScaledInstance(150, 100,  java.awt.Image.SCALE_SMOOTH); 
        this.setIcon(new ImageIcon(newimg));
        
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.mainFrame.getStatusPanel().setStatus(status);
        this.mainFrame.getDrawPanel().removeListeners();
        this.mainFrame.getDrawPanel().getModele().notifyObserver();
        for(MyShape current : this.mainFrame.getDrawPanel().getModele().getShapesTab()) {
            JPanel panel = (JPanel)current;
            panel.addMouseListener(this);
            panel.addMouseMotionListener(this);
        }    
    }
    
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
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        this.mainFrame.getDrawPanel().getModele().notifyObserver();
        this.mainFrame.getDrawPanel().getModele().notifyObserver();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        this.mainFrame.getDrawPanel().getModele().notifyObserver();
        this.mainFrame.getDrawPanel().getModele().notifyObserver();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
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
        else if(myShape.getType().equalsIgnoreCase("Line_D") || myShape.getType().equalsIgnoreCase("Line_M")){
            Line2D temp = (Line2D) myShape.getShapeForeground();
            shapeBackground = null;
            Double diffx =Math.abs(temp.getX1()-temp.getX2())/2;
            Double diffy =Math.abs(temp.getY1()-temp.getY2())/2;
            Double x2=x+diffx;
            Double y2=y+diffy;
            //descendant
            if(myShape.getType().equalsIgnoreCase("Line_M")){
                shapeForeground = new Line2D.Double(x2-diffx,y2+diffy,x2+diffx,y2-diffy);
            }
            //montant
            else{
                shapeForeground = new Line2D.Double(x2-diffx,y2-diffy,x2+diffx,y2+diffy);
            }
        }
        else {
            shapeBackground = null;
            shapeForeground = null;
        }
        myShape.setShapeBackground(shapeBackground);
        myShape.setShapeForeground(shapeForeground);
        myShape.setSelected(false);
        myShape.getModele().notifyObserver();
        myShape.setSelected(true);
        myShape.getModele().notifyObserver();
        myShape.getModele().notifyObserver();
        myShape.getModele().notifyObserver();
        myShape.getModele().notifyObserver();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }
    
}
