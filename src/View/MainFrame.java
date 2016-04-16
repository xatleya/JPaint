package View;

import Modele.MainModele;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{  //fenêtre de l'application
    private DrawPanel drawPanel;
    private StatusPanel statusPanel = new StatusPanel(this);
    private Toolbar toolbar;
    
    public MainFrame(MainModele modele) {
        super("JPaint");
        
        JPanel panelUnderDrawPanel = new JPanel();  //crée le JPanel principal
        panelUnderDrawPanel.setLayout(new BorderLayout(5,5));
        DrawPanel drawPanel = new DrawPanel(modele, this);
        panelUnderDrawPanel.add(drawPanel, BorderLayout.CENTER);
        this.drawPanel = drawPanel;
        this.add(panelUnderDrawPanel);
        
        Toolbar toolbar = new Toolbar(this);    //crée le JToolbar
        Container contentPane = this.getContentPane();
        contentPane.add(toolbar, BorderLayout.WEST);
        this.toolbar = toolbar;
        
        this.add(statusPanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
        this.setSize(900,700);
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

    public Toolbar getToolbar() {
        return toolbar;
    }

    public StatusPanel getStatusPanel() {
        return statusPanel;
    }
}
