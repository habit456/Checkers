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
}
