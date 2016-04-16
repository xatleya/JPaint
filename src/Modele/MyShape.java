package Modele;

import java.awt.Color;
import java.awt.Shape;
import javax.swing.JPanel;

public class MyShape extends JPanel{    //une shape de notre JPaint (il s'agit d'un JPanel)
    private MainModele modele;
    private Shape shapeBackground;      //correspond au contour de la shape 
    private Shape shapeForeground;      //l'interieur de la shape
    private Color foregroundColor;      //couleur de l'interieur
    private Color backgroundColor;      //couleur du contour
    private String type;                //pour savoir de quel type est notre shape (ellipse, rectangle, line,...)
    private boolean selected = false;   //savoir si notre shape est sélectionnée
    
    private int xOrigin;    //position en x du JPanel associé à notre shape
    private int yOrigin;    //position en y du JPanel associé à notre shape
    
    //contructeur de MyShape
    public MyShape(MainModele modele, Shape shapeForeground, Shape shapeBackground, Color foregroundColor, Color backgroundColor, String type) { 
        this.modele = modele;
        this.shapeForeground = shapeForeground;
        this.shapeBackground = shapeBackground;
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.type = type;
        this.setBackground(new Color(0,0,0,0));
        this.xOrigin = (int)this.shapeForeground.getBounds2D().getX();  //le JPanel associé à la shape aura la même position
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
