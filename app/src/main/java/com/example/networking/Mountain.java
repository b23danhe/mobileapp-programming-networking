package com.example.networking;

public class Mountain {

    private String ID;
    private String name;
    private String type;
    private String location;
    private int heightInMeters;
    private int heightInFeet;

    public Mountain() {

        ID="saknar ID";
        name="Saknar namn";
        type="Saknar type";
        location="Saknar plats";
        heightInMeters=-1;
        heightInFeet=-1;
    }

    public Mountain(String i, String n, String t, String l, int hm, int hf) {
        ID=i;
        name=n;
        type=t;
        location=l;
        heightInMeters=hm;
        heightInFeet=hf;
    }

}
