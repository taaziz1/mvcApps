package minefield;

import mvc.*;

public class MineFieldFactory implements AppFactory {


    public Model makeModel() { return new MineField(); }

    public View makeView(Model m) {
        return new MineFieldView((MineField)m);
    }

    public String[] getEditCommands() { return new String[] {"NW", "N", "NE", "W", "E", "SW", "S", "SE"}; }

    public Command makeEditCommand(Model model, String type, Object source) {
        switch(type) {
            case "NW":
                return new MoveCommand(model, Heading.NW);
            //Need to fill in rest of cases
        }
        return null;
    }

    public String getTitle() { return "Mine Field"; }

    public String[] getHelp() {
        return new String[] {"Click on a direction from the control panel\nto move around the grid. The number in each\nbox" +
                " shows how many mines are adjacent.\nThe goal is to reach the bottom right box.\nGood luck!"};
    }

    public String about() {
        return "Mine Field. Talha Aziz, Connor Corona, Howie Pham. 3/20/2025";
    }

}