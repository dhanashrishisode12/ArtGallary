package com.example.artgallary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class AppointmentForm extends AppCompatActivity implements  View.OnClickListener {
    EditText location,category;
    Button booking;
    String textData = "";
    private ProgressDialog mDialog;

    private DatabaseReference mDatabase;
    ValueEventListener listener;
    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_form);
        mDialog = new ProgressDialog(this);
        location = findViewById(R.id.address);
        //next = findViewById(R.id.nextBtn);
        category = findViewById(R.id.productname);
        booking = findViewById(R.id.saveBtn);
        btnDatePicker=findViewById(R.id.btn_date);
        btnTimePicker=findViewById(R.id.btn_time);
        txtDate=findViewById(R.id.in_date);
        txtTime=findViewById(R.id.in_time);
        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Appointment");
        mDatabase.keepSynced(true);

        /*next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next= new Intent(AppointmentForm.this,RateForApp.class);
                startActivity(next);
            }
        });


         */
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();

            }
        });
    }
    private void addData() {

        String id = mDatabase.push().getKey();
        String address = location.getText().toString();
        String category1 = category.getText().toString();
        String date = txtDate.getText().toString();
        String time = txtTime.getText().toString();

        if(!TextUtils.isEmpty(address)){

            DataAppoint data= new DataAppoint(id,address,category1,date,time);


            mDatabase.child(id).setValue(data);

            mDialog.setMessage("procesing....");
            mDialog.show();

            Intent next= new Intent(AppointmentForm.this,RateForApp.class);
            startActivity(next);

            Toast.makeText(this, " Your Appointment is confirm !Success", Toast.LENGTH_SHORT).show();


        }else{
            Toast.makeText(this, "plese enter valid Servise", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onClick(View v) {
        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }

}

