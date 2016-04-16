package View;

import Controler.Tool;
import Controler.ToolException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolbarToolsPanel extends JPanel{  //panel des tools
    private MainFrame mainFrame;
    
    public ToolbarToolsPanel(MainFrame mainFrame)  {
        this.setLayout(new GridLayout(5,1,4,4));    //il s'agit d'un gridLayout
        this.setPreferredSize(new Dimension(100,530));
        this.setBorder(BorderFactory.createLineBorder(Color.black));  
        this.mainFrame = mainFrame;
        //this.addAllTools();
    }
    
    public void addAllTools() { //ajoute tous les outils à la toolbar
        File[] files = null; 
        File directoryToScan = new File("tools");   //on scan le dossier tools pour récupérer tous les fichiers .class
        files = directoryToScan.listFiles(); 
        
        try {
            for(int i =0;i<=files.length-1;i++) {
                this.addToll(files[i]); //on ajoute les tools une par une
            }
        } catch (IllegalArgumentException ex) { 
            System.out.println(ex.getMessage());
        } catch (SecurityException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void addToll(File file) {    //ajoute un outil à la toolbar
        CustomClassLoader c = new CustomClassLoader();  //on charge un outils en particulier (au choix)
        Class toolClass = null;
        try {
            toolClass = c.defineClassFromPath(file.toPath());   //on récupère le .class
            Class s = Class.forName(toolClass.getName());   //transforme le fichier .class en class lu par notre programme java
            if(Tool.class.isAssignableFrom(s)) {    //si notre .class est un tool
                Constructor constr = s.getConstructor(new Class[]{MainFrame.class});    //on récupère son contructeur
                JButton tool = (JButton) createObject(constr, new Object[]{this.mainFrame});    //on le cast en JButton
                this.add(tool);     //on ajoute le tool à la toolbar
            }
            else {  //si le .class n'est pas un tool
                throw new ToolException();  //on envoie une exception
            }
        }
        catch (ToolException ex) {
            System.out.println(ex.getMessage());
        }
        catch (IOException ex) {
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (SecurityException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (NoSuchMethodException ex) {
            System.out.println(ex.getMessage());
        }
        this.mainFrame.revalidate();
        this.mainFrame.repaint();
    }
    
    public void removeTool(String status) { //supprime un tool de la toolbar et désactive ce tool
        for(Component current : this.getComponents()) {
            try {
                if(Class.forName("Tools.Tool" + status).isInstance(current)) {
                    this.remove(current);
                    this.mainFrame.getDrawPanel().removeListeners();
                    this.mainFrame.revalidate();
                    this.mainFrame.repaint();
                    break;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ToolbarToolsPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static Object createObject(Constructor constructor, Object[] arg) {  //crée un objet par son constructeur
        Object object = null;
        try {
            object = constructor.newInstance(arg);
            return object;
        } catch (InstantiationException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } catch (InvocationTargetException e) {
            System.out.println(e);
        }       
        return object;
    }
}
