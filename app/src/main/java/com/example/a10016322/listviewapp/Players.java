package com.example.a10016322.listviewapp;

/**
 * Created by 10016322 on 11/18/2016.
 */
public class Players {
    String name, position, description;
    int jerseyNum, image;

    public Players(String name, int jerseyNum, String position, int image, String description) {
        this.name = name;
        this.jerseyNum = jerseyNum;
        this.position = position;
        this.image = image;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public int getJerseyNum() { return jerseyNum; }
    public String getPosition() {
        return position;
    }
    public int getImage() {
        return image;
    }
    public String getDescription() {
        return description;
    }
}
