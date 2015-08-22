package com.rfleck.nbatwittertrends;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by rfleck on 8/4/2015.
 */

public class TeamListAdapter extends BaseAdapter {

    private Context context;
    private final List<NBATeam> teams;

    public TeamListAdapter(Context context, List<NBATeam> teams) {
        super();
        this.context = context;
        this.teams = teams;
    }

    @Override
    public int getCount() {
        return teams != null ? teams.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return teams.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapter_team, parent, false);

        TextView name = (TextView) view.findViewById(R.id.nameTeam);
        ImageView logo = (ImageView) view.findViewById(R.id.imgTeam);
        NBATeam team = teams.get(position);

        name.setText(team.getTeamCity() + " " + team.getTeamName());
        logo.setImageResource(team.getTeamLogo());

        return view;
   }
}