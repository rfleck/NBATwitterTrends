package com.rfleck.nbatwittertrends;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rfleck on 8/4/2015.
 */

public class TweetListAdapter extends BaseAdapter {

    private Context context;
    private final List<Tweet> tweets;

    public TweetListAdapter(Context context, List<Tweet> tweets) {
        super();
        this.context = context;
        this.tweets = tweets;
    }

    @Override
    public int getCount() {
        return tweets != null ? tweets.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return tweets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapter_tweet, parent, false);

        TextView user = (TextView) view.findViewById(R.id.user);
        TextView text = (TextView) view.findViewById(R.id.text);

        ImageView image = (ImageView) view.findViewById(R.id.image);

        Tweet tweet = tweets.get(position);

        user.setText(tweet.getUser());
        text.setText(tweet.getText());

        Picasso.with(context)
                .load(tweet.getImageURL())
                .into(image);
        return view;
    }
}