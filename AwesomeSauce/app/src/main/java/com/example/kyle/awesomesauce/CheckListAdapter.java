package com.example.kyle.awesomesauce;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Kyle on 3/30/2018.
 */

public class CheckListAdapter extends ArrayAdapter {
    //to reference the Activity
    private final Activity context;

    //the array for demo
    private final String[] checklist = {"sunscreen", "mom", "dad", "brother", "pants", "shirt", "toothpaste"};

    public CheckListAdapter(Activity context, String[] checklist){
        super(context,R.layout.check_list_row, checklist);
        this.context = context;

    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.check_list_row, null, true);

        //Trip trip = this.getItem(position);
        CheckBox checkBoxTitle = (CheckBox) rowView.findViewById(R.id.checkBox);
        checkBoxTitle.setText(checklist[position]);
        return rowView;

    }
}