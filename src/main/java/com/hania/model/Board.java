package com.hania.model;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class Board {

    private static final int EMPTY = 0;
    private static final int CROSS = 1;
    private static final int NOUGHT = 2;

    private int[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        initBoard();
    }

    private void initBoard() {
        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                board[row][col] = EMPTY;
            }
        }
    }

//    private void add
}
