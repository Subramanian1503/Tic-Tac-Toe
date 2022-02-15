package com.upskillyourself.tictactoe.service.impl;

import com.upskillyourself.tictactoe.entity.Board;
import com.upskillyourself.tictactoe.entity.GameStatus;
import com.upskillyourself.tictactoe.entity.Player;
import com.upskillyourself.tictactoe.entity.Tictactoe;
import com.upskillyourself.tictactoe.service.TicTacToeService;

import java.util.Scanner;

public class TicTacToeServiceImpl implements TicTacToeService {

    private Tictactoe tictactoe;

    public void initializeGame() {
        // create player1 and player2
        Scanner sc = new Scanner(System.in);
        Player player1 = getPlayer(sc, "player1");
        Player player2 = getPlayer(sc, "player2");
        // create board
        Board board = new Board(player1.getSymbol(), player2.getSymbol(), 3);
        // create the tictactoe game
        this.tictactoe = new Tictactoe(player1, player2, board);
    }

    private static Player getPlayer(Scanner sc, String playerName) {
        Player player = new Player();
        System.out.println("Enter the name of "+ playerName);
        String name = sc.next();
        player.setName(name);
        System.out.println("Enter the symbol of the "+ playerName);
        String symbol = sc.next();
        player.setSymbol(symbol.charAt(0));
        return player;
    }

    public void startGame() {
        Player player1 = this.tictactoe.getPlayer1();
        Player player2 = this.tictactoe.getPlayer2();
        Board board = this.tictactoe.getBoard();
        GameStatus status;
        boolean player1Turn = true;
        Scanner sc = new Scanner(System.in);
        do{
            if(player1Turn){
                // print the Player turn with player 1 name
                System.out.println("Player-1 "+ player1.getName() +"'s turn to move !!");
                // print Enter x
                System.out.println("Enter x");
                int x = sc.nextInt();
                // print Enter y
                System.out.println("Enter y");
                int y = sc.nextInt();
                // make move and get status
                status = board.move(player1.getSymbol(), x, y);
                if(status == GameStatus.INVALID_MOVE) {
                    System.out.println("player1 " + player1.getName() + "'s move Invalid");
                    continue;
                }
            }
            else{
                // print the Player turn with player 2 name
                System.out.println("Player-2 "+ player2.getName() +"'s turn to move !!");
                // print Enter x
                System.out.println("Enter x");
                int x = sc.nextInt();
                // print Enter y
                System.out.println("Enter y");
                int y = sc.nextInt();
                // make move and get status
                status = board.move(player2.getSymbol(), x, y);
                if(status == GameStatus.INVALID_MOVE){
                    System.out.println("player2 " + player2.getName() + "move Invalid");
                    continue;
                }
            }
            player1Turn = !player1Turn;
            board.print();
        }while(status == GameStatus.INCOMPLETE || status == GameStatus.INVALID_MOVE);
        sc.close();
        this.tictactoe.setBoard(board);
        if(status == GameStatus.PLAYER1WINS)
            System.out.println("Player1 "+ player1.getName() +" wins !!");
        else if(status == GameStatus.PLAYER2WINS)
            System.out.println("Player2 "+ player2.getName() +" wins !!");
        else
            System.out.println("DRAW !!");
    }
}

