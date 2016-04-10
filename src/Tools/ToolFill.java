package Tools;

import Controler.FillDrawPanelListener;
import Modele.MyShape;
import View.MainFrame;
import View.ToolbarColorChoserPanel;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolFill extends JButton implements ActionListener, MouseListener{
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
            ToolbarColorChoserPanel toolbarColorChoserPanel = this.mainFrame.getDrawPanel().getMainFrame().getToolbar().getToolbarColorChoserPanel();
            panel.addMouseListener(new FillDrawPanelListener(toolbarColorChoserPanel));
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
