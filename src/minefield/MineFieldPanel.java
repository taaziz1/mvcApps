package minefield;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MineFieldPanel extends AppPanel {
    public MineFieldPanel (AppFactory factory) {
        super(factory);
        model = new MineField();
        view = new MineFieldView(model);
        JPanel panel = new JPanel();
        controlPanel.add(panel);
        panel.setLayout(new GridLayout(4,2));

        ArrayList<JButton> buttons = new ArrayList<JButton>();
        JButton nw = new JButton("NW");
        JButton n = new JButton("N");
        JButton ne = new JButton("NE");
        JButton w = new JButton("W");
        JButton e = new JButton("E");
        JButton sw = new JButton("SW");
        JButton s = new JButton("S");
        JButton se = new JButton("SE");
        buttons.add(nw);
        buttons.add(n);
        buttons.add(ne);
        buttons.add(w);
        buttons.add(e);
        buttons.add(sw);
        buttons.add(s);
        buttons.add(se);
        for (JButton button : buttons) {
            button.addActionListener(this);
            controlPanel.add(button);
            panel.add(button);

        }
        view.setBackground(Color.gray);

    }

    // TODO: override actionPerformed for move()

    public static void main(String[] args) {
        AppFactory factory = new MineFieldFactory();
        AppPanel panel = new MineFieldPanel(factory);
        panel.display();
    }
}
