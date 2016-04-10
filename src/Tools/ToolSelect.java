package Tools;

import Controler.ToolbarButtonListener;
import Modele.MyShape;
import View.MainFrame;
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

public class ToolSelect extends JButton implements ActionListener{
    private MainFrame mainFrame;
    private String status;
    
    public ToolSelect(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        String toolType = this.getClass().getName();
        this.status = toolType.substring(10, toolType.length());
        
        this.setPreferredSize(new Dimension(150, 100));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        
        ImageIcon imageIcon = new ImageIcon("src/Ressource/icon1.png");
        Image image = imageIcon.getImage();
        Image newimg =image.getScaledInstance(150, 100,  java.awt.Image.SCALE_SMOOTH); 
        this.setIcon(new ImageIcon(newimg));
        
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.mainFrame.getStatusPanel().setStatus(status);
        try {
            this.mainFrame.getDrawPanel().removeListeners(); 
            this.mainFrame.getDrawPanel().getModele().notifyObserver();
            
            for(MyShape current : this.mainFrame.getDrawPanel().getModele().getShapesTab()) {
                JPanel panel = (JPanel)current;
                Class classListener = Class.forName("Controler." + status + "DrawPanelListener");
                panel.addMouseListener((MouseListener) classListener.newInstance());
                panel.addMouseMotionListener((MouseMotionListener) classListener.newInstance());
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
