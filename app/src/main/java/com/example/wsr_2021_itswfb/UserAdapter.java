package com.example.wsr_2021_itswfb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    Context context;
    List<UserModel> users;

    public UserAdapter(Context context, List<UserModel> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item, null);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.tvEmail.setText(users.get(position).getEmail());
        holder.tvPass.setText(users.get(position).getPass());
        holder.imgvUser.setImageResource(R.drawable.sell1);
    }

    @Override
    public int getItemCount() {
        if(users != null){
            return users.size();
        }
        else{
            return 0;
        }
    }
}
