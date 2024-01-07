package com.example.birdmap;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.birdmap.AppReviews;

import java.util.Calendar;

public class BookingForm extends AppCompatActivity {
    String[] item = {"1 bedroom", "2 bedroom", "3 bedroom", "4", "5", "6", "7"};
    String[] item1 = {"Pretoria CBD", "Pretoria East", "Pretoria West", "Rosebank", "Sunnyside", "Mamelodi", "Soshanguve"};


    private EditText nameEditText, dateEditText, timeEditText;
    private Button bookNowButton;
    ArrayAdapter<String> adapterItems;

    DatePickerDialog.OnDateSetListener setListener;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_form);


        nameEditText = findViewById(R.id.bookingName);
        timeEditText = findViewById(R.id.bookingTime);
        bookNowButton = findViewById(R.id.bookNowButton);
        dateEditText = findViewById(R.id.bookingDate);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        BookingForm.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        String s1 = "/" + year;
                        String s = s1;
                        String date = day + "/" + month + "/" + year;
                        dateEditText.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();

            }
        });


        bookNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String date = dateEditText.getText().toString();
                String time = timeEditText.getText().toString();

                bookNowButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(BookingForm.this, AppReviews.class);
                        startActivity(intent);
                    }
                });
            }
        });}}

