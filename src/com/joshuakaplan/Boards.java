package com.joshuakaplan;


import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for Board related methods.
 */
public class Boards {
    private static final int rowCount = 8;
    private static final int columnCount = 8;

    public static Board initialize() {
        List<Position> positions = generatePositionList();
        List<Square> squares = generateSquareList(positions);
        return new Board(squares);
    }

    private static List<Position> generatePositionList() {
        List<Position> positions = new ArrayList<>();

        for (int i = 1; i <= rowCount; i++) {
            for (int j = 1; j <= columnCount; j++) {
                String position = Positions.intToColumn(j) + i;
                positions.add(Positions.of(position));
            }
        }

        return positions;
    }

    private static List<Square> generateSquareList(List<Position> positions) {
        List<Square> squares = new ArrayList<>();

        for (Position position: positions) {
            Square square = new Square(Color.WHITE, position, null);
            squares.add(square);
        }

        setBlackSquares(squares);
        setCheckers(squares);

        return squares;
    }

    private static void setBlackSquares(List<Square> squares) {
        for (Square square: squares) {
            int column = Positions.columnToInt(square.getPosition().column());
            int row = square.getPosition().row();

            boolean bothEven = column % 2 == 0 && row % 2 == 0;
            boolean bothOdd = column % 2 == 1 && row % 2 == 1;
            if (bothEven || bothOdd) {
                square.setColor(Color.BLACK);
            }
        }
    }

    private static void setCheckers(List<Square> squares) {
        setBlackCheckers(squares);
        setRedCheckers(squares);
    }

    private static void setBlackCheckers(List<Square> squares) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 8; j++) {
                boolean bothEven = i % 2 == 0 && j % 2 == 0;
                boolean bothOdd = i % 2 == 1 && j % 2 == 1;

                if (bothEven || bothOdd) {
                    int index = ((i - 1) * 8) + (j - 1);
                    squares.get(index).setChecker(new Checker(Color.BLACK, false));
                }
            }
        }
    }

    private static void setRedCheckers(List<Square> squares) {
        for (int i = 6; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                boolean bothEven = i % 2 == 0 && j % 2 == 0;
                boolean bothOdd = i % 2 == 1 && j % 2 == 1;

                if (bothEven || bothOdd) {
                    int index = ((i - 1) * 8) + (j - 1);
                    squares.get(index).setChecker(new Checker(Color.RED, false));
                }
            }
        }
    }

    public static Square getSquare(List<Square> board, String position) {
        for (Square square: board) {
            if (square.getPosition().getPosition().equals(position)) {
                return square;
            }
        }

        return null;
    }
}
