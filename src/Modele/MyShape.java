package Modele;

import Controler.SelectDrawPanelListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MyShape extends JPanel{
    private MainModele modele;
    private Shape shapeBackground;
    private Shape shapeForeground;
    private Color foregroundColor;
    private Color backgroundColor;
    private String type;
    private boolean selected = false;
    
    private int xOrigin;
    private int yOrigin;
    
    public MyShape(MainModele modele, Shape shapeForeground, Shape shapeBackground, Color foregroundColor, Color backgroundColor, String type) {
        this.modele = modele;
        this.shapeForeground = shapeForeground;
        this.shapeBackground = shapeBackground;
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.type = type;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(new Color(0,0,0,0));
        this.xOrigin = (int)this.shapeForeground.getBounds2D().getX();
        this.yOrigin = (int)this.shapeForeground.getBounds2D().getY();
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }
    
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Shape getShapeBackground() {
        return shapeBackground;
    }

    public Shape getShapeForeground() {
        return shapeForeground;
    } 

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean isSelected) {
        this.selected = isSelected;
    }

    public MainModele getModele() {
        return modele;
    }

    public void setShapeBackground(Shape shapeBackground) {
        this.shapeBackground = shapeBackground;
    }

    public void setShapeForeground(Shape shapeForeground) {
        this.shapeForeground = shapeForeground;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getType() {
        return type;
    }

    public int getxOrigin() {
        return xOrigin;
    }

    public int getyOrigin() {
        return yOrigin;
    }

    public void setxOrigin(int xOrigin) {
        this.xOrigin = xOrigin;
    }

    public void setyOrigin(int yOrigin) {
        this.yOrigin = yOrigin;
    }
}
