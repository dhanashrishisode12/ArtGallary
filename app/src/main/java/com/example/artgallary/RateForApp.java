package com.example.artgallary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RateForApp extends AppCompatActivity {
    Button submit,logout;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_for_app);
        logout = findViewById(R.id.logoutBtn);
        ratingBar = findViewById(R.id.rating1);
        submit  =findViewById(R.id.submitBtn);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(RateForApp.this,MainActivity.class);
                startActivity(i1);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String rating=String.valueOf(ratingBar.getRating());
                //Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"Thanks for Giving feedback", Toast.LENGTH_SHORT).show();
            }
        });

    }
}