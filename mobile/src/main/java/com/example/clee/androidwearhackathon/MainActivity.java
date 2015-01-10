package com.example.clee.androidwearhackathon;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost mTabHost = getTabHost();

        mTabHost.addTab(mTabHost.newTabSpec("Subway").setIndicator("Subway").setContent(new Intent(this  ,SubwayTab.class )));
        mTabHost.addTab(mTabHost.newTabSpec("Bus").setIndicator("Bus").setContent(new Intent(this , DummyTab.class )));
        mTabHost.addTab(mTabHost.newTabSpec("Dummy").setIndicator("Dummy").setContent(new Intent(this , DummyTab.class )));

        mTabHost.setCurrentTab(0);

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
//    @Override
//    public void onConnected(Bundle connectionHint) {
//        // Connected to Google Play services!
//        // The good stuff goes here.
//    }
//
//    @Override
//    public void onConnectionSuspended(int cause) {
//        // The connection has been interrupted.
//        // Disable any UI components that depend on Google APIs
//        // until onConnected() is called.
//    }
//
//    @Override
//    public void onConnectionFailed(ConnectionResult result) {
//        // This callback is important for handling errors that
//        // may occur while attempting to connect with Google.
//        //
//        // More about this in the next section.
//    }
}
