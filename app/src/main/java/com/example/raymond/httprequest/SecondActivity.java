package com.example.raymond.httprequest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Shon on 5/5/2016.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        try {
            JSONObject json = new JSONObject(getIntent().getStringExtra("json"));
            String server = json.getString("server");
            String port = json.getString("port");
            String username = json.getString("username");
            String password = json.getString("password");
            EditText editText1 = (EditText)findViewById(R.id.editText1);
            editText1.setText("server");
            EditText editText2 = (EditText)findViewById(R.id.editText2);
            editText2.setText(server);
            EditText editText3 = (EditText)findViewById(R.id.editText3);
            editText3.setText("port");
            EditText editText4 = (EditText)findViewById(R.id.editText4);
            editText4.setText(port);
            EditText editText5 = (EditText)findViewById(R.id.editText5);
            editText5.setText("username");
            EditText editText6 = (EditText)findViewById(R.id.editText6);
            editText6.setText(username);
            EditText editText7 = (EditText)findViewById(R.id.editText7);
            editText7.setText("password");
            EditText editText8 = (EditText)findViewById(R.id.editText8);
            editText8.setText(password);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
