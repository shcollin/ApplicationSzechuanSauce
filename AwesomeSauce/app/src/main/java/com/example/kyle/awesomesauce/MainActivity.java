package com.example.kyle.awesomesauce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Trip> tripArrayList;

    String[] titleArray = {"Trip 1", "Trip 2", "Trip 3"};

    String[] destinationArray = {"Phoenix, AZ", "Fayetteville, AR", "Tulsa, OK"};

    String[] carArray = {"Chevy Cruze", "Ford Focus", "Honda Fit"};

    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tripArrayList = new ArrayList<Trip>();

        for(int i = 0; i < 3; i++){
            tripArrayList.add(new Trip());
            tripArrayList.get(i).setTripTitle("Trip " + i);
            tripArrayList.get(i).setDestination("Fayetteville, AR");
            tripArrayList.get(i).setCar("Ford Focus");
        }
        TitleListAdapter adapter = new TitleListAdapter(this, tripArrayList);

        listView = (ListView) findViewById(R.id.trips_list_view);
        listView.setAdapter(adapter);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(), TabActivity.class);

                intent.putExtra(getString(R.string.intent_string), new TripTransition((Trip) listView.getItemAtPosition(position)));

                startActivity(intent);
            }
        });
    }
}