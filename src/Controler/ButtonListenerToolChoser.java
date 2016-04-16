package Controler;

import View.Toolbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ButtonListenerToolChoser implements ActionListener{    //ajoute un outil
    private Toolbar toolbar;
    
    public ButtonListenerToolChoser(Toolbar toolbar) {
        this.toolbar = toolbar;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {  //si on clique sur +, on ajoute un outil 
        JFileChooser fileChooser = new JFileChooser("tools");   //on ouvre une fenêtre de choix dans le dossier tools par défault
        fileChooser.setAcceptAllFileFilterUsed(false);  //on n'autorise que les fichiers .class
        FileFilter filter = new FileNameExtensionFilter("CLASS File","Ficher CLASS", "class");
        fileChooser.setFileFilter(filter);  //filtre les fichier .class
        int action = fileChooser.showOpenDialog(null);
        if(action == JFileChooser.APPROVE_OPTION) {     //si on clique sur ok
            File file = fileChooser.getSelectedFile();      //on récupère le fichier sélectionné
            this.toolbar.getToolbarToolsPanel().addToll(file);      //on l'joute à la toolbar (les vérifications sont dans addTool)
        }
    }
    
}
