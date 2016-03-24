package Controler;

import View.StatusPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolbarButtonListener implements ActionListener {
    private String status;
    private StatusPanel statusPanel;
    
    public ToolbarButtonListener(StatusPanel statusPanel, String status) {
        this.statusPanel = statusPanel;
        this.status = status;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.statusPanel.setStatus(status);
    }
    
}
