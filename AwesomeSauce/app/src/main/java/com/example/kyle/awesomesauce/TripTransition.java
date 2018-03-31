package com.example.kyle.awesomesauce;

import android.os.Parcel;
import android.os.Parcelable;
//import org.apache.commons.lang3.StringUtils;

/**
 * Created by Kyle on 3/30/2018.
 */

public class TripTransition implements Parcelable {
    private String tripTitle;
    private String destination;
    private String car;

    public TripTransition() {
        tripTitle = "";
        destination = "";
        car = "";
    }

    public TripTransition(Trip trip){
        this.tripTitle = trip.getTripTitle();
        this.destination = trip.getDestination();
        this.car = trip.getCar();
    }

    public TripTransition(Parcel tripTransitionParcel){
        this.tripTitle = tripTransitionParcel.readString();
        this.destination = tripTransitionParcel.readString();
        this.car = tripTransitionParcel.readString();
    }

    public String getTripTitle(){
        return tripTitle;
    }

    public String getDestination(){
        return destination;
    }

    public String getCar(){
        return car;
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

    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeString(this.tripTitle);
        destination.writeString(this.destination);
        destination.writeString(this.car);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<TripTransition> CREATOR = new Parcelable.Creator<TripTransition>() {
        public TripTransition createFromParcel(Parcel tripTransitionParcel) {
            return new TripTransition(tripTransitionParcel);
        }

        public TripTransition[] newArray(int size) {
            return new TripTransition[size];
        }
    };
}
