package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar{
    public Toolbar() {
        super(null, JToolBar.VERTICAL);
        this.setPreferredSize(new Dimension(150,600));
        this.setRollover(true);
        this.setLayout(new BorderLayout(5,5));
        
        ToolbarButtonPanel toolbarButtonPanel = new ToolbarButtonPanel();
        this.add(toolbarButtonPanel, BorderLayout.NORTH);
        
        /*JSeparator separator = new Toolbar.Separator();
        separator.setOrientation(SwingConstants.VERTICAL);
        this.add(separator);*/
        this.addSeparator(new Dimension(20,20));
        
        ToolbarColorChoserPanel toolbarColorChoserPanel = new ToolbarColorChoserPanel();
        this.add(toolbarColorChoserPanel, BorderLayout.SOUTH);
        
    } 
}
