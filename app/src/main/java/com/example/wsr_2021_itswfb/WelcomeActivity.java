package com.example.wsr_2021_itswfb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    ImageView imgv;
    TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        imgv = findViewById(R.id.imageItem);
        tvEmail = findViewById(R.id.tvItemEmail);

        String email = getIntent().getExtras().getString("email");
        Integer image = getIntent().getExtras().getInt("image");

        tvEmail.setText(email);
        imgv.setImageResource(image);

    }
}