package com.example.life.hangouts.models;

/**
 * Created by LIFE on 18/07/2018.
 */

public class Feed {
    private int image = 0;
    private String username;
    private String content;
    private int avatar;

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getAvatar() {
        return avatar;
    }
}
