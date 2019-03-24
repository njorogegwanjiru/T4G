package com.example.shiru.t4g.Model;

public class User {
    private String id;
    private String username;
    private String imageURL;
    private String status;
    private String title;
    private String userdesc;

    public User(String id, String username, String imageURL, String status, String title, String userdesc) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.status = status;
        this.title = title;
        this.userdesc = userdesc;
    }

    public User() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserdesc() {
        return userdesc;
    }

    public void setUserdesc(String userdesc) {
        this.userdesc = userdesc;
    }
}