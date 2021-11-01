package com.kennie;

import java.util.HashSet;
import java.util.Set;

public class GameBoard {

    Set<Cell> cells = new HashSet<>();

    private int[][] neighbours = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1},
    };

    public void addCell(int x, int y) {
        this.cells.add(new Cell(x, y));
    }

    public boolean isCellAlive(int x, int y) {
        return cells.contains(new Cell(x, y));
    }

    public void nextGeneration() {
        Set<Cell> tmpCells = new HashSet<>();

        for (Cell c : cells){
            int n = countNeighbours(c);
            if (n == 2 || n == 3) {
                tmpCells.add(c);
            }
        }
        cells = tmpCells;
    }

    private int countNeighbours(Cell cell) {
        int count = 0;

        for (int i = 0; i < neighbours.length; i++) {
            Cell nc = new Cell(cell.getX() + neighbours[i][0], cell.getY() + neighbours[i][1]);
            if (cells.contains(nc)) {
                count++;
            }
        }
        return count;
    }
}
