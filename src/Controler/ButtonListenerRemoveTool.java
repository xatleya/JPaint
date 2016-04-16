package Controler;

import View.StatusPanel;
import View.Toolbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListenerRemoveTool implements ActionListener{    //supprime un outil de la toolbar
    private Toolbar toolbar;
    private StatusPanel statusPanel;
    
    public ButtonListenerRemoveTool(Toolbar toolbar, StatusPanel statusPanel) {
        this.toolbar = toolbar;
        this.statusPanel = statusPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {   //si on clique sur -, on supprime l'outil et on met à jour le status
        String status = this.statusPanel.getStatus();
        this.toolbar.getToolbarToolsPanel().removeTool(status);
    }
    
}
