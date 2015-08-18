package com.rfleck.nbatwittertrends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Results extends AppCompatActivity {
    private List<Tweet> tweetList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TextView textView = (TextView) findViewById(R.id.TextViewTeamSelected);
        String team = getIntent().getStringExtra("selectedTeam");
        textView.setText(team);

        tweetList.add(new Tweet("User Bla Bla ", "Text Bla Bla Bla", R.drawable.bulls));
        tweetList.add(new Tweet("User Bla Bla ", "Text Bla Bla Bla", R.drawable.rockets));
        tweetList.add(new Tweet("User Bla Bla ", "Text Bla Bla Bla", R.drawable.spurs));

        ListView listView = (ListView) findViewById(R.id.ListViewSearchResults);
        listView.setAdapter(new TweetListAdapter(this, tweetList));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
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
}
