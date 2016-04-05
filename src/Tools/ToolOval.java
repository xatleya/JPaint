package Tools;

import Controler.ToolbarButtonListener;
import Modele.MyShape;
import View.DrawPanel;
import View.DrawPanel;
import View.StatusPanel;
import View.StatusPanel;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolOval extends JButton implements Tool, ActionListener{
    private StatusPanel statusPanel;
    private DrawPanel drawPanel;
    private String status;
    
    public ToolOval(StatusPanel statusPanel, DrawPanel drawPanel) {
        this.statusPanel = statusPanel;
        this.drawPanel = drawPanel;
        String toolType = this.getClass().getName();
        this.status = toolType.substring(10, toolType.length());
        
        this.setPreferredSize(new Dimension(150, 100));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        
        ImageIcon imageIcon = new ImageIcon("src/Ressource/icon3.png");
        Image image = imageIcon.getImage();
        Image newimg =image.getScaledInstance(150, 100,  java.awt.Image.SCALE_SMOOTH); 
        this.setIcon(new ImageIcon(newimg));
        
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.statusPanel.setStatus(this.status);
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
