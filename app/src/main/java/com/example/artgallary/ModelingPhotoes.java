package com.example.artgallary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModelingPhotoes extends AppCompatActivity {
    Button bookBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modeling_photoes);
        bookBtn = findViewById(R.id.bookBtn);
        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(ModelingPhotoes.this,AppointmentForm.class);
                startActivity(i3);
            }
        });
    }
}
