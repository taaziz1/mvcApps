package minefield;

import mvc.*;
import javax.swing.*;
import java.awt.*;

public class MineFieldView extends View {

    public MineFieldView(Model minefield) {
        super(minefield);
        //this.removeAll();
        this.setLayout(new GridLayout(MineField.fieldSize, MineField.fieldSize));
        this.setBackground(Color.black);
        for(int i = 0; i < MineField.fieldSize; i++) {
            for(int j = 0; j < MineField.fieldSize; j++) {
                JLabel l = new JLabel();
                MineFieldPatch p = ((MineField)model).getPatch(j, i);
                l.setOpaque(true);
                l.setSize(this.getSize().width/MineField.fieldSize,
                        this.getSize().height/MineField.fieldSize);
                if(p.getVisited()) {
                    l.setText("" + p.getAdjacentMines());
                    l.setBackground(Color.LIGHT_GRAY);
                } else {
                    l.setText("?");
                    l.setBackground(Color.LIGHT_GRAY);
                }
                l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                this.add(l);
            }
        }
    }

    @Override
    public void setModel(Model newModel) {
        super.setModel(newModel);
        repaint();
    }

    //@Override
    //public void paintComponent(Graphics gc) {
    //
    //}
}
