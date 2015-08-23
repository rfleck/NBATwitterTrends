package com.rfleck.nbatwittertrends;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import twitter4j.*;
import twitter4j.api.HelpResources;
import twitter4j.conf.ConfigurationBuilder;

public class Results extends AppCompatActivity {
    private List<Tweet> tweetList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TextView textView = (TextView) findViewById(R.id.TextViewTeamSelected);
        String team = getIntent().getStringExtra("selectedTeam");
        textView.setText(team);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("RqlUQCwM74N1SANupS6CIkFRL")
                .setOAuthConsumerSecret("i7PmqWktcdHWnrwKb7VwJpib5eexHsvZB1P2MJhLP3CZZNYrVQ")
                .setOAuthAccessToken("105468503-xBNi3KE5HgoeRuFMioyVHDEbLeSrTnj631I5TQwn")
                .setOAuthAccessTokenSecret("4BZaNreXgFC8soth2oElb5zcdBYpRjbJhBITgJreI9OE5");

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try {
            Query query = new Query(team);
            query.setCount(30);
            //query.setResultType(Query.ResultType.popular);
            query.setResultType(Query.ResultType.recent);
            //query.setResultType(Query.ResultType.mixed);

            QueryResult result;
            result = twitter.search(query);

            List<Status> tweets = result.getTweets();

            for (Status tweet : tweets) {
                String tweetImageURL = null;
                MediaEntity[] media = tweet.getMediaEntities();
                for(MediaEntity m : media){
                    tweetImageURL = m.getMediaURL();
                }
                tweetList.add(new Tweet("FROM: @" + tweet.getUser().getScreenName() + " - DATE: " + tweet.getCreatedAt().toString(), tweet.getText(), tweetImageURL));
                //tweetList.add(new Tweet(tweet.getSource() + " - " + tweet.getUser().getScreenName() + " - " + tweet.getCreatedAt().toString(), tweet.getText(), tweetImageURL));
            }

        } catch (TwitterException te) {
            te.printStackTrace();
            Toast.makeText(Results.this, "Failed to search tweets: " + te.getMessage(), Toast.LENGTH_LONG).show();
            alertView("Failed to search tweets: " + te.getMessage());
        }

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

    private void alertView(String message ) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("ALERT !" )
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                    }
                }).show();
    }
}
