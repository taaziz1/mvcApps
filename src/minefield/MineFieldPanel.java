package minefield;

import mvc.*;

import javax.swing.*;
import java.awt.*;

public class MineFieldPanel extends AppPanel {
    public MineFieldPanel (AppFactory factory) {
        super(factory);

        controlPanel.setLayout(new GridLayout(4, 2));
        controlPanel.setBorder(BorderFactory.createLineBorder(Color.PINK, 2));

        for(String s: factory.getEditCommands()) {
            JPanel panel = new JPanel();
            JButton b = new JButton(s);
            b.addActionListener(this);
            controlPanel.add(panel);
            panel.add(b);
        }

    }

    public static void main(String[] args) {
        AppFactory factory = new MineFieldFactory();
        AppPanel panel = new MineFieldPanel(factory);
        panel.display();
    }
}