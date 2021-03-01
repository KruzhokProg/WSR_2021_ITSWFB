package com.example.wsr_2021_itswfb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView tvEmail, tvPass;
    ImageView imgvUser;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        tvEmail = itemView.findViewById(R.id.tvRvItemEmail);
        tvPass = itemView.findViewById(R.id.tvRvItemPass);
    }
}
