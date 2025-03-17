package minefield;

import mvc.*;

public class MineFieldFactory implements AppFactory {


    public Model makeModel() { return new MineField(); }

    public View makeView(Model m) {
        return new MineFieldView((MineField)m);
    }

    public String[] getEditCommands() { return new String[] {"Move"}; }

    // source added 3/15 to support text fields
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "Move")
            return new MoveCommand(model);
        return null;
    }

    public String getTitle() { return "Mine Field"; }

    public String[] getHelp() {
        return new String[] {"Click on a direction from the control panel\nto move around the grid. The number in each\nbox" +
                " shows how many mines are adjacent.\nThe goal is to reach the bottom right box.\nGood luck!"};
    }

    public String about() {
        return "Mine Field version 1.0. Copyright 2025 by THC Designs";
    }

}