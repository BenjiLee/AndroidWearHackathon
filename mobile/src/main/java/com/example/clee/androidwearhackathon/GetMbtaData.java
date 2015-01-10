package com.example.clee.androidwearhackathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetMbtaData {

    public String getMbtaResponse(String query, String details) throws IOException {
        String base_url = "http://realtime.mbta.com/developer/api/v2/";
        String api_key = "?api_key=wX9NwuHnZU2ToO7GmGR9uw";
        String format = "&format=json";
        String entire_url = base_url + query + api_key + details + format;
        URL url = new URL(entire_url);
        URLConnection conn = url.openConnection();
        // Get the response
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
            return line;
        }
        return "none";
    }
}