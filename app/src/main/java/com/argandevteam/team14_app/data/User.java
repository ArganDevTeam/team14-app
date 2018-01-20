package com.argandevteam.team14_app.data;

/**
 * Created by markc on 20/01/2018.
 */

public class User {
    String name;
    String type;
    int sentitivity;

    public User(String name, String type, int sentitivity) {
        this.name = name;
        this.type = type;
        this.sentitivity = sentitivity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSentitivity() {
        return sentitivity;
    }
}
