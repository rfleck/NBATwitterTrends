package com.rfleck.nbatwittertrends;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private List<NBATeam> teamsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamsList.add(new NBATeam("Portland", "Trail Blazers", R.drawable.blazers));
        teamsList.add(new NBATeam("Milwaukee", "Bucks", R.drawable.bucks));
        teamsList.add(new NBATeam("Chicago", "Bulls", R.drawable.bulls));
        teamsList.add(new NBATeam("Cleveland", "Cavaliers", R.drawable.cavaliers));
        teamsList.add(new NBATeam("Boston", "Celtics", R.drawable.celtics));
        teamsList.add(new NBATeam("Los Angeles", "Clippers", R.drawable.clippers));
        teamsList.add(new NBATeam("Memphis", "Grizzles", R.drawable.grizzles));
        teamsList.add(new NBATeam("Atlanta", "Hawks", R.drawable.hawks));
        teamsList.add(new NBATeam("Miami", "Heat", R.drawable.heat));
        teamsList.add(new NBATeam("Charlotte", "Hornets", R.drawable.hornets));
        teamsList.add(new NBATeam("Utah", "Jazz", R.drawable.jazz));
        teamsList.add(new NBATeam("Sacramento", "Kings", R.drawable.kings));
        teamsList.add(new NBATeam("New York", "Knicks", R.drawable.knicks));
        teamsList.add(new NBATeam("Los Angeles", "Lakers", R.drawable.lakers));
        teamsList.add(new NBATeam("Orlando", "Magic", R.drawable.magic));
        teamsList.add(new NBATeam("Dallas", "Mavericks", R.drawable.mavs));
        teamsList.add(new NBATeam("Brooklyn", "Nets", R.drawable.nets));
        teamsList.add(new NBATeam("Denver", "Nuggets", R.drawable.nuggets));
        teamsList.add(new NBATeam("Indiana", "Pacers", R.drawable.pacers));
        teamsList.add(new NBATeam("New Orleans", "Pelicans", R.drawable.pelicans));
        teamsList.add(new NBATeam("Detroit", "Pistons", R.drawable.pistons));
        teamsList.add(new NBATeam("Toronto", "Raptors", R.drawable.raptors));
        teamsList.add(new NBATeam("Houston", "Rockets", R.drawable.rockets));
        teamsList.add(new NBATeam("Philadelphia", "Seventy Sixers", R.drawable.sixers));
        teamsList.add(new NBATeam("San Antonio", "Spurs", R.drawable.spurs));
        teamsList.add(new NBATeam("Phoenix", "Suns", R.drawable.suns));
        teamsList.add(new NBATeam("Oklahoma City", "Thunder", R.drawable.thunder));
        teamsList.add(new NBATeam("Golden State", "Warriors", R.drawable.warriors));
        teamsList.add(new NBATeam("Washington", "Wizards", R.drawable.wizards));
        teamsList.add(new NBATeam("Minesota", "Timber Wolves", R.drawable.wolves));

        ListView listView = (ListView) findViewById(R.id.ListViewTeams);
        listView.setAdapter(new TeamListAdapter(this, teamsList));
        listView.setOnItemClickListener(this);

        TextView textView = (TextView) findViewById(R.id.footerMsg);
        textView.setText("Ready - Please Select the Team");
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
        //Toast.makeText(this, "Search Button Clicked !", Toast.LENGTH_SHORT).show();
     }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) findViewById(R.id.footerMsg);
        textView.setText("Searching Tweeter - Please Wait...");

        NBATeam teamSelected = teamsList.get(position);
        Toast.makeText(this, teamSelected.getTeamCity() + teamSelected.getTeamName() + " Selected !", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this,Results.class);
        i.putExtra("selectedTeam",teamSelected.getTeamCity() + teamSelected.getTeamName());
        startActivity(i);
    }
}
