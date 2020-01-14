package com.example.datereminder;

public class Categories {

    private String Name;
    private String Description;
    private boolean Remind;
    private String Color;
    private String RemindTime;
    private int ID;

    public String getName() {
        return this.Name;
    }       //get Name

    public void setName(String Name) {
        this.Name = Name;
    }  //set Name

    public String getDescription() { return this.Description; }   //get Description

    public void setDescription(String Description) { this.Description = Description; }  //set Description

    public boolean getRemind() {
        return this.Remind;
    }       //get Remind

    public void setRemind(boolean Remind){ this.Remind = Remind; }  //set Remind

    public String getColor() { return this.Color; }   //get Color

    public void setColor(String Color) { this.Color = Color; }  //set Color

    public String getRemindTime() { return this.RemindTime; }   //get RemindTime

    public void setRemindTime(String RemindTime) { this.RemindTime = RemindTime; }  //set RemindTime

    public int getID() { return this.ID; }   //get ID

    public void setID(int ID) { this.ID = ID; }  //set ID




    public Categories (String Name, String Description, boolean Remind, String Color, String RemindTime, int ID){     //Constructor
        this.Name = Name;
        this.Description = Description;
        this.Remind = Remind;
        this.Color = Color;
        this.RemindTime = RemindTime;
        this.ID = ID;
    }
}
