package View;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolbarButtonPanel extends JPanel{
    private DrawPanel drawPanel;
    
    public ToolbarButtonPanel(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        this.setLayout(new GridLayout(5,1,4,4));
        this.setPreferredSize(new Dimension(100,530));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        //create Button
        ToolbarButton selectShapeButton = new ToolbarButton(1);
        ActionListener selectListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                   drawPanel.setTypeButton(new String("SELECT"));
                   System.out.println(drawPanel.getTypeButton());
            }
        };
        selectShapeButton.addActionListener(selectListener);
        
        ToolbarButton fillShapeButton = new ToolbarButton(2);
        ActionListener fillListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                   drawPanel.setTypeButton(new String("FILL"));
                   System.out.println(drawPanel.getTypeButton());
            }
        };
        fillShapeButton.addActionListener(fillListener);
        
        ToolbarButton drawOvalButton = new ToolbarButton(3);
        ActionListener ovalListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                   drawPanel.setTypeButton(new String("OVAL"));
                   System.out.println(drawPanel.getTypeButton());
            }
        };
        drawOvalButton.addActionListener(ovalListener);
        
        ToolbarButton drawLineButton = new ToolbarButton(4);
        ActionListener lineListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                   drawPanel.setTypeButton(new String("LINE"));
                   System.out.println(drawPanel.getTypeButton());
            }
        };
        drawLineButton.addActionListener(lineListener);
        
        ToolbarButton drawRectangleButton = new ToolbarButton(5);
        ActionListener rectangleListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                   drawPanel.setTypeButton(new String("RECTANGLE"));
                   System.out.println(drawPanel.getTypeButton());
            }
        };
       drawRectangleButton.addActionListener(rectangleListener);
        
        //add button
        this.add(selectShapeButton);
        this.add(fillShapeButton);
        this.add(drawOvalButton);
        this.add(drawLineButton);
        this.add(drawRectangleButton);
        
    }
}
