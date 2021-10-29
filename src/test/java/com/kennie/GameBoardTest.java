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

}
