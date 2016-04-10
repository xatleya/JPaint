package Controler;

import View.Toolbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ButtonListenerToolChoser implements ActionListener{
    private Toolbar toolbar;
    
    public ButtonListenerToolChoser(Toolbar toolbar) {
        this.toolbar = toolbar;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {  
        JFileChooser fileChooser = new JFileChooser("tools");
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileFilter filter = new FileNameExtensionFilter("CLASS File","Ficher CLASS", "class");
        fileChooser.setFileFilter(filter);
        int action = fileChooser.showOpenDialog(null);
        if(action == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            this.toolbar.getToolbarToolsPanel().addToll(file);
        }
    }
    
}
