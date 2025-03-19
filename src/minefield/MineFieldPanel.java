package minefield;

import mvc.*;

import javax.swing.*;
import java.awt.*;

public class MineFieldPanel extends AppPanel {
    public MineFieldPanel (AppFactory factory) {
        super(factory);

        controlPanel.setLayout(new GridLayout(4, 2));

        for(String s: factory.getEditCommands()) {
            JPanel panel = new JPanel();
            JButton b = new JButton(s);
            b.addActionListener(this);
            panel.add(b);
            controlPanel.add(panel);
            panel.add(b);
        }

        view.setBackground(Color.gray);

    }

    public static void main(String[] args) {
        AppFactory factory = new MineFieldFactory();
        AppPanel panel = new MineFieldPanel(factory);
        panel.display();
    }
}
