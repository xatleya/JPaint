package Controler;

import View.StatusPanel;
import View.Toolbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListenerRemoveTool implements ActionListener{
    private Toolbar toolbar;
    private StatusPanel statusPanel;
    
    public ButtonListenerRemoveTool(Toolbar toolbar, StatusPanel statusPanel) {
        this.toolbar = toolbar;
        this.statusPanel = statusPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String status = this.statusPanel.getStatus();
        this.toolbar.getToolbarToolsPanel().removeTool(status);
    }
    
}
