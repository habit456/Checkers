package com.joshuakaplan.utility;

import com.joshuakaplan.Color;
import com.joshuakaplan.Move;
import com.joshuakaplan.functional.Game;
import com.joshuakaplan.objects.Board;
import com.joshuakaplan.objects.Checker;
import com.joshuakaplan.objects.Player;
import com.joshuakaplan.objects.Square;

public class MoveHandler {
    private MoveCheck moveCheck;
    private Board board;
    private Game game;

    public MoveHandler(Board board, Game game) {
        this.game = game;
        this.board = board;
        this.moveCheck = new MoveCheck(board, true);
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

        Checker captured = middleSquare.getChecker();

        if (captured.getColor() == Color.RED) {
            game.setRedPiecesCaptured(game.getRedPiecesCaptured() + 1);
        } else if (captured.getColor() == Color.BLACK) {
            game.setBlackPiecesCaptured(game.getBlackPiecesCaptured() + 1);
        } else {
            return false;
        }

        game.setPlayerJumped(true);

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

        if (Positions.isLastRow(to)) {
            checker.king();
        }

        return true;
    }
}
