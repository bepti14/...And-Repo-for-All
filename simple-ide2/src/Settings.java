import javax.swing.*;
import java.awt.*;
import java.util.prefs.Preferences;

public class Settings extends JDialog {
    public Preferences prefs;
    JComboBox<String> lang;

    Settings(JFrame owner) {
        super(owner, "Ustawienia", true);

        setMinimumSize(new Dimension(400, 400));
        setLocationRelativeTo(this.getParent());

        prefs = Preferences.userNodeForPackage(Settings.class);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Panel 1 (przyciski)
        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Dostępne ustawienia");
        panel1.add(label1);

        JButton reject = new JButton("Odrzuć");
        JButton keep = new JButton("Zachowaj");
        panel1.add(reject);
        panel1.add(keep);

        contentPane.add(panel1);

        // Panel 2 (Okno)
        contentPane.add(Box.createVerticalStrut(2));
        TitledPanel panel2 = new TitledPanel("Okno");
        JCheckBox centered = new JCheckBox("uruchom wyśrodkowane");
        JCheckBox max = new JCheckBox("uruchom zmaksymalizowane");
        JCheckBox rposition = new JCheckBox("zapamiętaj pozycję");
        JCheckBox rsize = new JCheckBox("zapamiętaj rozmiar");
        panel2.add(centered);
        panel2.add(max);
        panel2.add(rposition);
        panel2.add(rsize);
        contentPane.add(panel2);

        // Panel 3 (IDE)
        contentPane.add(Box.createVerticalStrut(2));
        TitledPanel panel3 = new TitledPanel("IDE");
        String[] options = {"Polski", "English"};
        JLabel cboxLabel = new JLabel("język interfejsu");
        lang = new JComboBox<>(options);
        JCheckBox rdirectory = new JCheckBox("zapamiętaj katalog przeglądania");
        JCheckBox rfiles = new JCheckBox("zapamiętaj otwarte pliki");
        panel3.add(cboxLabel);
        panel3.add(lang);
        panel3.add(rdirectory);
        panel3.add(rfiles);
        contentPane.add(panel3);

        // Panel 4 (GUI)
        contentPane.add(Box.createVerticalStrut(2));
        TitledPanel panel4 = new TitledPanel("GUI");
        JCheckBox hidemm = new JCheckBox("ukryj menu główne");
        JCheckBox unpinnedbar = new JCheckBox("odpięty pasek narzędziowy");
        JCheckBox lockbar = new JCheckBox("zablokuj pasek narzędziowy");
        JCheckBox darkmode = new JCheckBox("tryb ciemny");
        panel4.add(hidemm);
        panel4.add(unpinnedbar);
        panel4.add(lockbar);
        panel4.add(darkmode);
        contentPane.add(panel4);

        // tablica wszystkich checkbox'ów do zapisu i odczytu
        JCheckBox[] checkBoxes = {centered, max, rposition, rsize, rfiles, rdirectory, rfiles, hidemm, unpinnedbar, lockbar, darkmode};

        // ładowanie preferencji
        loadPrefs(checkBoxes);

        // handlery event'ów
        reject.addActionListener(e -> {
            dispose();
        });

        keep.addActionListener(e -> {
            savePrefs(checkBoxes);
            dispose();
        });

        setContentPane(contentPane);
        pack();
        setVisible(true);
    }

    // ładowanie ustawień
    void loadPrefs(JCheckBox[] checkBoxes) {
        int counter = 0;
        for (JCheckBox box : checkBoxes) {
            if (prefs.getBoolean(Integer.toString(counter), false)) {
                box.setSelected(true);
            } else {
                box.setSelected(false);
            }
            counter++;
        }
        lang.setSelectedIndex(prefs.getInt(Integer.toString(counter + 1), 0));
    }

    // zapis ustawień
    void savePrefs(JCheckBox[] checkBoxes) {
        int counter = 0;
        for (JCheckBox box : checkBoxes) {
            prefs.putBoolean(Integer.toString(counter), box.isSelected());
            counter++;
        }
        prefs.putInt(Integer.toString(counter + 1), lang.getSelectedIndex());
    }
}

class TitledPanel extends JPanel {

    TitledPanel(String title) {
       setLayout(new GridLayout(0, 1));
       setBorder(BorderFactory.createTitledBorder(title));
    }
}
