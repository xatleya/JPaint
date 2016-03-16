package View;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class StatusPanel extends JPanel{
    public StatusPanel(JFrame frame) {
        this.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.setPreferredSize(new Dimension(frame.getWidth(),16));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JLabel label = new JLabel("status");
        label.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(label);
    }
}
