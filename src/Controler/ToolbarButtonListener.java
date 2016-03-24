package Controler;

import View.DrawPanel;
import View.StatusPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToolbarButtonListener implements ActionListener {
    private String status;
    private StatusPanel statusPanel;
    private DrawPanel drawPanel;
    
    public ToolbarButtonListener(StatusPanel statusPanel, String status, DrawPanel drawPanel) {
        this.statusPanel = statusPanel;
        this.status = status;
        this.drawPanel = drawPanel;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.statusPanel.setStatus(status);
        for(MouseListener current : this.drawPanel.getMouseListeners()) {
            this.drawPanel.removeMouseListener(current);
        }
        try {
            Class classListener = Class.forName("Controler." + status + "DrawPanelListener");
            this.drawPanel.addMouseListener((MouseListener) classListener.newInstance());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ToolbarButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ToolbarButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ToolbarButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
