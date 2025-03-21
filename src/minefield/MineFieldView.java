package minefield;

import mvc.*;
import javax.swing.*;
import java.awt.*;

public class MineFieldView extends View {
    private JLabel[][] labels;
    private JLabel prevLabel;

    public MineFieldView(Model minefield) {
        super(minefield);
        initView();
    }


    //Java Swing was creating random elements in the background of the frame
    //Only solution I found was removing repaint() and using updateView() to repaint the component
    @Override
    public void update() {
        updateView();
    }

    @Override
    public void setModel(Model newModel) {
        super.setModel(newModel);
        initView();
        updateView();
    }

    private void initView() {
        int size = MineField.fieldSize;
        this.removeAll();
        this.setBackground(Color.GRAY);
        this.setLayout(new GridLayout(size, size));

        labels = new JLabel[size][size];
        MineField field = (MineField) model;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                JLabel l = new JLabel();

                l.setHorizontalAlignment(SwingConstants.CENTER);
                l.setVerticalAlignment(SwingConstants.CENTER);

                if(field.getPatch(j,i).getVisited()) {
                    l.setText("" + field.getPatch(j,i).getAdjacentMines());
                    l.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                }
                else {
                    l.setText("?");
                    l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }

                l.setBackground(Color.GRAY);
                l.setOpaque(true);
                this.add(l);

                labels[j][i] = l;
            }
        }

        labels[field.getX()][field.getY()].setBorder(BorderFactory.createLineBorder(Color.BLUE));
        System.out.println("0: painted " + field.getX() + " " + field.getY() + " blue");

        labels[size - 1][size - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN));

        prevLabel = labels[field.getX()][field.getY()];

        this.revalidate();
    }

    public void updateView() {
        MineField field = (MineField)model;
        JLabel currLabel = labels[field.getX()][field.getY()];

        if(prevLabel != null) {
            prevLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            System.out.println("1: painted " + field.getX() + " " + field.getY() + " white");
        }

        if(field.atGoal()) {
            currLabel.setText("!");
            currLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        }
        else if(field.onMine()) {
            currLabel.setText("X");
            currLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        else {
            currLabel.setText("" + field.getAdjacentMines());
            System.out.println("1: painted " + field.getX() + " " + field.getY() + " blue");
            currLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        }

        if(prevLabel != currLabel) {
            prevLabel = currLabel;
        }

        this.revalidate();
    }
}
