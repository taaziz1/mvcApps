package minefield;

import mvc.Model;
import mvc.Utilities;

public class MineField extends Model {
    public static int percentMined = 5;
    public static int fieldSize = 20;

    private MineFieldPatch[][] field;
    private Boolean gameOver = false;
    private int posX, posY;

    public MineField() {
        super();
        posX = 0; posY = 0;
        initField();
    }

    private void initField() {
        field = new MineFieldPatch[fieldSize][fieldSize];

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = new MineFieldPatch();
            }
        }

        field[0][0].setVisited(true);

        int numMines = (int)((percentMined/100.0) * (fieldSize * fieldSize));

        //This while loop sets the locations of the mines
        while(numMines > 0) {
            int row = Utilities.rng.nextInt(fieldSize);
            int col = Utilities.rng.nextInt(fieldSize);

            //Make sure chosen MineFieldPatch isn't starting point, ending point, or already mined
            if((row + col != 0)
                    && (row + col != (fieldSize - 1) + (fieldSize - 1))
                    && !field[row][col].hasMine()) {

                field[row][col].arm();

                //Increment adjacentMines by 1 for all valid neighbors
                for(int neighborX = row - 1; neighborX <= row + 1; neighborX++) {
                    for(int neighborY = col - 1; neighborY <= col + 1; neighborY++) {
                        if(inBounds(neighborX, neighborY) && (neighborX != row || neighborY != col)) {
                            field[neighborX][neighborY].incrementAdjacentMines();
                        }
                    }
                }

                numMines--;
            }
        }

    }

    public void move(Heading h) throws Exception{
        if(gameOver) {
            throw new Exception("game already over");
        }

        int newX = posX;
        int newY = posY;

        //Uses type of Heading h to determine how far the player should move
        switch(h) {
            case NW -> { newX--; newY--; }
            case N -> { newY--; }
            case NE -> { newX++; newY--; }
            case W -> { newX--; }
            case E -> { newX++; }
            case SW -> { newX--; newY++; }
            case S -> { newY++; }
            case SE -> { newX++; newY++; }
            default -> { throw new Exception("invalid movement"); }
        }

        if(!inBounds(newX, newY)) {
            throw new Exception("out of bounds");
        }

        posX = newX;
        posY = newY;

        field[posY][posX].setVisited(true);

        changed();

        if(field[posY][posX].hasMine()) {
            gameOver = true;
            throw new Exception("lose");
        }

        if(posX + posY == (fieldSize - 1) + (fieldSize - 1)) {
            gameOver = true;
            throw new Exception("win");
        }
    }

    public Boolean inBounds(int x, int y) {
        return x >= 0 && x < fieldSize && y >= 0 && y < fieldSize;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public MineFieldPatch getPatch(int x, int y) {
        return field[y][x];
    }

    public Boolean atGoal() {
        return posX == fieldSize - 1 && posY == (fieldSize - 1);
    }

    public Boolean onMine() {
        return field[posY][posX].hasMine();
    }

    public int getAdjacentMines() {
        return field[posY][posX].getAdjacentMines();
    }

}