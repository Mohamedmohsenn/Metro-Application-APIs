package com.example.metroapp.payload;

public class ChangeWithPasswordRequest {
    private String password;
    private String newAtrr;

    public ChangeWithPasswordRequest(String password, String newAtrr) {
        this.password = password;
        this.newAtrr = newAtrr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewAtrr() {
        return newAtrr;
    }

    public void setNewAtrr(String newAtrr) {
        this.newAtrr = newAtrr;
    }
}
