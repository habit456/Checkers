package com.joshuakaplan.utility;


import com.joshuakaplan.objects.Board;
import com.joshuakaplan.objects.Square;

import java.util.List;

/**
 * Utility class for Board related methods.
 */
public class Boards {
    private static final int rowCount = 8;
    private static final int columnCount = 8;

    public static Board initialize() {
        return BoardInitializer.initialize();
    }

    public static Square getSquare(List<Square> board, String position) {
        position = position.toUpperCase();

        for (Square square: board) {
            if (square.getPosition().getPosition().equals(position)) {
                return square;
            }
        }

        return null;
    }
}
