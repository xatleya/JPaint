package View;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    private DrawPanel drawPanel;
    
    public MainFrame() {
        super("JPaint");
        
        JPanel panelUnderDrawPanel = new JPanel();
        panelUnderDrawPanel.setLayout(new BorderLayout(5,5));
        DrawPanel drawPanel = new DrawPanel();
        panelUnderDrawPanel.add(drawPanel, BorderLayout.CENTER);
        this.drawPanel = drawPanel;
        this.add(panelUnderDrawPanel);
        
        Toolbar toolbar = new Toolbar();
        Container contentPane = this.getContentPane();
        contentPane.add(toolbar, BorderLayout.WEST);
        
        StatusPanel statusPanel = new StatusPanel(this);
        this.add(statusPanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
        this.setSize(550,650);
        this.setMinimumSize(this.getSize());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }
}
