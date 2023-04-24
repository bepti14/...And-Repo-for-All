import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

import static javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION;

public class SideBar extends JPanel implements ListSelectionListener {
//    JPanel sp = new JPanel();

    SideBar() {
        this.setPreferredSize(new Dimension(200, this.getHeight()));
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        DefaultListModel<String> listModel = new DefaultListModel<String>();
//        JMenuItem i1, i2;

//        i1 = new JMenuItem("Plik-1.txt");
//        i2 = new JMenuItem("Plik-2.txt");

        listModel.addElement("Plik-1.txt");
        listModel.addElement("Plik-2.txt");
        listModel.addElement("index.html");
        listModel.addElement("style.css");
        listModel.addElement("script.js");
        listModel.addElement("Plik-1.txt");
        listModel.addElement("Plik-2.txt");
        listModel.addElement("index.html");
        listModel.addElement("style.css");
        listModel.addElement("script.js");
        listModel.addElement("Plik-1.txt");
        listModel.addElement("Plik-2.txt");
        listModel.addElement("index.html");
        listModel.addElement("style.css");
        listModel.addElement("script.js");

        JList<String> list = new JList<String>(listModel);

        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setSelectedIndex(2);
        list.setVisibleRowCount(4);
        list.addListSelectionListener(this);

        JScrollPane scroll = new JScrollPane(list);

//        this.add(list);
        this.add(scroll); // trzeba dodać to, a nie listę, bo scrolla nie będzie

//        JLabel label = new JLabel();
//        label.setText("Ostatnie pliki");
//        sp.add(label);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("Coś klik // " + e.getSource());
    }
}
