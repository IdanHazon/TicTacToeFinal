package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IView {
private Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter  = new Presenter(this);
    }

    @Override
    public void updateView(int row, int col, char player) {//פעולה שמעדכת את לוח המשחק
        String strID = "button"+row+col;
        int resID = getResources().getIdentifier(strID, "id", getPackageName());
        Button b = findViewById(resID);
        b.setText(""+player);
    }

    @Override
    public void displayMessage(String message) {//פעולה שמעדכנת אם יש מנצח

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Button b = findViewById(R.id.start_button);
        b.setText("restart");//כפתור ההתחלה משנה את הטקסט
        b.setEnabled(true);
        de_activate_buttons(false);
    }
    public void userMove(View view) {
        //1
        Button button = (Button)view;//מצביע לעצם שנלחץ
        String str = button.getResources().getResourceEntryName(button.getId());//השגת הID
        //חילוץ השורה והטור דרך האיידי
        int row= str.charAt(str.length()-2)-48;//להמיר מקוד ASCII
        int col= str.charAt(str.length()-1)-48;
        presenter.moveFromUser(row,col);


    }
    public void start(View view){//כפתור התחלה/ריסטארט
        Button button = (Button)view;
        String buttonText = button.getText().toString();

        if (buttonText.equals("Start")){//אם זה כפתור התחלה
            de_activate_buttons(true);//הפעל כפתורים
            button.setText("ongoing");//שנה את הטקסט
            button.setEnabled(false);//כפתור לא פעיל
        }
        else{//אם זה כפתור רסטארט
            presenter.restart();
            de_activate_buttons(true);
            clear_buttons();
            //פתיחה של הפרוייקט מחדש
        }


    }
    public void de_activate_buttons(boolean status){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int resID = getResources().getIdentifier("button"+i+j, "id", getPackageName());
                Button btn = (Button) findViewById(resID);
                btn.setEnabled(status);
            }
        }
    }
    public void clear_buttons(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int resID = getResources().getIdentifier("button"+i+j, "id", getPackageName());
                Button btn = (Button) findViewById(resID);
                btn.setText("\u0000");
            }
        }
    }
}