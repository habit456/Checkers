package com.joshuakaplan.objects;

import com.joshuakaplan.utility.BoardPrinter;

import java.util.List;

public class Board {
    private List<Square> board;
    private int rowCount = 8;
    private int columnCount = 8;
    private BoardPrinter boardPrinter;

    public Board(List<Square> board) {
        this.board = board;
        this.boardPrinter = new BoardPrinter(this);
    }

    public List<Square> getBoard() {
        return board;
    }

    public void setBoard(List<Square> board) {
        this.board = board;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    @Override
    public String toString() {
        return boardPrinter.toString();
    }

    public void print() {
        boardPrinter.print();
    }
}
