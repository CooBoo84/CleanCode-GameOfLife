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
}
