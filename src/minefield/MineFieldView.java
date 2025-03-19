package minefield;

import mvc.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MineFieldView extends View {
    private JLabel[][] labels;

    public MineFieldView(Model minefield) {
        super(minefield);
        initView();
    }

    @Override
    public void setModel(Model newModel) {
        super.setModel(newModel);
        initView();
        repaint();
    }

    private void initView() {
        int size = MineField.fieldSize;
        this.removeAll();
        this.setLayout(new GridLayout(size, size));
        this.setBackground(Color.black);
        labels = new JLabel[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                JLabel l = new JLabel();
                l.setOpaque(true);
                //l.setSize(this.getSize().width / size,
                //        this.getSize().height / size);
                l.setText("?");
                l.setBackground(Color.LIGHT_GRAY);
                l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                this.add(l);
                labels[j][i] = l;
            }
        }
        labels[0][0].setText("" + ((MineField) model).getPatch(0, 0).getAdjacentMines());
        labels[0][0].setBackground(Color.WHITE);
        labels[size - 1][size - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN));
    }

    @Override
    public void paintComponent(Graphics gc) {
        MineField field = (MineField)model;
        JLabel currLabel = labels[field.getX()][field.getY()];

        if(field.atGoal()) {
            currLabel.setText("!");
        }
        else if(field.onMine()) {
            currLabel.setText("X");
            currLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
        } else {
            currLabel.setText("" + field.getAdjacentMines());
            currLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        }
        currLabel.setBackground(Color.WHITE);
    }
}
