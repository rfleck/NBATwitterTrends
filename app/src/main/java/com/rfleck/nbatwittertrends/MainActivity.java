package com.rfleck.nbatwittertrends;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSearch = (Button) findViewById(R.id.bSearch);
        buttonSearch.setOnClickListener(this);

        List<NBATeam> teamsList = new ArrayList<>();

        teamsList.add(new NBATeam("Chicago", "Bulls", R.drawable.bulls));
        teamsList.add(new NBATeam("Houston", "Rockets", R.drawable.rockets));
        teamsList.add(new NBATeam("San Antonio", " Spurs", R.drawable.spurs));
        teamsList.add(new NBATeam("Chicago", "Bulls", R.drawable.bulls));
        teamsList.add(new NBATeam("Houston", "Rockets", R.drawable.rockets));
        teamsList.add(new NBATeam("San Antonio", " Spurs", R.drawable.spurs));
        teamsList.add(new NBATeam("Chicago", "Bulls", R.drawable.bulls));
        teamsList.add(new NBATeam("Houston", "Rockets", R.drawable.rockets));
        teamsList.add(new NBATeam("San Antonio", " Spurs", R.drawable.spurs));
        teamsList.add(new NBATeam("Chicago", "Bulls", R.drawable.bulls));
        teamsList.add(new NBATeam("Houston", "Rockets", R.drawable.rockets));
        teamsList.add(new NBATeam("San Antonio", " Spurs", R.drawable.spurs));
        teamsList.add(new NBATeam("Chicago", "Bulls", R.drawable.bulls));
        teamsList.add(new NBATeam("Houston", "Rockets", R.drawable.rockets));
        teamsList.add(new NBATeam("San Antonio", " Spurs", R.drawable.spurs));

        ListView listView = (ListView) findViewById(R.id.ListViewTeams);
        listView.setAdapter(new TeamListAdapter(this, teamsList));
        //listView.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intentOpenResults = new Intent(this, Results.class);
        startActivity(intentOpenResults);
    }

    //@Override
    //public void onItemClick(AdapterView<?> S, View arg1, int pos, long id){
    //    Toast.makeText(this, pos + "Selected", Toast.LENGTH_SHORT).show();
    //}
}
