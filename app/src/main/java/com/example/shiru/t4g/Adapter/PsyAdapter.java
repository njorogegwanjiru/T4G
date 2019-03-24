package com.example.shiru.t4g.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shiru.t4g.MessageActivity;
import com.example.shiru.t4g.Model.User;
import com.example.shiru.t4g.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PsyAdapter extends RecyclerView.Adapter<PsyAdapter.ViewHolder> {
    private Context mContext;
    private List<User> mUsers;


    public PsyAdapter(Context mContext, List<User> mUsers)
    {
        this.mUsers=mUsers;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public PsyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.psy_item,parent,false);
        return new PsyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PsyAdapter.ViewHolder holder, int position) {
        final User user = mUsers.get(position);

        holder.name.append(user.getUsername());

        holder.desc.setText("Description: " + user.getUserdesc());

        if (user.getImageURL().equals("default")){
            holder.pic.setImageResource(R.drawable.pp);
        }else {
            Glide.with(mContext).load(user.getImageURL()).into(holder.pic);
        }

        holder.chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MessageActivity.class);
                intent.putExtra("userid", user.getId());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return mUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView name;
        public TextView desc;
        public ImageButton chat;
        public CircleImageView pic;


        public  ViewHolder(View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.docdescription);
            chat = itemView.findViewById(R.id.chat);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
