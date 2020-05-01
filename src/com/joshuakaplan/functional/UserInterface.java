package com.joshuakaplan.functional;

import com.joshuakaplan.Color;
import com.joshuakaplan.objects.Player;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Player player1;
    private Player player2;
    private Game game;

    private Player currentPlayer;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        welcome();
        initialize();
        playGame();
        endGame();
    }

    private void welcome() {
        System.out.println("Welcome to Checkers 1.0");
        System.out.println("By Joshua Kaplan");
    }

    private String getInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private void initialize() {
        initializePlayers();
        initializeGame();
    }

    private void initializePlayers() {
        String player1Name = getInput("Player 1: Please enter your name: ");
        player1 = new Player(player1Name, Color.BLACK);

        String player2Name = getInput("Player 2: Please enter your name: ");
        player2 = new Player(player2Name, Color.RED);
    }

    private void initializeGame() {
        game = new Game(player1, player2);
    }

    private void getPlayerMove() {
        while (true) {
            System.out.println("~~" + currentPlayer + "~~");
            String from = getInput("From: ");
            String to = getInput("To: ");

            if (game.tryMove(from, to, currentPlayer)) {
                game.setLastFrom(from);
                game.setLastTo(to);
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private void changePlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    private void playGame() {
        currentPlayer = player1;
        while (!game.isGameOver()) {
            game.getBoard().print();
            getPlayerMove();

            if (game.getPlayerJumped()) {
                game.setPlayerJumped(false);
                String[] moves = game.getDetector().detect(game.getLastTo(), currentPlayer);
                if (moves.length == 0) {
                    changePlayer();
                }
            } else {
                changePlayer();
            }
        }
    }

    private void endGame() {
        System.out.println("Congratulations to " + game.getWinningPlayer() + "!");
        System.out.println("You won!");
    }
}
