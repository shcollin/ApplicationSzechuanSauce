package com.example.kyle.awesomesauce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    String[] titleArray = {"Trip 1", "Trip 2", "Trip 3"};

    String[] destinationArray = {"Phoenix, AZ", "Fayetteville, AR", "Tulsa, OK"};

    String[] carArray = {"Chevy Cruze", "Ford Focus", "Honda Fit"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TitleListAdapter adapter = new TitleListAdapter(this, titleArray, destinationArray, carArray);

        listView = (ListView) findViewById(R.id.trips_list_view);
        listView.setAdapter(adapter);
    }
}