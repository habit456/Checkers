package com.joshuakaplan.utility;

import com.joshuakaplan.Color;
import com.joshuakaplan.objects.Board;
import com.joshuakaplan.objects.Player;
import com.joshuakaplan.objects.Square;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JumpDetector {

    private List<Square> board;
    private MoveCheck moveCheck;

    private static final int[] TOP_LEFT = {-2, 2};
    private static final int[] TOP_RIGHT = {2, 2};
    private static final int[] BOTTOM_LEFT = {-2, -2};
    private static final int[] BOTTOM_RIGHT = {2, -2};

    public JumpDetector(Board board) {
        this(board.getBoard());
    }

    public JumpDetector(List<Square> board) {
        this.board = board;
        this.moveCheck = new MoveCheck(board, false);
    }

    public String[] detectAllJumpsForPlayer(Player player) {
        Color pColor = player.getColor();
        List<String> possibleMoves = new ArrayList<>();

        for (Square square: board) {
            if (!square.isEmpty()) {
                if (square.getChecker().getColor() == pColor) {
                    String[] moves = detect(square.getPosition().getPosition(), player);

                    if (moves.length > 0) {
                        possibleMoves.addAll(Arrays.asList(moves));
                    }
                }
            }
        }

        return possibleMoves.toArray(new String[0]);
    }

    public String[] detect(String at, Player player) {
        List<String> moves = new ArrayList<>();

        List<int[]> positions = List.of(TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT);

        positions.forEach(a -> {
            String to = Positions.toPosition(Positions.calculateSum(at, a));
            if (moveCheck.check(player, at, to)) {
                moves.add(at + " " + to);
            }
        });

        return moves.toArray(new String[0]);
    }
}
