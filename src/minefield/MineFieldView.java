package minefield;

import mvc.*;
import javax.swing.*;


public class MineFieldView extends View {

    public MineFieldView(Model minefield) {
        super(minefield);
    }

    public void setModel(Model newModel) {
        super.setModel(newModel);
        initView();
        repaint();
    }

    public void initView() {

    }
}
