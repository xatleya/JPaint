package View;

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

public class ToolbarToolsPanel extends JPanel{
    private MainFrame mainFrame;
    
    public ToolbarToolsPanel(MainFrame mainFrame)  {
        this.setLayout(new GridLayout(5,1,4,4));
        this.setPreferredSize(new Dimension(100,530));
        this.setBorder(BorderFactory.createLineBorder(Color.black));  
        this.mainFrame = mainFrame;
        //this.addAllTools();
    }
    
    public void addAllTools() {
        File[] files = null; 
        File directoryToScan = new File("tools"); 
        files = directoryToScan.listFiles(); 
        
        try {
            for(int i =0;i<=files.length-1;i++) {
                this.addToll(files[i]);
            }
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ToolbarToolsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ToolbarToolsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addToll(File file) {
        CustomClassLoader c = new CustomClassLoader();
        Class toolClass = null;
        try {
            toolClass = c.defineClassFromPath(file.toPath());
            Class s = Class.forName(toolClass.getName());
            Constructor constr = s.getConstructor(new Class[]{MainFrame.class});
            JButton tool = (JButton) createObject(constr, new Object[]{this.mainFrame});
            this.add(tool);
        }
        catch (IOException ex) {
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ToolbarToolsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ToolbarToolsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ToolbarToolsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ToolbarToolsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(toolClass.getName());
        this.mainFrame.revalidate();
        this.mainFrame.repaint();
    }
    
    public void removeTool(String status) {
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
    
    public static Object createObject(Constructor constructor, Object[] arg) {
        System.out.println ("Constructor: " + constructor.toString());
        Object object = null;
        try {
            object = constructor.newInstance(arg);
            System.out.println ("Object: " + object.toString());
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
