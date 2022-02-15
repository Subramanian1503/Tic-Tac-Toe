package com.upskillyourself.tictactoe;

import com.upskillyourself.tictactoe.service.TicTacToeService;
import com.upskillyourself.tictactoe.service.impl.TicTacToeServiceImpl;

public class TictactoeManager {

    public static void main(String args[]){
        TicTacToeService tictactoe = new TicTacToeServiceImpl();
        tictactoe.initializeGame();
        tictactoe.startGame();
    }
}
