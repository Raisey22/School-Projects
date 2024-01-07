package com.example.birdmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Settings extends AppCompatActivity {
    Spinner metricDropDown, maxDistanceSpinner;

    Button logoutbtn, updatebtn;


    ImageButton backbtn;

    String metricChoice, DistanceChoice;

    ArrayAdapter adapter1;

    ArrayAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //metrics array
        String metrics[] = {"KM", "Miles"};

        //landmark types array
        String Distance[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        metricDropDown = findViewById(R.id.metricSpinner);

        maxDistanceSpinner = findViewById(R.id.maxDistanceSpinner);

        logoutbtn = findViewById(R.id.logoutbtn);

        backbtn = findViewById(R.id.goback);

        updatebtn = findViewById(R.id.updatebtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, UserHome.class));
            }
        });

        //user click log out button
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        //metrics drop down adapter
        adapter1 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, metrics);

        metricDropDown.setAdapter(adapter1);

        //landmark drop down adapter
        adapter2 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Distance);

        maxDistanceSpinner.setAdapter(adapter2);

        //when a item has been clicked on the metrics drop down list
        metricDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //we get the metric they want/prefer and save it under their account so we can use it to filter their map
                metricChoice = metrics[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //when a item has been clicked on the landmark type drop down list
        maxDistanceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                DistanceChoice = Distance[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        maxDistanceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //get the preferred choice
                DistanceChoice = Distance[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, MainActivity.class));
            }
        });
    }
}


