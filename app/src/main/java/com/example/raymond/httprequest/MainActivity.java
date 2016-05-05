package com.example.raymond.httprequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import  cz.msebera.android.httpclient.Header;
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

    public void LoginButton(){
        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        button = (Button)findViewById(R.id.button);
        int counter = 5;
        button.setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if (username.getText().toString().equals("user") && password.getText().toString().equals("password")){
                        RequestToServer(username.toString(), password.toString());
                    }
                }

        }
        );
    }

    public void RequestToServer(String user, String pass){
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("username", user);
        params.put("password", pass);
        client.post("https://reachme.com", params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Toast.makeText(MainActivity.this,"success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(MainActivity.this,"fail",Toast.LENGTH_SHORT).show();
            }
        });
}
    }
