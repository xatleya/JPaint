package View;

import Controler.ButtonListenerRemoveTool;
import Controler.ButtonListenerToolChoser;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolbarToolChoserPanel extends JPanel{ //panel d'ajout / suppression de tools
    
    public ToolbarToolChoserPanel (Toolbar toolbar, StatusPanel statusPanel) {
        this.setBorder(BorderFactory.createLineBorder(Color.black)); 
        
        JButton addToolButton = new JButton("+");   //boutton ajout
        addToolButton.setPreferredSize(new Dimension(50,25));
        addToolButton.setMinimumSize(addToolButton.getPreferredSize());
        addToolButton.setMaximumSize(addToolButton.getPreferredSize());
        addToolButton.addActionListener(new ButtonListenerToolChoser(toolbar));
        this.add(addToolButton);
        
        JButton removeToolButton = new JButton("-");    //boutton suppression
        removeToolButton.setPreferredSize(new Dimension(50,25));
        removeToolButton.setMinimumSize(removeToolButton.getPreferredSize());
        removeToolButton.setMaximumSize(removeToolButton.getPreferredSize());
        removeToolButton.addActionListener(new ButtonListenerRemoveTool(toolbar, statusPanel));
        this.add(removeToolButton);
    }
    
}
