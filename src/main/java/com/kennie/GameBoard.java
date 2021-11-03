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

    public void addCell(int xAxis, int yAxis) {
        this.cells.add(new Cell(xAxis, yAxis));
    }

    public boolean isCellAlive(int xAxis, int yAxis) {
        return cells.contains(new Cell(xAxis, yAxis));
    }

    public void nextGeneration() {
        Set<Cell> nextGenCells = new HashSet<>();
        Set<Cell> possibleCells = generateNextGenCells(nextGenCells);

        generateNewCells(nextGenCells, possibleCells);
        cells = nextGenCells;
    }

    private void generateNewCells(Set<Cell> nextGenCells, Set<Cell> possibleCells) {
        for (Cell cell : possibleCells){
            int numberOfCells = countNeighbours(cell);
            if (numberOfCells == 3){
                nextGenCells.add(cell);
            }
        }
    }

    private Set<Cell> generateNextGenCells(Set<Cell> nextGenCells) {
        Set<Cell> possibleCells = new HashSet<>();
        for (Cell cell : cells){
            int numberOfCells = countNeighbours(cell);
            if (numberOfCells == 2 || numberOfCells == 3) {
                nextGenCells.add(cell);
            }
            possibleCells.addAll(aroundCell(cell));
        }
        return possibleCells;
    }

    private Set<Cell> aroundCell(Cell cell) {
        Set<Cell> neighbourCells = new HashSet<>();
        for (int i = 0; i < neighbours.length; i++) {
            Cell nextCell = new Cell(cell.getxAxis() + neighbours[i][0], cell.getyAxis() + neighbours[i][1]);
            neighbourCells.add(nextCell);
        }
        return neighbourCells;
    }

    private int countNeighbours(Cell cell) {
        int count = 0;

        for (int i = 0; i < neighbours.length; i++) {
            Cell nextCell = new Cell(cell.getxAxis() + neighbours[i][0], cell.getyAxis() + neighbours[i][1]);
            if (cells.contains(nextCell)) {
                count++;
            }
        }
        return count;
    }

    public boolean hasMoreCell() {
        return !cells.isEmpty();
    }

    public void print() {
        int minX, maxX, minY, maxY;
        minX = minY = 0;
        maxX = maxY = 3;

        for (Cell c : cells) {
            if (c.getxAxis() < minX) {
                minX = c.getxAxis();
            }
            if (c.getxAxis() > maxX) {
                maxX = c.getxAxis();
            }
            if (c.getyAxis() < minY) {
                minY = c.getyAxis();
            }
            if (c.getyAxis() > maxY) {
                maxY = c.getyAxis();
            }
        }

        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                if (cells.contains(new Cell(x, y))) {
                    System.out.print('*');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println("...");
        }
        System.out.println("----------------------");
    }
}
