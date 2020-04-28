package com.joshuakaplan.utility;

import com.joshuakaplan.objects.Board;
import com.joshuakaplan.objects.Checker;
import com.joshuakaplan.objects.Square;
import com.joshuakaplan.utility.Boards;

import java.util.List;

public class CheckerMover {
    private List<Square> board;

    public CheckerMover(List<Square> board) {
        this.board = board;
    }

    public CheckerMover(Board board) {
        this(board.getBoard());
    }

    public void move(String from, String to) {
        Square squareFrom = Boards.getSquare(board, from);
        Square squareTo = Boards.getSquare(board, to);
        move(squareFrom, squareTo);
    }

    public void move(Square from, Square to) {
        Checker checker = from.getChecker();
        from.setChecker(null);
        to.setChecker(checker);
    }
}
