package Tools;

import Controler.ToolbarButtonListener;
import View.MainFrame;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolOval extends JButton implements ActionListener{
    private MainFrame mainFrame;
    private String status;
    
    
    
    public ToolOval(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
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
        this.mainFrame.getStatusPanel().setStatus(this.status);
        try {
            this.mainFrame.getDrawPanel().removeListeners();           
            this.mainFrame.getDrawPanel().getModele().notifyObserver();
                     
            Class classListener = Class.forName("Controler." + status + "DrawPanelListener");
            this.mainFrame.getDrawPanel().addMouseListener((MouseListener) classListener.newInstance());
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ToolbarButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ToolbarButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ToolbarButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
