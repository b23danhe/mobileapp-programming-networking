package com.example.networking;

public class Mountain {

    private String ID;
    private String name;
    private String type;
    private String company;
    private String location;
    private String category;
    private int size;
    private int cost;

    /*public Mountain() {

        ID="saknar ID";
        name="Saknar namn";
        type="Saknar type";
        category="category";
        location="Saknar plats";
        heightInMeters=-1;
        heightInFeet=-1;
    }

    public Mountain(String i, String n, String t, String c, String l, int hm, int hf) {
        ID=i;
        name=n;
        type=t;
        company=c;
        location=l;
        heightInMeters=hm;
        heightInFeet=hf;
    }

    public void setName(String n){
        name=n;
    }

    public String getName(){
        return name;
    }*/

    @Override
    public String toString() {
        return name;
    }
}
