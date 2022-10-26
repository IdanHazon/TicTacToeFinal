package com.example.tictactoe;

public class Presenter {
    private Model model;
    private IView view;
    public Presenter(IView view){
        model=new Model();
        this.view=view;
    }
    public void moveFromUser(int row, int col)
    {
        // isLegal
        if(model.isLegal(row,col))
        {
            // doMove

            model.doMove(row,col);

            // update view board
            // current player, row col
            view.updateView(row,col,model.getCurrentPlayer());
            // checkWin

             Constants.GAME_STATUS status = model.checkWin();
            if(status == Constants.GAME_STATUS.WIN) {
                view.displayMessage(model.getCurrentPlayer()+" IS THE WINNER");

            }
            else if(status == Constants.GAME_STATUS.ONGOING)
            {
                model.changePlayer();
            }
            else{
                view.displayMessage("ITS A TIE");

            }

        }

    }
    public void restart(){
        model=new Model();

    }
}
