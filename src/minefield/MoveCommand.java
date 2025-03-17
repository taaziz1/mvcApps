package minefield;

import mvc.*;

public class MoveCommand extends Command {
    Heading heading;
    public MoveCommand(Model model) {
        super(model);
    }

    public void execute() {
        MineField minefield = (MineField)model;
        minefield.move();
    }

}