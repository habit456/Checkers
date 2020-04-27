package com.joshuakaplan;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Square> board;
    int rowCount = 8;
    int columnCount = 8;

    public Board(List<Square> board) {
        this.board = board;
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

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        int squareWidth = 6;
        int squareHeight = 4;


        for (int row = 1; row <= rowCount; row++) {
            constructRow(list, row, squareWidth, squareHeight);
        }

        addExtras(list);

        String board = constructBoard(list);

        return board;
    }

    private void constructRow(List<String> list, int row, int squareWidth, int squareHeight) {
        for (int line = 1; line <= squareHeight; line++) {
            list.add(constructLine(row, squareWidth, line, squareHeight));
        }
    }

    private String constructLine(int row, int squareWidth, int line, int squareHeight) {
        StringBuilder sb = new StringBuilder();

        for (int column = 1; column <= columnCount; column++) {
            sb.append(constructColumnLine(column, row, squareWidth, line, squareHeight));
        }

        return sb.toString();
    }

    private String constructColumnLine(int column, int row, int squareWidth, int line, int squareHeight) {
        StringBuilder sb = new StringBuilder();

        for (int point = 1; point <= squareWidth; point++) {
            sb.append(constructPoint(column, row, line, point, squareHeight, squareWidth));
        }

        return sb.toString();
    }

    private String constructPoint(int column, int row, int line, int point, int squareHeight, int squareWidth) {
        if (line == 1) {
            return "#";
        }

        if (point == 1) {
            return "#";
        }

        int halfHeight = getHalfPoint(squareHeight);
        int halfWidth = getHalfPoint(squareWidth);

        if (line == halfHeight && point == halfWidth) {
            String position = Positions.toPosition(column, row);
            Square square = Boards.getSquare(board, position);

            assert square != null;
            return square.toString();
        }

        return " ";
    }

    private int getHalfPoint(int length) {
        return (length / 2) + 1;
    }

    private void addExtras(List<String> list) {
        addLastRow(list);
        addLastColumn(list);
    }

    private void addLastRow(List<String> list) {
        int length = list.get(0).length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append("#");
        }

        list.add(sb.toString());
    }

    private void addLastColumn(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String line = list.get(i);
            line += "#\n";
            list.set(i, line);
        }
    }

    private String constructBoard(List<String> list) {
        StringBuilder sb = new StringBuilder();

        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }

        return sb.toString();
    }
}
