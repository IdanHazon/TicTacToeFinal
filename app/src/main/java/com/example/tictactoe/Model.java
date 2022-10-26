package com.example.tictactoe;

public class Model {
    private char[][] board;
    private int numTurns;
    private final int ROWS=3,COLS=3;
    private char currentPlayer= 'x';


    public Model(){
    this.numTurns=0;
    this.board= new char[ROWS][COLS];
    }
    public char getCurrentPlayer(){
        return currentPlayer;
    }
    public boolean isLegal(int row,int col){
        return this.board[row][col]=='\u0000';
    }
    public Constants.GAME_STATUS checkWin(){

        int countR=0;
        int counterC=0;


        boolean diagonalL=board[0][0]==board[1][1]&&board[2][2]==board[0][0]&&board[0][0]==currentPlayer;
        boolean diagonalR=board[0][2]==board[1][1]&&board[2][0]==board[0][2]&&board[0][2]==currentPlayer;

        if (diagonalL || diagonalR) return Constants.GAME_STATUS.WIN;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]==currentPlayer)
                    countR++;
                if (board[j][i]==currentPlayer)
                    counterC++;
            }
            if (countR==3||counterC==3) return Constants.GAME_STATUS.WIN;
            countR=0;
            counterC=0;
        }
        if (numTurns==ROWS*COLS)
            return Constants.GAME_STATUS.TIE;
        return Constants.GAME_STATUS.ONGOING;
    }
    public void doMove(int row, int col){
        this.board[row][col]=(char)currentPlayer;
        this.numTurns++;
    }

    public void changePlayer() {
        if (currentPlayer=='x')
            currentPlayer='o';
        else
            currentPlayer='x';
    }
}
