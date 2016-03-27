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
    private boolean selected = false;
    
    public MyShape(MainModele modele, Shape shapeForeground, Shape shapeBackground, Color foregroundColor, Color backgroundColor) {
        this.modele = modele;
        this.shapeForeground = shapeForeground;
        this.shapeBackground = shapeBackground;
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBounds((int)this.shapeBackground.getBounds2D().getX(), (int)this.shapeBackground.getBounds2D().getY(), (int)this.shapeBackground.getBounds2D().getWidth(), (int)this.shapeBackground.getBounds2D().getHeight());
        this.setBackground(new Color(0,0,0,0));
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
}
