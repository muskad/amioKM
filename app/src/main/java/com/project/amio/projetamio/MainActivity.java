package com.project.amio.projetamio;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomListAdapter adaptedList;
    private List sensorList;
    private Button refreshButton;
    private Button settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sensorList = new ArrayList<Sensor>();

        getValues();

        adaptedList = new CustomListAdapter(this, sensorList);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adaptedList);


        refreshButton = (Button)findViewById(R.id.button_refresh);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();

                adaptedList.notifyDataSetChanged();
            }
        });

        settingsButton = (Button)findViewById(R.id.button_settings);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class );
                startActivity(intent);

            }
        });
    }

    private void getValues() {

        sensorList.clear();

        Random r = new Random();
        Double n1 = 1 + (200 - 1) * r.nextDouble();
        Double n2 = 1 + (200 - 1) * r.nextDouble();

        sensorList.add(new Sensor("sensor 1", n1));
        sensorList.add(new Sensor("sensor 2", n2));

    }


}
