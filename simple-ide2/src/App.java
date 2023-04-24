import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    JFrame box;
    String positions[] = { BorderLayout.PAGE_START, BorderLayout.LINE_START, BorderLayout.CENTER, BorderLayout.LINE_END, BorderLayout.PAGE_END};

    App() {
        box = new JFrame("Simple IDE");
        box.setLayout(new BorderLayout());

        MainMenu mainMenu = new MainMenu(this);
        box.add(mainMenu, positions[0]);

        SideBar sideBar = new SideBar();
        box.add(sideBar, positions[1]);

        ContentBox contentBox = new ContentBox();
        box.add(contentBox, positions[2]);

//        BottomPanel bottomPanel = new BottomPanel();
//        box.add(bottomPanel.bp, positions[4]);

        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        box.setMinimumSize(new Dimension(600, 400));
        box.setLocationRelativeTo(null);
        box.setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}
