package com.example.kyle.awesomesauce;

/**
 * Created by Kyle on 3/30/2018.
 */

public class Trip {
    private String tripTitle;
    private String destination;
    private String car;
    public Trip(){
        this.tripTitle = "";
        this.destination = "";
        this.car = "";
    }

    public Trip(String tripTitle, String destination, String car){
        this.tripTitle = tripTitle;
        this.destination = destination;
        this.car = car;
    }

    public Trip(Trip trip){
        this.tripTitle = trip.getTripTitle();
        this.destination = trip.getDestination();
        this.car = trip.getCar();
    }

    public void setTripTitle(String title){
        this.tripTitle = title;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }

    public void setCar(String car){
        this.car = car;
    }

    public String getTripTitle(){
        return this.tripTitle;
    }

    public String getDestination(){
        return this.destination;
    }

    public String getCar(){
        return this.car;
    }
}

