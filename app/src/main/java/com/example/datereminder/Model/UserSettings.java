package com.example.datereminder.Model;

public class UserSettings {
    private String Theme;
    private String NotificationTime;
    private String Accounts;

    public UserSettings() {
    }

    public UserSettings(String theme, String notificationTime, String accounts) {
        Theme = theme;
        NotificationTime = notificationTime;
        Accounts = accounts;
    }

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String theme) {
        Theme = theme;
    }

    public String getNotificationTime() {
        return NotificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        NotificationTime = notificationTime;
    }

    public String getAccounts() {
        return Accounts;
    }

    public void setAccounts(String accounts) {
        Accounts = accounts;
    }
}
