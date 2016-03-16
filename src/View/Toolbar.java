package View;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar{
    public Toolbar() {
        super(null, JToolBar.VERTICAL);
        
        JButton selectButton = new JButton("select");
        this.add(selectButton);
        
        JSeparator separator = new Toolbar.Separator();
        separator.setOrientation(SwingConstants.VERTICAL);
        this.add(separator);
        
        JButton backgroundColor = new JButton();
        backgroundColor.setEnabled(false);
        backgroundColor.setBackground(Color.red);
        this.add(backgroundColor);
    } 
}
