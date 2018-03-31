package com.example.kyle.awesomesauce;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Kyle on 3/30/2018.
 */

public class TitleListAdapter extends ArrayAdapter {
    //to reference the Activity
    private final Activity context;

    //to store the list of countries
    private final String[] titleArray;

    //to store the list of countries
    private final String[] destinationArray;

    private final String[] carArray;

    public TitleListAdapter(Activity context, String[] titleArrayParam, String[] destinationArrayParam, String[] carArrayParam){
        super(context,R.layout.trip_list_row, titleArrayParam);

        this.context = context;
        this.titleArray = titleArrayParam;
        this.destinationArray = destinationArrayParam;
        this.carArray = carArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.trip_list_row, null, true);
        TextView tripTitle = (TextView) rowView.findViewById(R.id.list_title);
        TextView destination = (TextView) rowView.findViewById(R.id.list_destination);
        TextView car = (TextView) rowView.findViewById(R.id.list_car);

        tripTitle.setText(titleArray[position]);
        destination.setText(destinationArray[position]);
        car.setText(carArray[position]);
        return rowView;

    }
}
