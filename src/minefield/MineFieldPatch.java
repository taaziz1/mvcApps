package minefield;

public class MineFieldPatch {
    private Boolean mine;
    private Boolean visited;
    private int adjacentMines;

    public MineFieldPatch() {
        mine = false;
        visited = false;
        adjacentMines = 0;
    }

    public Boolean hasMine() {
        return mine;
    }

    //Returns false if patch was already mined, true otherwise
    public Boolean arm() {
        if(mine) {
            return false;
        }
        mine = true;
        return true;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void incrementAdjacentMines() {
        adjacentMines += 1;
    }

    public void setVisited(Boolean v) {
        visited = v;
    }

}
