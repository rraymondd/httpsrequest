package com.example.raymond.httprequest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton();
    }

    public void LoginButton() {
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);
        int counter = 5;
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (username.getText().toString().equals("user") && password.getText().toString().equals("pass")) {

                            RequestToServer(username.getText().toString(), password.getText().toString());

                        }
                    }

                }
        );
    }

    public void RequestToServer(final String user, final String pass) {

        final Handler mHandler = new Handler();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url = "http://102.reachme.com/sms";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {

                            @Override
                            public void onResponse(final String response) {

                                Handler handler = new Handler(Looper.getMainLooper());
                                handler.post(new Runnable() {

                                    @Override
                                    public void run() {
                                        try {
                                            JSONObject json = new JSONObject(response);
                                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                            intent.putExtra("json", json.toString());
                                            startActivity(intent);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    protected Map<String, String> getParams() {
                        Map<String, String> MyData = new HashMap<>();
                        MyData.put("username", user);
                        MyData.put("password", pass);
                        return MyData;
                    }
                };
                queue.add(stringRequest);
            }
        });

        thread.start();
    }
}




