package com.firstapp.joel.recyclerview;

/**
 * Created by joel on 11/9/2017.
 */
public class ListItem {

    private String heading;
    private String desc;
    private String image_url;
    private String dob;
    private String country;
    private String spouse;


    public String getHeading() {
        return heading;
    }

    public String getDesc() {
        return desc;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getDob(){ return dob;}

    public String getCountry(){ return country;}

    public String getSpouse(){ return spouse;}

    public ListItem(String heading, String desc, String dob, String country, String spouse, String image_url) {
        this.heading = heading;
        this.desc = desc;
        this.dob = dob;
        this.country = country;
        this.spouse = spouse;
        this.image_url= image_url;


    }
}
