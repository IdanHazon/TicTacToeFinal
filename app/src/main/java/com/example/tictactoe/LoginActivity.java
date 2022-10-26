package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        EditText etEmail= findViewById(R.id.editTextTextEmailAddress);
        String mail= etEmail.getText().toString();
        SharedPreferences sp=this.getSharedPreferences("details",MODE_PRIVATE);
        SharedPreferences.Editor editor= sp.edit();
        editor.putString("email",mail);
        editor.apply();
        sp.getString("email","");

    }
    private void gotoMainActivity(){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}