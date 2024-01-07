package com.example.birdmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UserHome extends AppCompatActivity {
    ImageView userimg, homeimg, favimg, searchimg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        searchimg = findViewById(R.id.searchimg);
        userimg = findViewById(R.id.userimg);
        homeimg = findViewById(R.id.homeimg);
        favimg = findViewById(R.id.favimg);

        userimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserHome.this, Settings.class));
            }
        });
        homeimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(UserHome.this, BookingForm.class));
            }
        });

        favimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserHome.this, BirdObservations.class));
            }
        });

        searchimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserHome.this, MainActivity.class));
            }
        });
    }
}
