package com.joshuakaplan.utility;

import com.joshuakaplan.Color;
import com.joshuakaplan.objects.Player;
import com.joshuakaplan.objects.Position;
import com.joshuakaplan.objects.Square;

import java.util.Arrays;
import java.util.List;

/**
 * Helper methods for translating and validating positions
 */
public class Positions {

    /**
     * Returns if position is a valid position or not.
     * For example, "A1" -> true. "7G" -> false.
     * @param position - String of length 2
     * @return boolean
     */
    public static boolean isValid(String position) {
        if (position.length() != 2) {
            return false;
        }

        position = position.toUpperCase();

        if (!isValidColumn(position.charAt(0))) {
            return false;
        }

        if (!isValidRow(position.charAt(1))) {
            return false;
        }

        return true;
    }

    private static boolean isValidColumn(char c) {
        switch (c) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
                return true;
            default:
                return false;
        }
    }

    private static boolean isValidRow(char c) {
        switch (c) {
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
                return true;
            default:
                return false;
        }
    }

    public static boolean isLastColumn(Position position) {
        return position.getPosition().contains("H");
    }

    public static boolean isLastRow(Square square) {
        Color playerColor = square.getChecker().getColor();
        String position = square.getPosition().getPosition();
        int row = toArray(position)[1];

        if (playerColor == Color.BLACK) {
            return row == 8;
        }

        if (playerColor == Color.RED) {
            return row == 1;
        }

        return false;
    }

    /**
     * Instantiates new Position object with valid String parameter.
     * @param position - String of length 2
     * @return new Position if valid, null if not valid.
     */
    public static Position of(String position) {
        if (isValid(position)) {
            return new Position(position.toUpperCase());
        }

        return null;
    }

    public static int columnToInt(String column) {
        switch (column) {
            case "A":
                return 1;
            case "B":
                return 2;
            case "C":
                return 3;
            case "D":
                return 4;
            case "E":
                return 5;
            case "F":
                return 6;
            case "G":
                return 7;
            case "H":
                return 8;
            default:
                return -1;
        }
    }

    public static String intToColumn(int num) {
        switch (num) {
            case 1:
                return "A";
            case 2:
                return "B";
            case 3:
                return "C";
            case 4:
                return "D";
            case 5:
                return "E";
            case 6:
                return "F";
            case 7:
                return "G";
            case 8:
                return "H";
            default:
                return null;
        }
    }

    public static String toPosition(int column, int row) {
        return intToColumn(column) + row;
    }

    public static String toPosition(int[] position) {
        return toPosition(position[0], position[1]);
    }

    public static int[] toArray(String position) {
        return new int[] {columnToInt(position.substring(0, 1)), Integer.parseInt(position.substring(1, 2))};
    }

    public static int[] calculateDifference(String from, String to, boolean isAbsolute) {
        int[] fromArr = toArray(from);
        int[] toArr = toArray(to);

        return calculateDifference(fromArr, toArr, isAbsolute);
    }

    public static int[] calculateDifference(int[] arr1, int[] arr2, boolean isAbsolute) {
        int[] difference = new int[2];
        difference[0] = arr1[0] - arr2[0];
        difference[1] = arr1[1] - arr2[1];

        if (isAbsolute) {
            difference[0] = Math.abs(difference[0]);
            difference[1] = Math.abs(difference[1]);
        }

        return difference;
    }

    public static int[] calculateSum(int[] arr1, int[] arr2) {
        int[] result = new int[2];
        result[0] = arr1[0] + arr2[0];
        result[1] = arr1[1] + arr2[1];
        return result;
    }

    public static Square getMiddleSquare(String from, String to, List<Square> board) {
        int[] difference = Positions.calculateDifference(from, to, false);
        return getMiddleSquare(difference, from, board);
    }

    private static Square getMiddleSquare(int[] difference, String from, List<Square> board) {
        difference[0] = difference[0] * -1;
        difference[1] = difference[1] * -1;

        int[] halfDifference = new int[] {difference[0] / 2, difference[1] / 2};
        int[] fromArr = Positions.toArray(from);
        int[] middlePositionArray = Positions.calculateSum(halfDifference, fromArr);
        String middlePosition = Positions.toPosition(middlePositionArray);
        return Boards.getSquare(board, middlePosition);
    }
}
