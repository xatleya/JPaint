package View;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.text.Utilities;

public class ToolbarButton extends JButton{
    private int buttonNumber;
            
    public ToolbarButton(int buttonNumber){
        this.buttonNumber = buttonNumber;

        this.setPreferredSize(new Dimension(150, 100));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        
        //image and rescale of it
        String s = Integer.toString(buttonNumber);
        ImageIcon imageIcon = new ImageIcon("src/Ressource/icon"+s+".png");
        Image image = imageIcon.getImage();
        Image newimg =image.getScaledInstance(150, 100,  java.awt.Image.SCALE_SMOOTH); 
        this.setIcon(new ImageIcon(newimg));
    }   
}
