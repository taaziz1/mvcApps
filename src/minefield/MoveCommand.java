package minefield;

import mvc.*;

public class MoveCommand extends Command {
    Heading heading;
    public MoveCommand(Model model, Heading heading) {
        super(model);
        this.heading = heading;
    }

    public void execute() {
        MineField minefield = (MineField)model;
        try {
        	if (heading == Heading.NW) {
        		minefield.move(-1, -1);
        	}
        	else if (heading == Heading.N) {
        		minefield.move(0, -1);
        	}
        	else if (heading == Heading.NE) {
        		minefield.move(1, -1);
        	}
        	else if (heading == Heading.W) {
        		minefield.move(-1, 0);
        	}
        	else if (heading == Heading.E) {
        		minefield.move(1, 0);
        	}
        	else if (heading == Heading.SW) {
        		minefield.move(-1, 1);
        	}
        	else if (heading == Heading.S) {
        		minefield.move(0, 1);
        	}
        	else if (heading == Heading.SE) {
        		minefield.move(1, 1);
        	}
        	//in case some other movement is tried
        	else {
        		throw new Exception("Invalid Movement Option!");
        	}
        }
        catch (Exception e) {
        	Utilities.error(e);
        }
    }
}