package com.example.raymond.httprequest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Shon on 5/6/2016.
 */
public class CustomListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Line> lineItems;


    public CustomListAdapter(Activity activity, List<Line> lineItems) {
        this.activity = activity;
        this.lineItems = lineItems;
    }


    @Override
    public int getCount() {
        return lineItems.size();
    }

    @Override
    public Object getItem(int location) {
        return lineItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.cell, null);


        TextView server = (TextView) convertView.findViewById(R.id.server);
        TextView port = (TextView) convertView.findViewById(R.id.port);
        TextView username = (TextView) convertView.findViewById(R.id.username);
        TextView password = (TextView) convertView.findViewById(R.id.password);


        Line m = lineItems.get(position);


        server.setText(m.getServer());


       port.setText("port: " + String.valueOf(m.getPort()));
        username.setText(m.getUsername());


        password.setText(m.getPassword());

        return convertView;
    }
}
