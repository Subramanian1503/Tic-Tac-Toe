package com.upskillyourself.tictactoe.entity;

public class Tictactoe {

    private Player player1;

    private Player player2;

    private Board board;

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Tictactoe(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
    }
}
