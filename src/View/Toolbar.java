package View;

import Modele.MainModele;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar{
    private ToolbarButtonPanel toolbarButtonPanel;
    private ToolbarColorChoserPanel toolbarColorChoserPanel;
    
    
    public Toolbar(StatusPanel statusPanel, DrawPanel drawPanel) {
        super(null, JToolBar.VERTICAL);
        this.setPreferredSize(new Dimension(150,600));
        this.setRollover(true);
        this.setLayout(new BorderLayout(5,5));
        
        ToolbarButtonPanel toolbarButtonPanel = new ToolbarButtonPanel(statusPanel, drawPanel);
        this.toolbarButtonPanel = toolbarButtonPanel;
        this.add(toolbarButtonPanel, BorderLayout.NORTH);
        this.addSeparator(new Dimension(20,20));
        
        ToolbarColorChoserPanel toolbarColorChoserPanel = new ToolbarColorChoserPanel();
        this.toolbarColorChoserPanel = toolbarColorChoserPanel;
        this.add(toolbarColorChoserPanel, BorderLayout.SOUTH);        
    } 

    public ToolbarButtonPanel getToolbarButtonPanel() {
        return toolbarButtonPanel;
    }

    public ToolbarColorChoserPanel getToolbarColorChoserPanel() {
        return toolbarColorChoserPanel;
    }
}
