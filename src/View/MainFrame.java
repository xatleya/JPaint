package View;

import Modele.MainModele;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    private DrawPanel drawPanel;
    private StatusPanel statusPanel = new StatusPanel(this);
    
    public MainFrame(MainModele modele) {
        super("JPaint");
        
        JPanel panelUnderDrawPanel = new JPanel();
        panelUnderDrawPanel.setLayout(new BorderLayout(5,5));
        DrawPanel drawPanel = new DrawPanel(modele);
        panelUnderDrawPanel.add(drawPanel, BorderLayout.CENTER);
        this.drawPanel = drawPanel;
        this.add(panelUnderDrawPanel);
        
        Toolbar toolbar = new Toolbar(statusPanel, drawPanel);
        Container contentPane = this.getContentPane();
        contentPane.add(toolbar, BorderLayout.WEST);
        
        this.add(statusPanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
        this.setSize(800,650);
        this.setMinimumSize(this.getSize());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                ToolbarButtonPanel toolbarButtonPanel = toolbar.getToolbarButtonPanel();
                toolbarButtonPanel.setSize(new Dimension(toolbarButtonPanel.getWidth(),toolbarButtonPanel.getHeight()+getHeight()));
                revalidate();
                repaint();
                //System.out.println("componentResized");
            }
        });*/
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }
}
