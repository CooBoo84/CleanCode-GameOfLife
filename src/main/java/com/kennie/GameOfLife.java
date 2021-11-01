package com.kennie;

public class GameOfLife {
    private int[][] initCells = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
    };

    public void run() throws InterruptedException {
        GameBoard gameBoard = new GameBoard();
        initGameBoard(gameBoard);
        int n = 0;
        while (gameBoard.hasMoreCell()) {
            System.out.println("| GENERATION " +n +"|");
            gameBoard.print();

            gameBoard.nextGeneration();

            Thread.sleep(1000L);
            ++n;
        }
    }

    private void initGameBoard(GameBoard gameBoard) {
        for (int y = 0; y < initCells.length; y++) {
            for (int x = 0; x < initCells[0].length; x++) {
                if (initCells[y][x] == 1) {
                    gameBoard.addCell(x, y);
                }
            }
        }
    }
}

