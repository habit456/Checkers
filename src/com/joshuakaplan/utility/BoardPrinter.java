package com.joshuakaplan.utility;

import com.joshuakaplan.objects.Board;
import com.joshuakaplan.objects.Square;

import java.util.ArrayList;
import java.util.List;

public class BoardPrinter {
    // state variables
    private int rowCount;
    private int columnCount;
    private int squareWidth;
    private int squareHeight;
    private int leftBorderSpacing; // blank lines between row numbers and board
    private int bottomBorderSpacing; // blank lines between column letters and board

    // references
    private List<Square> board;
    private List<String> rows;

    public BoardPrinter(Board board) {
        this(board.getRowCount(), board.getColumnCount(), 6,
                2, board.getBoard(), 5, 1);
    }

    private BoardPrinter(int rowCount, int columnCount, int squareWidth, int squareHeight, List<Square> board,
                         int leftBorderSpacing, int bottomBorderSpacing) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.squareWidth = squareWidth;
        this.squareHeight = squareHeight;
        this.board = board;
        this.leftBorderSpacing = leftBorderSpacing;
        this.bottomBorderSpacing = bottomBorderSpacing;
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        rows = new ArrayList<>();

        for (int row = 1; row <= rowCount; row++) {
            constructRow(row);
        }

        addExtras();

        return constructBoard();
    }

    private void constructRow(int row) {
        for (int line = 1; line <= squareHeight; line++) {
            rows.add(constructLine(row, line));
        }
    }

    private String constructLine(int row, int line) {
        StringBuilder sb = new StringBuilder();

        for (int column = 1; column <= columnCount; column++) {
            sb.append(constructColumnLine(column, row, line));
        }

        return sb.toString();
    }

    private String constructColumnLine(int column, int row, int line) {
        StringBuilder sb = new StringBuilder();

        for (int point = 1; point <= squareWidth; point++) {
            sb.append(constructPoint(column, row, line, point));
        }

        return sb.toString();
    }

    private String constructPoint(int column, int row, int line, int point) {
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

    private void addExtras() {
        addLastRow();
        addLastColumn();
        addColumnLetters();
        addRowNumbers();
    }

    private void addLastRow() {
        int length = rows.get(0).length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append("#");
        }

        rows.add(sb.toString());
    }

    private void addLastColumn() {
        for (int i = 0; i < rows.size(); i++) {
            String line = rows.get(i);
            line += "#\n";
            rows.set(i, line);
        }
    }

    private void addColumnLetters() {
        addBlankLines();

        int length = rows.get(0).length();
        StringBuilder sb = new StringBuilder();
        for (int column = 1; column <= columnCount; column++) {
            sb.append(columnLettersSection(column));
        }

        sb.append("\n");
        rows.add(0, sb.toString());
    }

    private void addBlankLines() {
        for (int numLines = 0; numLines < bottomBorderSpacing; numLines++) {
            addBlankLine();
        }
    }

    private String columnLettersSection(int column) {
        StringBuilder sb = new StringBuilder();

        for (int point = 1; point <= squareWidth; point++) {
            if (point == getHalfPoint(squareWidth)) {
                sb.append(Positions.intToColumn(column));
            } else {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    private void addBlankLine() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows.get(0).length(); i++) {
            sb.append(" ");
        }

        sb.append("\n");
        rows.add(0, sb.toString());
    }

    private void addRowNumbers() {
        String spaces = getSpacing();
        int lastIndex = rows.size() - 1;

        formatExtraLines(spaces); // formats extra bottom lines
        formatRows(spaces);
        rows.set(lastIndex, spaces + rows.get(lastIndex)); // formats extra top line
    }

    private void formatRows(String spaces) {
        for (int row = 1; row <= rowCount; row++) {
            rowNumbersSection(row, spaces);
        }
    }

    private String getSpacing() {
        StringBuilder sb = new StringBuilder();

        for (int spaces = 0; spaces < leftBorderSpacing; spaces++) {
            sb.append(" ");
        }

        return sb.toString();
    }

    private void formatExtraLines(String spaces) {
        for (int line = 0; line < bottomBorderSpacing + 1; line++) {
            String currentLine = rows.get(line);
            rows.set(line, spaces + currentLine);
        }
    }

    private void rowNumbersSection(int row, String spaces) {
        for (int line = 1; line <= squareHeight; line++) {
            formatRowLine(row, spaces, line);
        }
    }

    private void formatRowLine(int row, String spaces, int line) {
        int halfPoint = getHalfPoint(squareHeight);
        String add;

        // add = "   " or "1  " (if spaces = "   ")
        if (line == halfPoint) {
            add = row + spaces.substring(0, spaces.length() - 1);
        } else {
            add = spaces;
        }

        // linesPerRow * currentRow + currentLine + bottomExtraLines
        int index = (squareHeight * (row - 1) + (line - 1)) + bottomBorderSpacing + 1;
        rows.set(index, add + rows.get(index));
    }

    private String constructBoard() {
        StringBuilder sb = new StringBuilder();

        for (int i = rows.size() - 1; i >= 0; i--) {
            sb.append(rows.get(i));
        }

        return sb.toString();
    }
}
