package com.joshuakaplan;

import com.joshuakaplan.objects.Player;
import com.joshuakaplan.utility.CheckerMover;
import com.joshuakaplan.objects.Board;
import com.joshuakaplan.utility.Boards;
import com.joshuakaplan.utility.MoveCheck;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board board = Boards.initialize();
        Player player1 = new Player("Josh", Color.BLACK);
        Player player2 = new Player("AI", Color.RED);
        MoveCheck moveCheck = new MoveCheck(board);
        CheckerMover checkerMover = new CheckerMover(board);

        Scanner scanner = new Scanner(System.in);
        board.print();
        Player currentPlayer = player1;

        while (true) {
            System.out.print("Where from? ");
            String from = scanner.nextLine();
            System.out.print("Where to? ");
            String to = scanner.nextLine();

            if (moveCheck.check(currentPlayer, from, to)) {
                checkerMover.move(from, to);
                currentPlayer = currentPlayer == player1 ? player2 : player1;
                board.print();
            } else {
                System.out.println("Invalid move");
            }
        }
    }
}
