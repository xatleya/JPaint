package Tools;

import Controler.Tool;
import Modele.MyShape;
import View.MainFrame;
import View.ToolbarColorChoserPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolFill extends JButton implements ActionListener, MouseListener, Tool{
    private MainFrame mainFrame;
    private String status;
    
    public ToolFill(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        String toolType = this.getClass().getName();
        this.status = toolType.substring(10, toolType.length());
        
        this.setPreferredSize(new Dimension(150, 100));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        
        ImageIcon imageIcon = new ImageIcon("src/Ressource/icon2.png");
        Image image = imageIcon.getImage();
        Image newimg =image.getScaledInstance(150, 100,  java.awt.Image.SCALE_SMOOTH); 
        this.setIcon(new ImageIcon(newimg));
        
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.mainFrame.getStatusPanel().setStatus(status);
        this.mainFrame.getDrawPanel().removeListeners();
        this.mainFrame.getDrawPanel().getModele().notifyObserver();
        for(MyShape current : this.mainFrame.getDrawPanel().getModele().getShapesTab()) {
            JPanel panel = (JPanel)current;
            panel.addMouseListener(this);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        MyShape myShape = (MyShape)me.getSource();
        ToolbarColorChoserPanel toolbarColorChoserPanel = this.mainFrame.getToolbar().getToolbarColorChoserPanel();
        Color newBackgroundColor = toolbarColorChoserPanel.getBackgroundButton().getBackground();
        myShape.setBackgroundColor(newBackgroundColor);
        Color newForegroundColor = toolbarColorChoserPanel.getForegroundButton().getBackground();
        myShape.setForegroundColor(newForegroundColor);
        myShape.getModele().notifyObserver();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }  
}
