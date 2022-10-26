package com.example.tictactoe;

public interface IView {
    void updateView(int row, int col, char player);
    void displayMessage(String message);

}
