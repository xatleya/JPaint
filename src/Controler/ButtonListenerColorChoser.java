package Controler;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;

public class ButtonListenerColorChoser implements ActionListener{   //listener changement couleur
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton button = (JButton)ae.getSource();   //récupère le bouton sur lequel on a cliqué
        Color color = JColorChooser.showDialog(null, "Choose a color", button.getBackground());     //on ouvre la fenêtre pour choisir la couleur
        if(color == null) {     //si on annule le choix d'une couleur, on reprend la dernière couleur
            color = button.getBackground();
        }
        button.setBackground(color);    //on ajoute au bouton la nouvelle couleur
    }
    
}
