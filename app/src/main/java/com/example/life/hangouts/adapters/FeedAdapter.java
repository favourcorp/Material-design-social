package com.example.life.hangouts.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.life.hangouts.R;
import com.example.life.hangouts.models.Feed;

import java.util.List;

/**
 * Created by LIFE on 18/07/2018.
 */

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Feed> feeds;
    Context context;
    private static final int TEXT_ONLY = 1;
    private static final int TEXT_IMAGE = 2;

    public FeedAdapter(Context context, List<Feed> feeds) {
        this.context = context;
        this.feeds = feeds;
    }

    @Override
    public int getItemViewType(int position) {
        Feed feed = feeds.get(position);
        if (feed.getImage() == 0) {
            return TEXT_ONLY;
        }else {
            return TEXT_IMAGE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TEXT_ONLY) {
            View view = LayoutInflater.from(context).inflate(R.layout.feed_holder, parent, false);
            return new FeedHolder(view);
        }
        else {
            View view = LayoutInflater.from(context).inflate(R.layout.feed_image_holder, parent, false);
            return new FeedImageHolder(view);
        }
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Feed feed = feeds.get(position);
        if (holder.getItemViewType() == TEXT_ONLY) {
            ((FeedHolder)holder).bind(feed);
        } else if (holder.getItemViewType() == TEXT_IMAGE){
            ((FeedImageHolder)holder).bind(feed);
        }
    }

    class FeedHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView username, content;
        FeedHolder(View view) {
            super(view);
            avatar = (ImageView) view.findViewById(R.id.avatar);
            username = (TextView) view.findViewById(R.id.username);
            content = (TextView) view.findViewById(R.id.content);
        }

        void bind(Feed feed) {
            avatar.setImageResource(feed.getAvatar());
            username.setText(feed.getUsername());
            content.setText(feed.getContent());
        }
    }

    class FeedImageHolder extends RecyclerView.ViewHolder {
        ImageView image, avatar;
        ImageButton menuBtn;
        TextView username, content;
        FeedImageHolder(View view) {
            super(view);
            avatar = (ImageView) view.findViewById(R.id.avatar);
            image = (ImageView) view.findViewById(R.id.image);
            username = (TextView) view.findViewById(R.id.username);
            content = (TextView) view.findViewById(R.id.content);
            menuBtn = (ImageButton)view.findViewById(R.id.menu_btn);
        }

        void bind(Feed feed) {
            avatar.setImageResource(feed.getAvatar());
            image.setImageResource(feed.getImage());
            username.setText(feed.getUsername());
            content.setText(feed.getContent());
            //menuBtn.setOnClickListener();
        }
    }

}
