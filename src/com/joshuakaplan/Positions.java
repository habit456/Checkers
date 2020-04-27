package com.joshuakaplan;

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
}