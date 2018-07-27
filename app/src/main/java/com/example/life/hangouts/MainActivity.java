package com.example.life.hangouts;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.life.hangouts.adapters.FeedAdapter;
import com.example.life.hangouts.models.Feed;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerView;//from the main activity layout
    LinearLayoutManager layoutManager; //implementing a linearlayout manager
    FeedAdapter adapter;//the feed adapter
    List<Feed> feeds;//feed controller

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, NewEvent.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setupRecyclerView();
        populate();
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
    }

    private void setupRecyclerView() {
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        feeds = new ArrayList<>();
        adapter = new FeedAdapter(this, feeds);
        recyclerView.setAdapter(adapter);
    }

    private void populate () {
        Feed feed = new Feed();
        feed.setContent("ffdfff hgf ghd  dj hjdhg d d gd jg d gd gdg d");
        feed.setUsername("johnson");
        feed.setAvatar(R.drawable.pic2);
        feeds.add(feed);

        Feed feed1 = new Feed();
        feed1.setContent("ffdfff hgf ghd  dj hjdhg d d gd jg d gd gdg d");
        feed1.setUsername("johnson");
        feed1.setAvatar(R.drawable.s5);
        feed1.setImage(R.drawable.s9);
        feeds.add(feed1);

        Feed feed2 = new Feed();
        feed2.setContent("Started: This event occurs when you start dragging an item in a layout, your application callsstartDrag() method to tell the system to start a drag. The arguments inside startDrag() method provide the data to be dragged, metadata for this data, and a callback for drawing the drag shadow.\n" +
                "The system first responds");
        feed2.setUsername("johnson");
        feed2.setAvatar(R.drawable.s7);
        feeds.add(feed2);
        Feed feed3 = new Feed();
        feed3.setContent("Started: This event occurs when you start dragging an item in a layout, your application callsstartDrag() method to tell the system to start a drag. The arguments inside startDrag() method provide the data to be dragged, metadata for this data, and a callback for drawing the drag shadow.\n" +
                "The system first responds");
        feed3.setUsername("johnson");
        feed3.setAvatar(R.drawable.s10);
        feeds.add(feed3);

        Feed feed4 = new Feed();
        feed4.setContent("Started: This event occurs when you start dragging an item in a layout, your application callsstartDrag() method to tell the system to start a drag. The arguments inside startDrag() method provide the data to be dragged, metadata for this data, and a callback for drawing the drag shadow.\n" +
                "The system first responds");
        feed4.setUsername("johnson");
        feed4.setAvatar(R.drawable.s7);
        feed4.setImage(R.drawable.pic2);
        feeds.add(feed4);
        Feed feed5 = new Feed();
        feed5.setContent("Started: This event occurs when you start dragging an item in a layout, your application callsstartDrag() method to tell the system to start a drag. The arguments inside startDrag() method provide the data to be dragged, metadata for this data, and a callback for drawing the drag shadow.\n" +
                "The system first responds");
        feed5.setUsername("johnson");
        feed5.setAvatar(R.drawable.pic5);
        feeds.add(feed5);
        feed.setContent("Started: This event occurs when you start dragging an item in a layout, your application callsstartDrag() method to tell the system to start a drag. The arguments inside startDrag() method provide the data to be dragged, metadata for this data, and a callback for drawing the drag shadow.\n" +
                "The system first responds");
        feed.setUsername("johnson");
        feed.setAvatar(R.drawable.s7);
        feed.setImage(R.drawable.people);
        feeds.add(feed);
        feed.setContent("ffdfff hgf ghd  dj hjdhg d d gd jg d gd gdg d");
        feed.setUsername("johnson");
        feed.setAvatar(R.drawable.s10);
        feed.setImage(R.drawable.pic5);
        feeds.add(feed);
        feed.setContent("ffdfff hgf ghd  dj hjdhg d d gd jg d gd gdg d");
        feed.setUsername("johnson");
        feed.setAvatar(R.drawable.s7);
        feeds.add(feed);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Approved) {

            Intent intent = new Intent(MainActivity.this, Approved_Invitation.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.events) {
            Intent intent = new Intent(MainActivity.this, Events.class);
            startActivity(intent);
        } else if (id == R.id.pending) {
            Intent intent = new Intent(MainActivity.this, Pending.class);
            startActivity(intent);
        } else if (id == R.id.settings) {
            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);
        } else if (id == R.id.following) {
            Intent intent = new Intent(MainActivity.this, Following.class);
            startActivity(intent);
        } else if (id == R.id.followers) {
            Intent intent = new Intent(MainActivity.this, Followers.class);
            startActivity(intent);
        }else if (id == R.id.logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
