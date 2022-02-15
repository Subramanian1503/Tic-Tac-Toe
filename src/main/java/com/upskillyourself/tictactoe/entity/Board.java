package com.upskillyourself.tictactoe.entity;

public class Board {

    private char player1Symbol;

    private char player2Symbol;

    private char[][] board;

    private int boardSize;

    private int count;

    private static final char CONST_EMPTY = ' ';

    public char getPlayer1Symbol() {
        return player1Symbol;
    }

    public void setPlayer1Symbol(char player1Symbol) {
        this.player1Symbol = player1Symbol;
    }

    public char getPlayer2Symbol() {
        return player2Symbol;
    }

    public void setPlayer2Symbol(char player2Symbol) {
        this.player2Symbol = player2Symbol;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public void print(){
        System.out.println("-------------------");
        for(int row = 0; row < this.boardSize; row++){
            for(int column = 0; column < this.boardSize; column++)
                System.out.print("| "+ this.board[row][column] +" |");
            System.out.println();
        }
        System.out.println("-------------------");
    }

    public Board(char player1Symbol, char player2Symbol, int boardSize) {
        this.player1Symbol = player1Symbol;
        this.player2Symbol = player2Symbol;
        this.boardSize = boardSize;
        this.board = new char[boardSize][boardSize];
        this.count = 0;
        for(int row = 0; row < boardSize; row++)
            for(int column = 0; column < boardSize; column++)
                this.board[row][column] = this.CONST_EMPTY;
    }

    public GameStatus move(char symbol, int x, int y) {
        // validate the coordinates
        if(x < 0 || x >= this.boardSize || y < 0 || y >= this.boardSize || this.board[x][y] != this.CONST_EMPTY)
            return GameStatus.INVALID_MOVE;
        // if valid make the move
        this.board[x][y] = symbol;
        // increase the count
        this.count++;
        // check whether any user wins in row wise
        if(this.board[x][0] == this.board[x][1] && this.board[x][1] == this.board[x][2])
            return symbol == player1Symbol
                    ? GameStatus.PLAYER1WINS
                    : GameStatus.PLAYER2WINS;
        // check whether any user wins in column wise
        if(this.board[0][y] == this.board[1][y] && this.board[1][y] == this.board[2][y])
            return symbol == player1Symbol
                    ? GameStatus.PLAYER1WINS
                    : GameStatus.PLAYER2WINS;
        // check whether any user wins in diagonal wise
        if(this.board[0][0] != this.CONST_EMPTY && this.board[0][0] == this.board[1][1] && this.board[0][0] == this.board[2][2])
            return symbol == player1Symbol
                    ? GameStatus.PLAYER1WINS
                    : GameStatus.PLAYER2WINS;
        if(this.board[0][2] != this.CONST_EMPTY && this.board[0][2] == this.board[1][1] && this.board[2][0] == this.board[1][1])
            return symbol == player1Symbol
                    ? GameStatus.PLAYER1WINS
                    : GameStatus.PLAYER2WINS;
        // check if the count is equal to number of places return DRAW
        if(count == this.boardSize * this.boardSize)
            return GameStatus.DRAW;
        // otherwise return incomplete
        return GameStatus.INCOMPLETE;
    }
}
