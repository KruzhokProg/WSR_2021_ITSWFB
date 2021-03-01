package com.example.wsr_2021_itswfb;

public class User {

    private String email;
    private String pass;
    private Integer image;

    public User(String email, String pass, Integer image) {
        this.email = email;
        this.pass = pass;
        this.image = image;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
