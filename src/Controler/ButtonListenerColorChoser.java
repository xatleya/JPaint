package Controler;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;

public class ButtonListenerColorChoser implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton button = (JButton)ae.getSource();
        Color color = JColorChooser.showDialog(null, "Choose a color", Color.yellow);
        button.setBackground(color);
    }
    
}
