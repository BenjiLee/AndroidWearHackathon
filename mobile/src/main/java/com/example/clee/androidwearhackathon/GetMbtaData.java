package com.example.clee.androidwearhackathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetMbtaData {

    public String getData() throws IOException {
        String response = getMbtaResponse();
        return response;
    }

    public String getMbtaResponse() throws IOException {
        URL url = new URL("http://realtime.mbta.com/developer/api/v2/stopsbylocation?api_key=wX9NwuHnZU2ToO7GmGR9uw&lat=42.346961&lon=-71.076640&format=json");
        URLConnection conn = url.openConnection();
        // Get the response
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
        return "none";
    }
}