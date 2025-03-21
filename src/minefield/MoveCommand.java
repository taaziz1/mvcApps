package minefield;

import mvc.*;

public class MoveCommand extends Command {
    private Heading heading;
    public MoveCommand(Model model, Heading heading) {
        super(model);
        this.heading = heading;
    }

    public void execute() throws Exception{
        MineField minefield = (MineField)model;
        minefield.move(heading);
    }
}