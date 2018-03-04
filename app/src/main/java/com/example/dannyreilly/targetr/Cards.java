package com.example.dannyreilly.targetr;

/**
 * Created by dannyreilly on 2/25/18.
 */

public class Cards {
    private String shsID;
    private String name;
    private String address;
    private float score;
    private String distance;
    private String spec;
    private String callplantarget;
    private String marketrx;
    private String loyal;
    private String favor;


    public Cards (String shsID, String name, String address, float score, String distance, String spec, String callplantarget, String marketrx, String loyal, String favor){
        this.shsID = shsID;
        this.name = name;
        this.address = address;
        this.score = score;
        this.distance = distance;
        this.spec = spec;
        this.callplantarget = callplantarget;
        this.marketrx = marketrx;
        this.loyal = loyal;
        this.favor = favor;
    }

    public String getShsID(){
        return shsID;
    }

    public void setShsID(String shsID){
        this.shsID = shsID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getaddress(){
        return address;
    }

    public void setaddress(String address){
        this.address = address;
    }

    public float getscore(){
        return score;
    }

    public void setscore(float score) {
        this.score = score;
    }

    public String getdistance(){
        return distance;
    }

    public void setdistance(String distance) {
        this.distance = distance;
    }

    public String getspec(){
        return spec;
    }

    public void setspec(String spec) {
        this.spec = spec;
    }

    public String getCallplantarget(){
        return callplantarget;
    }

    public void setCallplantarget(String callplantarget) {
        this.callplantarget = callplantarget;
    }

    public String getMarketrx(){
        return marketrx;
    }

    public void setMarketrx(String marketrx) {
        this.marketrx = marketrx;
    }

    public String getLoyal(){
        return loyal;
    }

    public void setLoyal(String loyal) {
        this.loyal = loyal;
    }

    public String getFavor(){
        return favor;
    }

    public void setFavor(String favor) {
        this.favor = favor;
    }

}
