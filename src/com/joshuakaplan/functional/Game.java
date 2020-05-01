package com.joshuakaplan.functional;

import com.joshuakaplan.objects.Board;
import com.joshuakaplan.objects.Player;
import com.joshuakaplan.utility.Boards;
import com.joshuakaplan.utility.JumpDetector;
import com.joshuakaplan.utility.MoveHandler;

import java.util.Arrays;

/**
 * Contains all of the methods for game behavior such as moving, capturing, checking for wins, etc.
 * This class is the game.
 * */
public class Game {
    private int redPiecesCaptured;
    private int blackPiecesCaptured;

    private Board board;
    private Player player1;
    private Player player2;
    private MoveHandler moveHandler;
    private JumpDetector detector;

    public Game(Player player1, Player player2) {
        this.board = Boards.initialize();
        this.player1 = player1;
        this.player2 = player2;
        this.moveHandler = new MoveHandler(board, this);
        this.detector = new JumpDetector(board);
    }

    public boolean tryMove(String from, String to, Player player) {
        return moveHandler.tryMove(from, to, player);
    }

    public boolean isGameOver() {
        if (blackPiecesCaptured == 12) {
            return true;
        }

        if (redPiecesCaptured == 12) {
            return true;
        }

        return false;
    }

    public Player getWinningPlayer() {
        Player winner = null;

        if (blackPiecesCaptured == 12) {
            winner = player2;
        }

        if (redPiecesCaptured == 12) {
            winner = player1;
        }

        return winner;
    }

    public int getRedPiecesCaptured() {
        return redPiecesCaptured;
    }

    public void setRedPiecesCaptured(int redPiecesCaptured) {
        this.redPiecesCaptured = redPiecesCaptured;
    }

    public int getBlackPiecesCaptured() {
        return blackPiecesCaptured;
    }

    public void setBlackPiecesCaptured(int blackPiecesCaptured) {
        this.blackPiecesCaptured = blackPiecesCaptured;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
