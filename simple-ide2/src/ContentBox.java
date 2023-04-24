import javax.swing.*;
import java.awt.*;

public class ContentBox extends JPanel {

    private final JTextArea area1;
    private final JTextArea area2;
    private final JScrollPane scroll1;
    private final JScrollPane scroll2;

    ContentBox() {
       area1 = new JTextArea(16, 30);
       area2 = new JTextArea();
       scroll1 = new JScrollPane(area1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       scroll2 = new JScrollPane(area2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

       scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


       JTabbedPane tabs = new JTabbedPane();
       tabs.addTab("Area 1", scroll1);
       tabs.addTab("Area 2", scroll2);

       add(tabs);
       setVisible(true);
    }

//    public void append(String text) {
//        area.append(text);
//    }
//
//    public void overwrite(String text) {
//        area.setText(text);
//    }
//
//    public String getContent() {
//        return area.getText();
//    }

//    public Container get() {
//        return scroll;
//    }
}
