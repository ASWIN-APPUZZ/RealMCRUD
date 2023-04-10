package com.example.realmcrud;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DataModel extends RealmObject {

    //variables
    @PrimaryKey //primary for id
    private long id;
    private String c_name;
    private String c_desc;
    private String c_track;
    private String c_dur;

    // Empty Constructor
    public DataModel(){
    }

    //getter and setter


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getC_name() {
        return c_name;
    }
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_desc() {
        return c_desc;
    }
    public void setC_desc(String c_desc) {
        this.c_desc = c_desc;
    }

    public String getC_track() {
        return c_track;
    }
    public void setC_track(String c_track) {
        this.c_track = c_track;
    }

    public String getC_dur() {
        return c_dur;
    }
    public void setC_dur(String c_dur) {
        this.c_dur = c_dur;
    }
}
