package View;
import Controler.ToolbarButtonListener;
import Tools.ToolOval;
import Tools.ToolFill;
import Tools.ToolLine;
import Tools.ToolRectangle;
import Tools.ToolSelect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolbarButtonPanel extends JPanel{
    
    public ToolbarButtonPanel(StatusPanel statusPanel, DrawPanel drawPanel)  {
        this.setLayout(new GridLayout(5,1,4,4));
        this.setPreferredSize(new Dimension(100,530));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        //create Buttons
        /*ToolbarButton selectShapeButton = new ToolbarButton(1);
        selectShapeButton.addActionListener(new ToolbarButtonListener(statusPanel, "Select", drawPanel));*/
        //ToolSelect toolSelect = new ToolSelect(statusPanel, drawPanel);
        
        /*ToolbarButton fillShapeButton = new ToolbarButton(2);
        fillShapeButton.addActionListener(new ToolbarButtonListener(statusPanel, "Fill", drawPanel));*/
        //ToolFill toolFill = new ToolFill(statusPanel, drawPanel);
        
        /*ToolbarButton ovalDrawButton = new ToolbarButton(3);
        ovalDrawButton.addActionListener(new ToolbarButtonListener(statusPanel, "Oval", drawPanel));*/
        //ToolOval toolOval = new ToolOval(statusPanel, drawPanel);
        
        /*ToolbarButton lineDrawButton = new ToolbarButton(4);
        lineDrawButton.addActionListener(new ToolbarButtonListener(statusPanel, "Line", drawPanel));*/
        //ToolLine toolLine = new ToolLine(statusPanel, drawPanel);
        
        /*ToolbarButton rectangleDrawButton = new ToolbarButton(5);
        rectangleDrawButton.addActionListener(new ToolbarButtonListener(statusPanel, "Rectangle", drawPanel));*/
        //ToolRectangle toolRectangle = new ToolRectangle(statusPanel, drawPanel);
        
        /*this.add(toolSelect);
        this.add(toolFill);
        this.add(toolOval);
        this.add(toolLine);
        this.add(toolRectangle);*/
        
        /*File[] files = null; 
        File directoryToScan = new File("tools"); 
        files = directoryToScan.listFiles(); 
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(files[0].getPath()));
            //Class c = (Class)ois.readObject();
            //System.out.println(c.getName());
        }      
        catch(IOException ioException){
            System.out.println(ioException.getMessage());
        } */
        /*catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        } */
        File[] files = null; 
        File directoryToScan = new File("tools"); 
        files = directoryToScan.listFiles(); 
        
        CustomClassLoader c = new CustomClassLoader();
        Class toolClass = null;
        try {
            for(int i =0;i<=files.length-1;i++) {
                toolClass = c.defineClassFromPath(files[i].toPath());
                Class s = Class.forName(toolClass.getName());
                Constructor constr = s.getConstructor(new Class[]{StatusPanel.class, DrawPanel.class});
                JButton tool = (JButton) createObject(constr, new Object[]{statusPanel, drawPanel});
                this.add(tool);
            }
        }
        catch (IOException ex) {
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ToolbarButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ToolbarButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ToolbarButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ToolbarButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(toolClass.getName());
        
        
        
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
