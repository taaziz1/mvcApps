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
        //minefield.move(); Use a switch case or if else statements for each direction
    }

}