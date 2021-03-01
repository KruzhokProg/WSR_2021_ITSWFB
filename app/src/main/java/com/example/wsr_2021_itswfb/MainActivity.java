package com.example.wsr_2021_itswfb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPass;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);

        db = new DataBaseHelper(this);
    }

    public void btnSignInClick(View view) {
        String email = etEmail.getText().toString();
        String password = etPass.getText().toString();

        Boolean success = db.AuthUser(email,password);
        if(success){
            Intent i = new Intent(this, UserListActivity.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Ошибка входа!", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnSignUpClick(View view) {
        String email = etEmail.getText().toString();
        String password = etPass.getText().toString();

        Boolean success = db.RegUser(email, password);
        if(success){
            Toast.makeText(this, "Успешно зарегистрирован!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Такой пользователь уже существует!", Toast.LENGTH_SHORT).show();
        }

    }
}