package com.example.clee.androidwearhackathon;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by clee on 1/10/15.
 */
public class SubwayTab extends Activity {

    private GetMbtaData test = new GetMbtaData();
    private Spinner line_spinner, location_spinner;

    callAPI get_routes_call = new callAPI();
    EditText testing;
    String color_line;
    String line_string;
    JSONObject line_json;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.subway_tab);
        setLineSpinner();
        setRadioListener();
        get_routes_call.execute(new String[]{""});
        testing = (EditText) findViewById(R.id.testviewjson);

    }

    public void setLineSpinner() {
        line_spinner = (Spinner) findViewById(R.id.lineSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.subways, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        line_spinner.setAdapter(adapter);

    }

    public void setRadioListener() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                setUpLocationSpinner();
            }
        });
    }

    public void StringToJson() {
        try {
            line_json = new JSONObject(line_string);
        } catch (Throwable t) {
        }
    }

    public String getLineId() {
        StringToJson();
        try {
            JSONArray mode = line_json.getJSONArray("mode");
            int mode_length = mode.length();

            for (int i = 0; i < mode_length; i++) {

                JSONObject line_type = mode.getJSONObject(i);
                if (line_type.getString("mode_name").equals("Subway")) {
                    JSONArray line_type_routes = line_type.getJSONArray("route");


                    int line_type_routes_length = line_type_routes.length();
                    for (int j = 0; j < line_type_routes_length; j++) {
                        JSONObject route = line_type_routes.getJSONObject(j);
                        if (route.getString("route_name").equals(color_line)) {
                            return route.getString("route_id");
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setUpLocationSpinner() {
        color_line = line_spinner.getSelectedItem().toString();
        String line_id = getLineId();
        testing.setText(line_id);


        location_spinner = (Spinner) findViewById(R.id.locationSpinner);
        List<String> list = new ArrayList<String>();
        list.add(color_line);
        list.add("list 2");
        list.add("list 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location_spinner.setAdapter(dataAdapter);
        location_spinner = (Spinner) findViewById(R.id.locationSpinner);
        location_spinner.setOnItemSelectedListener(new SpinnerListener());
    }


    public class callAPI extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... arg0) {
            try {
                return test.getRoutes();
            } catch (IOException e) {
                testing.setText("Cannot get data");
                return "err";
            }

        }

        @Override
        protected void onPostExecute(String result) {
            line_string = result;
        }

    }


}
