package model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private String username;
    private String email;
    private String fullname;

    public User() {

    }

    public User(String username, String email, String fullname)    {
        this.username = username;
        this.email = email;
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFullname() {
        return fullname;
    }


    public void setUserName(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


    public String toString() {
        return "Name: '" + this.username + "', Email: '" + this.email + "', Full Name: '" + this.fullname;
    }


}