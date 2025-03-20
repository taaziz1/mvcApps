package minefield;

import mvc.*;
import javax.swing.*;
import java.awt.*;

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
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(size, size));

        labels = new JLabel[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                JLabel l = new JLabel();
                l.setHorizontalAlignment(SwingConstants.CENTER);
                l.setVerticalAlignment(SwingConstants.CENTER);
                l.setOpaque(true);
                //l.setSize(this.getSize().width / size,
                //        this.getSize().height / size);
                l.setText("?");
                l.setBackground(Color.GRAY);
                l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                this.add(l);
                labels[j][i] = l;
            }
        }
        labels[0][0].setText("" + ((MineField) model).getPatch(0, 0).getAdjacentMines());
        labels[size - 1][size - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN));
    }

    @Override
    public void paintComponent(Graphics gc) {
        MineField field = (MineField)model;
        JLabel currLabel = labels[field.getX()][field.getY()];
        MineFieldPatch currPatch = field.getPatch(field.getX(), field.getY());

        if(field.atGoal()) {
            currLabel.setText("!");
        }
        else if(field.onMine()) {
            currLabel.setText("X");
            currLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        else {
            currLabel.setText("" + field.getAdjacentMines());
            currLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        }

        if (field.getPatch(0,0) != currPatch) {
            labels[0][0].setBorder(BorderFactory.createLineBorder(Color.WHITE));
        } else {
            labels[0][0].setBorder(BorderFactory.createLineBorder(Color.BLUE));
        }

        for (int i = 0; i < field.fieldSize; i++) {
            for (int j = 0; j < field.fieldSize; j++) {
                if (field.getPatch(i, j).getVisited() && field.getPatch(i, j) != field.getPatch(field.getX(), field.getY())) {
                    labels[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                }
            }
        }
    }


}
