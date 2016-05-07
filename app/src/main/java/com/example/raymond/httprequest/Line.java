package com.example.raymond.httprequest;

/**
 * Created by Shon on 5/6/2016.
 */
public class Line {

    public String server;
    public String port;
    public String username;
    public String password;

    public Line(){

    }
    public Line(String server, String port, String username, String password) {
        this.server = server;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getServer() {
        return server;
    }

    public String getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
