package com.company;

import java.util.List;

public class Board {
    private List<Row> board;
    int rowCount = 8;

    public Board(List<Row> board) {
        this.board = board;
    }

    public List<Row> getBoard() {
        return board;
    }

    public void setBoard(List<Row> board) {
        this.board = board;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public String toString() {
        return "";
    }
}
