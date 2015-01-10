package com.example.clee.androidwearhackathon;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.clee.androidwearhackathon.GetMbtaData;

import java.io.IOException;

/**
 * Created by clee on 1/10/15.
 */
public class SubwayTab extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.subway_tab);

        TextView testing = (TextView) findViewById(R.id.testviewjson);
        GetMbtaData test = new GetMbtaData();
        try {
            testing.setText(test.getData());
        } catch (IOException e) {
            testing.setText("Cannot get data");
        }
    }
}
