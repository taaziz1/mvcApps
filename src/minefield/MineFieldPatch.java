package minefield;

import java.io.Serializable;

public class MineFieldPatch implements Serializable {
    private Boolean mine;
    private Boolean visited;
    private int adjacentMines;

    public MineFieldPatch() {
        mine = false;
        visited = false;
        adjacentMines = 0;
    }

    public void arm() {
        mine = true;
    }

    public Boolean hasMine() {
        return mine;
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
