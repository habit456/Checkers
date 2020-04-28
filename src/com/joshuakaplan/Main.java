package com.joshuakaplan;

import com.joshuakaplan.objects.Player;
import com.joshuakaplan.utility.CheckerMover;
import com.joshuakaplan.objects.Board;
import com.joshuakaplan.utility.Boards;
import com.joshuakaplan.utility.MoveCheck;

public class Main {

    public static void main(String[] args) {
        Board board = Boards.initialize();
        CheckerMover cm = new CheckerMover(board);
//        cm.move("A3", "b6");
//        Player player = new Player("Josh", Color.RED);
//        MoveCheck moveCheck = new MoveCheck(board);
        board.print();
    }
}
