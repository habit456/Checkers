package com.joshuakaplan.utility;

import com.joshuakaplan.Color;
import com.joshuakaplan.Move;
import com.joshuakaplan.objects.Board;
import com.joshuakaplan.objects.Player;
import com.joshuakaplan.objects.Square;

import java.util.ArrayList;
import java.util.List;

public class MoveCheck {
    private List<Square> board;

    private Player player;
    private String from;
    private String to;
    private Square squareFrom;
    private Square squareTo;
    private Move moveType;

    public MoveCheck(List<Square> board) {
        this.board = board;
    }

    public MoveCheck(Board board) {
        this(board.getBoard());
    }

    private void setFields(Player player, String from, String to) {
        Square squareFrom = Boards.getSquare(board, from);
        Square squareTo = Boards.getSquare(board, to);
        Move moveType = getMoveType();

        this.player = player;
        this.from = from;
        this.to = to;
        this.squareFrom = squareFrom;
        this.squareTo = squareTo;
        this.moveType = moveType;
    }

    public boolean check(Player player, String from, String to) {
        if (!Positions.isValid(from)) {
            return false;
        }

        if (!Positions.isValid(to)) {
            return false;
        }

        setFields(player, from, to);

        return checkSquares();
    }

    private boolean checkSquares() {


        if (squareFrom.isEmpty()) {
            return false;
        }

        if (!squareTo.isEmpty()) {
            return false;
        }

        if (squareFrom.getChecker().getColor() != player.getColor()) {
            return false;
        }

        if (squareFrom.getColor() != Color.BLACK) {
            return false;
        }

        if (squareTo.getColor() != Color.BLACK) {
            return false;
        }

        return checkMoveTypes();
    }

    private boolean checkMoveTypes() {


        if (moveType == Move.INVALID) {
            return true;
        }

        if (moveType == Move.SINGLE) {
            return checkSingleMove();
        }

//        if (moveType == Move.DOUBLE) {
//            checkDoubleMove();
//        }

        return false;
    }

    private boolean checkSingleMove() {
        if (squareFrom.getChecker().isKing()) {
            return true;
        } else {
            int[] difference = Positions.calculateDifference(from, to, false);
            return isCorrectDirection(difference);
        }
    }

    private boolean isCorrectDirection(int[] difference) {
        Color pColor = player.getColor();

        if (pColor == Color.RED) {
            return difference[1] > 0;
        }

        if (pColor == Color.BLACK) {
            return difference[1] < 0;
        }

        return false;
    }

    private Move getMoveType() {
        if (!(Positions.isValid(from) && Positions.isValid(to))) {
            return Move.INVALID;
        }

        int[] difference = Positions.calculateDifference(from, to, true);

        return getMove(difference);
    }



    private Move getMove(int[] difference) {
        if (difference[0] == 1 && difference[1] == 1) {
            return Move.SINGLE;
        } else if (difference[0] == 2 && difference[1] == 2) {
            return Move.DOUBLE;
        } else {
            return Move.INVALID;
        }
    }
}
