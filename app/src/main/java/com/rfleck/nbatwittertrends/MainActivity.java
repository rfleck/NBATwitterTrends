package com.rfleck.nbatwittertrends;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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

        /*
        if (!OSUtil.IsNetworkAvailable(getApplicationContext())) {
            AlertMessageBox.Show(MainActivity.this, "Internet connection", "A valid internet connection can't be established", AlertMessageBox.AlertMessageBoxIcon.Info);
            return;
        }

        if (StringUtil.isNullOrWhitespace(ConstantValues.TWITTER_CONSUMER_KEY) || StringUtil.isNullOrWhitespace(ConstantValues.TWITTER_CONSUMER_SECRET)) {
            AlertMessageBox.Show(MainActivity.this, "Twitter oAuth infos", "Please set your twitter consumer key and consumer secret", AlertMessageBox.AlertMessageBoxIcon.Info);
            return;
        }
        */

        //Button buttonSearch = (Button) findViewById(R.id.bSearch);
        //buttonSearch.setOnClickListener(this);

        teamsList.add(new NBATeam("Chicago ", "Bulls", R.drawable.bulls));
        teamsList.add(new NBATeam("Houston ", "Rockets", R.drawable.rockets));
        teamsList.add(new NBATeam("San Antonio ", "Spurs", R.drawable.spurs));

        ListView listView = (ListView) findViewById(R.id.ListViewTeams);
        listView.setAdapter(new TeamListAdapter(this, teamsList));
        listView.setOnItemClickListener(this);

        TextView textView = (TextView) findViewById(R.id.footerMsg);
        textView.setText("App Loaded - Select the Team");
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
        NBATeam teamSelected = teamsList.get(position);
        Toast.makeText(this, teamSelected.getTeamCity() + teamSelected.getTeamName() + " Selected !", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,Results.class);
        i.putExtra("selectedTeam",teamSelected.getTeamCity() + teamSelected.getTeamName());
        startActivity(i);
    }
}
