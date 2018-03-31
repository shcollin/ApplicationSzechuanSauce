package com.example.kyle.awesomesauce;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Kyle on 3/30/2018.
 */

public class TitleListAdapter extends ArrayAdapter<Trip> {
    //to reference the Activity
    private final Activity context;

    public TitleListAdapter(Activity context, ArrayList<Trip> trip){
        super(context,R.layout.trip_list_row, trip);

        this.context = context;

    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.trip_list_row, null, true);

        Trip trip = this.getItem(position);
        TextView tripTitle = (TextView) rowView.findViewById(R.id.list_title);
        TextView destination = (TextView) rowView.findViewById(R.id.list_destination);
        TextView car = (TextView) rowView.findViewById(R.id.list_car);

        tripTitle.setText(trip.getTripTitle());

        destination.setText(trip.getDestination());
        car.setText(trip.getCar());
        return rowView;

    }
}

