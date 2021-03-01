package com.example.wsr_2021_itswfb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class UserListActivity extends AppCompatActivity {

    RecyclerView rv;
    UserAdapter adapter;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        rv = findViewById(R.id.rvUsers);
        db = new DataBaseHelper(this);
        adapter = new UserAdapter(this, db.getUsers());
        rv.setAdapter(adapter);

    }
}