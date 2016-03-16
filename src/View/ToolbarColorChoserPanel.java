package View;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolbarColorChoserPanel extends JPanel{
    public ToolbarColorChoserPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JButton backgroundColor = new JButton();
        backgroundColor.setPreferredSize(new Dimension(50,25));
        backgroundColor.setMinimumSize(backgroundColor.getPreferredSize());
        backgroundColor.setMaximumSize(backgroundColor.getPreferredSize());
        backgroundColor.setEnabled(false);
        backgroundColor.setBackground(Color.red);
        this.add(backgroundColor);
        
        
        JButton foregroundColor = new JButton();
        foregroundColor.setPreferredSize(new Dimension(50,25));
        foregroundColor.setMinimumSize(foregroundColor.getPreferredSize());
        foregroundColor.setMaximumSize(foregroundColor.getPreferredSize());
        foregroundColor.setEnabled(false);
        foregroundColor.setBackground(Color.blue);
        this.add(foregroundColor);
    }
    
}
