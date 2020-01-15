package com.example.datereminder.Model;

public class Categories {

    private String Name;
    private String Description;
    private boolean Remind;
    private String Color;
    private String RemindTime;
    private int ID;

    public Categories() {
    }

    public Categories(String name, String description, boolean remind, String color, String remindTime, int ID) {
        Name = name;
        Description = description;
        Remind = remind;
        Color = color;
        RemindTime = remindTime;
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

    public boolean isRemind() {
        return Remind;
    }

    public void setRemind(boolean remind) {
        Remind = remind;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getRemindTime() {
        return RemindTime;
    }

    public void setRemindTime(String remindTime) {
        RemindTime = remindTime;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
