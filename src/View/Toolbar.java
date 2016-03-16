package View;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar{
    public Toolbar() {
        JButton selectButton = new JButton("select");
        this.add(selectButton);
    } 
}
