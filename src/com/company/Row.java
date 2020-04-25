package com.company;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Square> row;
    private int number;
    private int squareCount = 8;

    public Row(List<Square> row, int number, int squareCount) {
        this.row = row;
        this.number = number;
        this.squareCount = squareCount;
    }

    public List<Square> getRow() {
        return row;
    }

    public void setRow(List<Square> row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSquareCount() {
        return squareCount;
    }

    public void setSquareCount(int squareCount) {
        this.squareCount = squareCount;
    }
}
