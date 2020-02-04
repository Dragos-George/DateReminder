package com.example.datereminder.Model;

public class Categories {

    private int ID;
    private String Name;
    private String Description;
    private int RemindTime;             //it should be string
    private int NotificationDate;
    private String Color;



    public Categories() {
    }

    public Categories(int ID, String name, String description, int remindTime, int notificationDate, String color) {
        this.ID = ID;
        Name = name;
        Description = description;
        RemindTime = remindTime;
        NotificationDate = notificationDate;
        Color = color;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getRemindTime() {
        return RemindTime;
    }

    public void setRemindTime(int remindTime) {
        RemindTime = remindTime;
    }

    public int getNotificationDate() {
        return NotificationDate;
    }

    public void setNotificationDate(int notificationDate) {
        NotificationDate = notificationDate;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
