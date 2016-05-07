package com.example.raymond.httprequest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shon on 5/5/2016.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        try {
            String jsonArray = getIntent().getStringExtra("json");
            JSONArray jsonarray = new JSONArray(jsonArray);

            SetAdapterJson(jsonarray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void SetAdapterJson (JSONArray jsonArray) throws JSONException {

        List<Line> lineList = new ArrayList<Line>();
        ListView listView;
        CustomListAdapter adapter;
        listView = (ListView) findViewById(R.id.list);
        adapter = new CustomListAdapter(this, lineList);
        listView.setAdapter(adapter);

        JSONObject jsonobject = jsonArray.getJSONObject(0);
        JSONArray jsonArray1 = jsonobject.getJSONArray("lines");



            for (int i=0;i< jsonArray1.length();i++) {
                JSONObject jsonObject2 = jsonArray1.getJSONObject(i);
                String server = jsonObject2.getString("server");
            String port = jsonObject2.getString("port");
            String username = jsonObject2.getString("username");
            String password = jsonObject2.getString("password");

              Line line = new Line(server, port, username, password);
                lineList.add(line);
            }

            adapter.notifyDataSetChanged();
        }


    }
