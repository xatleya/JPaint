package View;
import Controler.ButtonListenerColorChoser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolbarColorChoserPanel extends JPanel{
    private JButton foregroundButton;
    private JButton backgroundButton;
    
    public ToolbarColorChoserPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));     
        
        JButton foregroundColor = new JButton();
        foregroundColor.setPreferredSize(new Dimension(50,25));
        foregroundColor.setMinimumSize(foregroundColor.getPreferredSize());
        foregroundColor.setMaximumSize(foregroundColor.getPreferredSize());
        foregroundColor.setBackground(Color.blue);
        foregroundColor.addActionListener(new ButtonListenerColorChoser());
        this.foregroundButton = foregroundColor;
        this.add(foregroundColor);
        
        JButton backgroundColor = new JButton();
        backgroundColor.setPreferredSize(new Dimension(50,25));
        backgroundColor.setMinimumSize(backgroundColor.getPreferredSize());
        backgroundColor.setMaximumSize(backgroundColor.getPreferredSize());
        backgroundColor.setBackground(Color.red);
        backgroundColor.addActionListener(new ButtonListenerColorChoser());
        this.backgroundButton = backgroundColor;
        this.add(backgroundColor);
    }

    public JButton getForegroundButton() {
        return foregroundButton;
    }
    
    public JButton getBackgroundButton() {
        return backgroundButton;
    }
}
