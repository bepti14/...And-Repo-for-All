import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JMenuBar {
//    JMenuBar mb = new JMenuBar();

    MainMenu(JFrame frame) {
        JMenu menu, submenu;
        JMenuItem mi1, mi2, mi3, mi4;

        menu = new JMenu("Plik");
//        submenu = new JMenu("Ostatnie pliki");

        mi1 = new JMenuItem("Otwórz");
        mi2 = new JMenuItem("Ustawienia");
        mi3 = new JMenuItem("Plik-1.txt");
        mi4 = new JMenuItem("Plik-2.txt");

        ActionListener listener = e -> System.out.println("Button clicked!");

        mi1.addActionListener(listener);
        mi2.addActionListener(e -> {
            new Settings(frame);
        });
        mi3.addActionListener(listener);
        mi4.addActionListener(listener);

        menu.add(mi1);
        menu.add(mi2);
//        submenu.add(mi3);
//        submenu.add(mi4);

        add(menu);
//        mb.add(submenu);
    }
}
