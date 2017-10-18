package com.kleinkarasu.masjid;

/**
 * Created by Muhammad Azzam on 02/10/2017.
 */

public class User {
    private String nama;
    private String username;

    public User(){}

    public User(String nama, String username) {
        this.nama = nama;
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
