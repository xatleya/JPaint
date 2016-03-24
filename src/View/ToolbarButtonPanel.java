package View;
import Controler.ToolbarButtonListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolbarButtonPanel extends JPanel{
    
    public ToolbarButtonPanel(StatusPanel statusPanel) {
        this.setLayout(new GridLayout(5,1,4,4));
        this.setPreferredSize(new Dimension(100,530));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        //create Buttons
        ToolbarButton selectShapeButton = new ToolbarButton(1);
        selectShapeButton.addActionListener(new ToolbarButtonListener(statusPanel, "Select"));
        
        ToolbarButton fillShapeButton = new ToolbarButton(2);
        fillShapeButton.addActionListener(new ToolbarButtonListener(statusPanel, "Fill"));
        
        ToolbarButton ovalDrawButton = new ToolbarButton(3);
        ovalDrawButton.addActionListener(new ToolbarButtonListener(statusPanel, "Oval"));
        
        ToolbarButton lineDrawButton = new ToolbarButton(4);
        lineDrawButton.addActionListener(new ToolbarButtonListener(statusPanel, "Line"));
        
        ToolbarButton rectangleDrawButton = new ToolbarButton(5);
        rectangleDrawButton.addActionListener(new ToolbarButtonListener(statusPanel, "Rectangle"));
        
        this.add(selectShapeButton);
        this.add(fillShapeButton);
        this.add(ovalDrawButton);
        this.add(lineDrawButton);
        this.add(rectangleDrawButton);
    }
}
