package com.example.kyle.awesomesauce;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.TabHost;
        import android.widget.Toast;

public class TabActivity extends AppCompatActivity {
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        TabHost host = (TabHost) findViewById(R.id.tabHost1);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Summary");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Summary");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Destination");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Destination");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Your Car(s)");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Your Car(s)");
        host.addTab(spec);
        //Tab 4
        spec = host.newTabSpec("Road Map");
        spec.setContent(R.id.tab4);
        spec.setIndicator("Road Map");
        host.addTab(spec);
        //Tab 5
        spec = host.newTabSpec("Checklist");
        spec.setContent(R.id.tab5);
        spec.setIndicator("Checklist");
        host.addTab(spec);
        ListView listView;
        String[] checklist = {"sunscreen", "mom", "dad", "brother", "pants", "shirt", "toothpaste"};
        CheckListAdapter adapter = new CheckListAdapter(this, checklist);
        listView = (ListView) findViewById(R.id.check_list_view);
        listView.setAdapter(adapter);
        Button button = (Button) findViewById(R.id.check_list_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "This is my Toast message!",
                        Toast.LENGTH_LONG).show();
            }
        });


    }
}
