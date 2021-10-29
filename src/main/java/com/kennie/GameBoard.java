package com.kennie;

import java.util.HashSet;
import java.util.Set;

public class GameBoard {

    Set<Cell> cells = new HashSet<>();
    public void addCell(int x, int y) {
        this.cells.add(new Cell(x, y));
    }

    public boolean isCellAlive(int x, int y) {
        return cells.contains(new Cell(x, y));
    }

    public void nextGeneration() {
        cells.clear();
    }
}
