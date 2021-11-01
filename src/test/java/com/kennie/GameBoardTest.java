package com.kennie;

import org.junit.Assert;
import org.junit.Test;

public class GameBoardTest {

    @Test
    public void addCell(){
        GameBoard gameBoard = new GameBoard();
        gameBoard.addCell(0,0);

        Assert.assertTrue(gameBoard.isCellAlive(0,0));
    }

    // Rule 1: Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
    @Test
    public void shouldBeDeadByUnderpopulationWhenLiveCellHasFewerThanTwoAliveNeighbours_noNeighbours() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.addCell(0, 0);

        gameBoard.nextGeneration();
        Assert.assertFalse(gameBoard.isCellAlive(0, 0));
    }

    // Rule 1: Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
    @Test
    public void shouldBeDeadByUnderpopulationWhenLiveCellHasFewerThanTwoAliveNeighbours_oneNeighbour() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.addCell(0, 0);
        gameBoard.addCell(1, 0);

        gameBoard.nextGeneration();
        Assert.assertFalse(gameBoard.isCellAlive(0, 0));
    }

    //Rule 2: Any live cell with more than three live neighbours dies, as if by overcrowding.
    @Test
    public void shouldBeDeadByOvercrowdingWhenLiveCellHasMoreThanThreeAliveNeighbours_fourNeighbours() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.addCell(0, 0);
        gameBoard.addCell(1, 0);
        gameBoard.addCell(1, 1);
        gameBoard.addCell(0, 1);
        gameBoard.addCell(-1, 1);

        gameBoard.nextGeneration();
        Assert.assertFalse(gameBoard.isCellAlive(0, 0));

    }

    //Rule 3: Any live cell with two or three live neighbours lives on to the next generation.
    @Test
    public void shouldBeLivingOnToNextGenerationWhenHavingTwoOrThreeAliveNeighbours_twoNeighbours() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.addCell(0, 0);
        gameBoard.addCell(1, 0);
        gameBoard.addCell(1, 1);

        gameBoard.nextGeneration();

        Assert.assertTrue(gameBoard.isCellAlive(0, 0));
    }
}
