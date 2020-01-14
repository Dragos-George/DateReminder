package com.example.datereminder;

public class UserSettings {

    private String Theme;
    private String NotificationTime;
    private String Accounts;

    public String getTheme() {
        return this.Theme;
    }       //get

    public void setTheme(String Theme) {
        this.Theme = Theme;
    }  //set



    public String getNotificationTime() { return this.NotificationTime; }   //get

    public void setNotificationTime(String NotificationTime) { this.NotificationTime = NotificationTime; }  //set

    public String getAccounts() {
        return this.Accounts;
    }       //get

    public void setAccounts(String Accounts) {
        this.Accounts = Accounts;
    }  //set



    public UserSettings(String Theme, String NotificationTime, String Accounts){     //Constructor
        this.Theme = Theme;
        this.NotificationTime = NotificationTime;
        this.Accounts = Accounts;
    }

}
