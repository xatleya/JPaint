package View;
import Controler.ButtonListenerColorChoser;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolbarColorChoserPanel extends JPanel{    //panel du changement de couleur
    private JButton foregroundButton;   //couleur de l'intérieur de la figure
    private JButton backgroundButton;   //couleur de contour
    
    public ToolbarColorChoserPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));     
        
        JButton foregroundColor = new JButton();
        foregroundColor.setPreferredSize(new Dimension(50,25));
        foregroundColor.setMinimumSize(foregroundColor.getPreferredSize());
        foregroundColor.setMaximumSize(foregroundColor.getPreferredSize());
        foregroundColor.setBackground(Color.blue);  //par défault bleue
        foregroundColor.addActionListener(new ButtonListenerColorChoser());
        this.foregroundButton = foregroundColor;
        this.add(foregroundColor);
        
        JButton backgroundColor = new JButton();
        backgroundColor.setPreferredSize(new Dimension(50,25));
        backgroundColor.setMinimumSize(backgroundColor.getPreferredSize());
        backgroundColor.setMaximumSize(backgroundColor.getPreferredSize());
        backgroundColor.setBackground(Color.red);   //par défault rouge
        backgroundColor.addActionListener(new ButtonListenerColorChoser());
        this.backgroundButton = backgroundColor;
        this.add(backgroundColor);
    }

    public JButton getForegroundButton() {
        return foregroundButton;
    }
    
    public JButton getBackgroundButton() {
        return backgroundButton;
    }
}
