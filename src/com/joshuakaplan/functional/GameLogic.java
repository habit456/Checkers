package com.joshuakaplan.functional;

import com.joshuakaplan.objects.Board;
import com.joshuakaplan.objects.Player;
import com.joshuakaplan.utility.CheckerMover;

/**
 * Contains all of the methods for game behavior such as moving, capturing, checking for wins, etc.
 * This class is the brain of the game.
 * */
public class GameLogic {
    private int redPiecesCaptured;
    private int blackPiecesCaptured;

    private Board board;
    private CheckerMover checkerMover;
    private Player player;


}
