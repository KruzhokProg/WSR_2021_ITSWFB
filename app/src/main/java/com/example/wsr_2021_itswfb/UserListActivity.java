package com.example.wsr_2021_itswfb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class UserListActivity extends AppCompatActivity {

    RecyclerView rv;
    UserAdapter adapter;
    DataBaseHelper db;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        rv = findViewById(R.id.rvUsers);
        db = new DataBaseHelper(this);
        adapter = new UserAdapter(this, db.getUsers());
        rv.setAdapter(adapter);
    }

    public void exitClick(View view) {
        sharedPref = getSharedPreferences("myInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("email", "");
        editor.apply();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}