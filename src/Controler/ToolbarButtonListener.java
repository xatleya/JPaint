package Controler;

import Modele.MyShape;
import View.DrawPanel;
import View.StatusPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

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
            for(MyShape current : this.drawPanel.getModele().getShapesTab()) {
                JPanel panel = (JPanel)current;
                for(MouseListener ml : panel.getMouseListeners()) {
                    panel.removeMouseListener(ml);
                }
                for(MouseMotionListener mml : panel.getMouseMotionListeners()) {
                    panel.removeMouseMotionListener(mml);
                }
                current.setSelected(false);
            }
            
            this.drawPanel.getModele().notifyObserver();
            
            if(status == "Select") {
                for(MyShape current : this.drawPanel.getModele().getShapesTab()) {
                    JPanel panel = (JPanel)current;
                    Class classListener = Class.forName("Controler." + status + "DrawPanelListener");
                    panel.addMouseListener((MouseListener) classListener.newInstance());
                    panel.addMouseMotionListener((MouseMotionListener) classListener.newInstance());
                    //panel.addKeyListener((KeyListener) classListener.newInstance());
                }
            }
            else {
                Class classListener = Class.forName("Controler." + status + "DrawPanelListener");
                this.drawPanel.addMouseListener((MouseListener) classListener.newInstance());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ToolbarButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ToolbarButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ToolbarButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
