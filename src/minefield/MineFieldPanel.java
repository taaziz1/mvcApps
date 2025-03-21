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
            panel.add(b);
            controlPanel.add(panel);
        }

    }

    @Override
    protected void handleException(Exception e) {
        String message = e.getMessage();

        switch (message) {
            case "win" ->
                    Utilities.inform("You win! Open a new\nfile to play again!");
            case "lose" ->
                    Utilities.inform("You stepped on a mine!\nOpen a new file to play again.");
            case "out of bounds" ->
                    Utilities.inform( "You attempted to move out of bounds.\nPlease stay inside the field!");
            case "game already over" ->
                    Utilities.inform("The game is finished. Please open\na new file to play again");
            default -> Utilities.error(e);
        }
    }

    public static void main(String[] args) {
        AppFactory factory = new MineFieldFactory();
        AppPanel panel = new MineFieldPanel(factory);
        panel.display();
    }
}