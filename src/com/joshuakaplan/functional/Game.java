package com.joshuakaplan.functional;

import com.joshuakaplan.Move;
import com.joshuakaplan.objects.Board;
import com.joshuakaplan.objects.Checker;
import com.joshuakaplan.objects.Player;
import com.joshuakaplan.objects.Square;
import com.joshuakaplan.utility.Boards;
import com.joshuakaplan.utility.MoveCheck;
import com.joshuakaplan.utility.MoveHandler;
import com.joshuakaplan.utility.Positions;

/**
 * Contains all of the methods for game behavior such as moving, capturing, checking for wins, etc.
 * This class is the game.
 * */
public class Game {
    private int redPiecesCaptured;
    private int blackPiecesCaptured;

    private Board board;
    private MoveHandler moveHandler;


}
