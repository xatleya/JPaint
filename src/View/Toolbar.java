package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar{  //toolbar de l'application
    private ToolbarToolsPanel toolbarToolsPanel;    //partie de la toolbar contenant les tools
    private ToolbarColorChoserPanel toolbarColorChoserPanel;    //partie de la toolbar contenant le changement de couleur
    
    
    public Toolbar(MainFrame mainFrame) {
        super(null, JToolBar.VERTICAL);
        this.setPreferredSize(new Dimension(150,600));
        this.setRollover(true);
        this.setLayout(new BorderLayout(5,5));
        
        ToolbarToolsPanel toolbarButtonPanel = new ToolbarToolsPanel(mainFrame);    //crée la partie de la toolbar qui contient les tools
        this.toolbarToolsPanel = toolbarButtonPanel;
        this.add(toolbarButtonPanel, BorderLayout.NORTH);   //partie Nord
        this.addSeparator(new Dimension(20,20));    //on sépare cette partie de la partie sud
        
        JPanel SouthToolbarPanel = new JPanel();    //partie qui contient le changement de couleur et l'ajout / suppression de tools
        SouthToolbarPanel.setLayout(new BorderLayout(5,5));
        SouthToolbarPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        ToolbarColorChoserPanel toolbarColorChoserPanel = new ToolbarColorChoserPanel();
        this.toolbarColorChoserPanel = toolbarColorChoserPanel; //panel de changement de couleur
        SouthToolbarPanel.add(toolbarColorChoserPanel, BorderLayout.NORTH);
        ToolbarToolChoserPanel toolbarToolChoserPanel = new ToolbarToolChoserPanel(this, mainFrame.getStatusPanel());
        SouthToolbarPanel.add(toolbarToolChoserPanel, BorderLayout.SOUTH);  //panel d'ajout / suppression de tools
        this.add(SouthToolbarPanel, BorderLayout.SOUTH);        
    } 

    public ToolbarToolsPanel getToolbarToolsPanel() {
        return toolbarToolsPanel;
    }

    public ToolbarColorChoserPanel getToolbarColorChoserPanel() {
        return toolbarColorChoserPanel;
    }
}
