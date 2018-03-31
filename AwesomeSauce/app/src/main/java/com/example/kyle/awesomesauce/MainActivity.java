package com.example.kyle.awesomesauce;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

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
            tripArrayList.get(i).setTripTitle("Trip " + (i + 1));
            tripArrayList.get(i).setDestination("Fayetteville, AR");
            tripArrayList.get(i).setCar("Ford Focus");
        }

        setList();

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(), TabActivity.class);

                intent.putExtra(getString(R.string.intent_string), new TripTransition((Trip) listView.getItemAtPosition(position)));

                startActivity(intent);
            }
        });
    }

    public void setList(){
        TitleListAdapter adapter = new TitleListAdapter(this, tripArrayList);

        listView = (ListView) findViewById(R.id.trips_list_view);
        listView.setAdapter(adapter);
    }


    public void addNewTrip(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("New Trip");
        LayoutInflater inflater = this.getLayoutInflater();
// Set up the input
        final EditText input = new EditText(this);
        final EditText input2 = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
       // input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        //input2.setInputType(InputType.TYPE_CLASS_TEXT);
        View dialogView = inflater.inflate(R.layout.main_title_dialog, null);
        builder.setView(dialogView);
        //builder.setView(input2);
        final EditText title = (EditText) dialogView.findViewById(R.id.editText);
        final EditText destination = (EditText) dialogView.findViewById(R.id.editText2);
        final EditText car = (EditText) dialogView.findViewById(R.id.editText3);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               tripArrayList.add(new Trip(title.getText().toString(), destination.getText().toString(), car.getText().toString()));

                setList();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


        builder.show();
    }
}