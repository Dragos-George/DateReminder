package com.example.datereminder.Model;

public class DateItem {

    private int ID;
    private String Name;
    private String Description;
    private int Categories_ID;
    private int Year;
    private int Month;
    private int Day;


    public DateItem() {
    }

    public DateItem(int ID, String name, String description, int categories_ID, int year, int month, int day) {
        this.ID = ID;
        Name = name;
        Description = description;
        Categories_ID = categories_ID;
        Year = year;
        Month = month;
        Day = day;
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

    public int getCategories_ID() {
        return Categories_ID;
    }

    public void setCategories_ID(int categories_ID) {
        Categories_ID = categories_ID;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }
}
