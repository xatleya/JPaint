package View;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolbarButtonPanel extends JPanel{
    public ToolbarButtonPanel() {
        this.setLayout(new GridLayout(5,1,4,4));
        this.setPreferredSize(new Dimension(100,530));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        //create Button
        ToolbarButton selectShapeButton =new ToolbarButton(1);
        ToolbarButton fillShapeButton =new ToolbarButton(2);
        ToolbarButton drawOvalButton =new ToolbarButton(3);
        ToolbarButton drawLineButton =new ToolbarButton(4);
        ToolbarButton drawRectangleButton =new ToolbarButton(5);
        //add button
        this.add(selectShapeButton);
        this.add(fillShapeButton);
        this.add(drawOvalButton);
        this.add(drawLineButton);
        this.add(drawRectangleButton);
    }
}
