package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar{
    private ToolbarToolsPanel toolbarToolsPanel;
    private ToolbarColorChoserPanel toolbarColorChoserPanel;
    
    
    public Toolbar(MainFrame mainFrame) {
        super(null, JToolBar.VERTICAL);
        this.setPreferredSize(new Dimension(150,600));
        this.setRollover(true);
        this.setLayout(new BorderLayout(5,5));
        
        ToolbarToolsPanel toolbarButtonPanel = new ToolbarToolsPanel(mainFrame);
        this.toolbarToolsPanel = toolbarButtonPanel;
        this.add(toolbarButtonPanel, BorderLayout.NORTH);
        this.addSeparator(new Dimension(20,20));
        
        JPanel SouthToolbarPanel = new JPanel();
        SouthToolbarPanel.setLayout(new BorderLayout(5,5));
        SouthToolbarPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        ToolbarColorChoserPanel toolbarColorChoserPanel = new ToolbarColorChoserPanel();
        this.toolbarColorChoserPanel = toolbarColorChoserPanel;
        SouthToolbarPanel.add(toolbarColorChoserPanel, BorderLayout.NORTH);
        ToolbarToolChoserPanel toolbarToolChoserPanel = new ToolbarToolChoserPanel(this, mainFrame.getStatusPanel());
        SouthToolbarPanel.add(toolbarToolChoserPanel, BorderLayout.SOUTH);
        this.add(SouthToolbarPanel, BorderLayout.SOUTH);        
    } 

    public ToolbarToolsPanel getToolbarToolsPanel() {
        return toolbarToolsPanel;
    }

    public ToolbarColorChoserPanel getToolbarColorChoserPanel() {
        return toolbarColorChoserPanel;
    }
}
