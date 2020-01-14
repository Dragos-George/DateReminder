package com.example.datereminder.Model;

public class DateItem {

    private long Date;
    private String Name;
    private String Description;
    private int ID;



    public long getDate() {
        return this.Date;
    }       //get Date

    public void setDate(long Date) {
        this.Date = Date;
    }  //set Date



    public String getName() { return this.Name; }   //get Name

    public void setName(String Name) { this.Name = Name; }  //set Name

    public String getDescription() {
        return this.Description;
    }       //get Description

    public void setDescription(String Description) { this.Description = Description; }  //set Description

    public int getID() {
        return this.ID;
    }       //get ID

    public void setID(int ID) { this.ID = ID; }  //set ID






    public DateItem(long Date, String Name, String Description, int ID){     //Constructor
        this.Date = Date;
        this.Name = Name;
        this.Description = Description;
        this.ID = ID;

    }
}
