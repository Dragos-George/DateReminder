package com.example.datereminder.Model;

public class DateItem {

    private long Date;
    private String Name;
    private String Description;
    private int ID;

    public DateItem() {
    }

    public DateItem(long date, String name, String description, int ID) {
        Date = date;
        Name = name;
        Description = description;
        this.ID = ID;
    }

    public long getDate() {
        return Date;
    }

    public void setDate(long date) {
        Date = date;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
