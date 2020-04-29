package com.joshuakaplan.utility;

import com.joshuakaplan.Move;
import com.joshuakaplan.objects.Board;
import com.joshuakaplan.objects.Checker;
import com.joshuakaplan.objects.Player;
import com.joshuakaplan.objects.Square;

public class MoveHandler {
    private MoveCheck moveCheck;
    private Board board;
    private Checker lastCheckerCaptured;

    public MoveHandler(Board board) {
        this.board = board;
        this.moveCheck = new MoveCheck(board);
    }

    /**
     * Moves the piece if valid move.
     *
     * @param from Position from which the player is moving
     * @param to Position to which the player is moving
     * @param player The player whose move it is
     * @return boolean - if the move is successful or not
     */
    public boolean tryMove(String from, String to, Player player) {
        if (!moveCheck.check(player, from, to)) {
            return false;
        }


        return handleMove(from, to, player);
    }

    private boolean handleMove(String from, String to, Player player) {
        Move moveType = moveCheck.getMoveType(from, to);

        if (moveType == Move.SINGLE) {
            return handleSingleMove(from, to);
        }

        if (moveType == Move.DOUBLE) {
            return handleDoubleMove(from, to);
        }

        return false;
    }

    private boolean handleSingleMove(String from, String to) {
        return move(from, to);
    }

    private boolean handleDoubleMove(String from, String to) {
        Square middleSquare = Positions.getMiddleSquare(from, to, board.getBoard());
        lastCheckerCaptured = middleSquare.getChecker();
        middleSquare.setChecker(null);
        return move(from, to);
    }

    private boolean move(String from, String to) {
        Square squareFrom = Boards.getSquare(board.getBoard(), from);
        Square squareTo = Boards.getSquare(board.getBoard(), to);

        if (squareFrom != null && squareTo != null) {
            return move(squareFrom, squareTo);
        }

        return false;
    }

    private boolean move(Square from, Square to) {
        Checker checker = from.getChecker();
        from.setChecker(null);
        to.setChecker(checker);
        return true;
    }

    public Checker getLastCheckerCaptured() {
        return lastCheckerCaptured;
    }
}
