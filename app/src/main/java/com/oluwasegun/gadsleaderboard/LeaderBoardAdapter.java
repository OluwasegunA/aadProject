package com.oluwasegun.gadsleaderboard;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.oluwasegun.gadsleaderboard.model.SkillIQ;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class LeaderBoardAdapter {
    private List<SkillIQ> topLearnerList = new ArrayList<>();
    private static final String TAG = "LeaderBoardAdapter";
    Context context;

    public LeaderBoardAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int vi){
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.leader_board));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position){
        holder.skillName.setText(topLearnerList.get(position).getName());
        holder.skillScore.setText(MessageFormat.format("{0} Skill IQ Score ,", topLearnerList.get(position).getScore()));
        holder.skillCountry.setText(topLearnerList.get(position).getCountry());
        Glide.with(context).load(topLearnerList.get(position).getBadgeUrl()).into(holder.img);
        Log.d(TAG, "ImageUrl is : " + topLearnerList.get(position).getBadgeUrl());
    }


    public int getItemCount() {
        return topLearnerList.size();
    }

    public void setList(List<SkillIQ> list){
        this.topLearnerList =list;
        notify();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        TextView learnerName, skillHour, learnerCountry;
        ImageView img2;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            img2 = itemView.findViewById(R.id.learnerImg);
            learnerName = itemView.findViewById(R.id.learnerName);
            skillHour = itemView.findViewById(R.id.skillHour);
            learnerCountry = itemView.findViewById(R.id.learnerCountry);
        }
    }

}
