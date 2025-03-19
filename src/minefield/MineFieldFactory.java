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
            case "N": 
            	return new MoveCommand(model, Heading.N);
            case "NE":
            	return new MoveCommand(model, Heading.NE);
            case "W": 
            	return new MoveCommand(model, Heading.W);
            case "E": 
            	return new MoveCommand(model, Heading.E);
            case "SW": 
            	return new MoveCommand(model, Heading.SW);
            case "S": 
            	return new MoveCommand(model, Heading.S);
            case "SE": 
            	return new MoveCommand(model, Heading.SE);
            default: 
            	return null;
        }
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