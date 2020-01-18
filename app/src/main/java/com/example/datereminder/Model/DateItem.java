package com.example.datereminder.Model;

public class DateItem {

    private long Date;
    private String Name;
    private String Description;
    private int ID;
    private int Color;

    public DateItem() {
    }

    public DateItem(long date, String name, String description, int ID, int color) {
        Date = date;
        Name = name;
        Description = description;
        this.ID = ID;
        Color = color;
    }
    public DateItem (int x, String y, String z ){
        Color = x;
        Name = y;
        Description = z;
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

    public int getColor() {
        return Color;
    }

    public void setColor(int color) {
        Color = color;
    }
}
