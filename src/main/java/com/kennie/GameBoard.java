package com.kennie;

import java.util.Collection;
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
        Set<Cell> nextGenCells = new HashSet<>();
        Set<Cell> possibleCells = generateNextGenCells(nextGenCells);

        generateNewCells(nextGenCells, possibleCells);
        cells = nextGenCells;
    }

    private void generateNewCells(Set<Cell> tmpCells, Set<Cell> possibleCells) {
        for (Cell c : possibleCells){
            int n = countNeighbours(c);
            if (n == 3){
                tmpCells.add(c);
            }
        }
    }

    private Set<Cell> generateNextGenCells(Set<Cell> tmpCells) {
        Set<Cell> possibleCells = new HashSet<>();
        for (Cell c : cells){
            int n = countNeighbours(c);
            if (n == 2 || n == 3) {
                tmpCells.add(c);
            }
            possibleCells.addAll(aroundCell(c));
        }
        return possibleCells;
    }

    private Set<Cell> aroundCell(Cell cell) {
        Set<Cell> neighbourCells = new HashSet<>();
        for (int i = 0; i < neighbours.length; i++) {
            Cell nc = new Cell(cell.getX() + neighbours[i][0], cell.getY() + neighbours[i][1]);
            neighbourCells.add(nc);
        }
        return neighbourCells;
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
