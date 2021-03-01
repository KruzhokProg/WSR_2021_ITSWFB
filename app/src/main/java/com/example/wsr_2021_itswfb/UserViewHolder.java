package com.example.wsr_2021_itswfb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView tvEmail, tvPass;
    ImageView imgvUser;
    ConstraintLayout itemLayout;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        tvEmail = itemView.findViewById(R.id.tvRvItemEmail);
        tvPass = itemView.findViewById(R.id.tvRvItemPass);
        imgvUser = itemView.findViewById(R.id.imgvUser);
        itemLayout = itemView.findViewById(R.id.layoutItem);
    }
}
