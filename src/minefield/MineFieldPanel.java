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

    @Override
    protected void handleException(Exception e) {
        String message = e.getMessage();

        if (message.equals("win")) {
            JOptionPane.showMessageDialog(null, "You win! Open a new\nfile to play again!","Congratulations!", JOptionPane.INFORMATION_MESSAGE);
        } else if (message.equals("lose")) {
            JOptionPane.showMessageDialog(null, "You stepped on a mine!\nOpen a " +
                    "new file to play again.","Game Over!", JOptionPane.INFORMATION_MESSAGE);
        } else if (message.equals("out of bounds")) {
            JOptionPane.showMessageDialog(null,
                    "You attempted to move out of bounds.\nPlease stay inside the field!"
                    ,"Oops!", JOptionPane.ERROR_MESSAGE);
        } else if (message.equals("game already over")) {
            JOptionPane.showMessageDialog(null, "The game is finished. Please open\na " +
                    "new file to play again","OOPS!", JOptionPane.ERROR_MESSAGE);
        } else if (message.equals("Invalid Movement Option!")) {
            JOptionPane.showMessageDialog(null, "That move is invalid!\nPlease try again.","OOPS!", JOptionPane.ERROR_MESSAGE);
        } else {
            Utilities.error(e);
        }
    }

    public static void main(String[] args) {
        AppFactory factory = new MineFieldFactory();
        AppPanel panel = new MineFieldPanel(factory);
        panel.display();
    }
}