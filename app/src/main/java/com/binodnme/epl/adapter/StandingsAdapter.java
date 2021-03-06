package com.binodnme.epl.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.binodnme.epl.R;
import com.binodnme.epl.model.ClubStanding;
import com.binodnme.epl.utils.DrawableUtils;

import java.util.List;

/**
 * Created by binodnme on 2/17/16.
 */
public class StandingsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ClubStanding> dataset;

    public StandingsAdapter(){}

    public StandingsAdapter(List<ClubStanding> ds){
        this.dataset = ds;
    }


    public static class StandingsViewHolder extends RecyclerView.ViewHolder{
        public TextView position;
        public ImageView logo;
        public TextView clubName;
        public TextView matchPlayed;
        public TextView goalsFor;
        public TextView goalsAgainst;
        public TextView totalPoints;

        public StandingsViewHolder(View itemView) {
            super(itemView);
            position = (TextView) itemView.findViewById(R.id.position);
            logo = (ImageView) itemView.findViewById(R.id.club_logo);
            clubName = (TextView) itemView.findViewById(R.id.club_name);
            matchPlayed = (TextView) itemView.findViewById(R.id.match_played);
            goalsFor = (TextView) itemView.findViewById(R.id.goals_for);
            goalsAgainst = (TextView) itemView.findViewById(R.id.goals_against);
            totalPoints = (TextView) itemView.findViewById(R.id.points);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.standings, parent, false);
        return new StandingsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        StandingsViewHolder svh = (StandingsViewHolder) holder;
        ClubStanding cs = dataset.get(position);
        Context context = svh.logo.getContext();
        int id = DrawableUtils.getDrawableResourceId(context, cs.getName());

        svh.logo.setImageResource(id == 0 ? R.mipmap.ic_launcher : id);
        svh.position.setText(String.valueOf(cs.getPosition()));
        svh.clubName.setText(cs.getName());
        svh.matchPlayed.setText(String.valueOf(cs.getMatchPlayed()));
        svh.goalsFor.setText(String.valueOf(cs.getGoalsFor()));
        svh.goalsAgainst.setText(String.valueOf(cs.getGoalsAgainst()));
        svh.totalPoints.setText(String.valueOf(cs.getPoints()));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public List<ClubStanding> getDataset() {
        return dataset;
    }

    public void setDataset(List<ClubStanding> dataset) {
        this.dataset = dataset;
        notifyDataSetChanged();
    }
}
