import javax.swing.*;
import java.awt.*;

public class BottomPanel {
    JPanel bp = new JPanel();

    BottomPanel() {
        bp.setBackground(Color.LIGHT_GRAY);
        bp.setPreferredSize(new Dimension(bp.getWidth(), 30));

        JLabel label = new JLabel();
        label.setText("BottomPanel");
        bp.add(label);
    }
}
