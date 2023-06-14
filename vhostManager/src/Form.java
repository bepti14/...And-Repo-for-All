import javax.swing.*;
import java.awt.*;

public class Form extends JFrame {
    private JPanel panel1;
    private JButton archiwizujButton;
    private JButton zapiszButton;
    private JButton ustawieniaButton;
    private JButton walidujButton;
    private JList list1;
    private JTabbedPane tabbedPane1;
    private JTextField a00Ygp4ConfTextField;

    Form() {
        setContentPane(panel1);

        setMinimumSize(new Dimension(400, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
