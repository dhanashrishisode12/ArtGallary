package com.example.artgallary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AllPreweddingPhotoes extends AppCompatActivity {
    ImageView pre1,pre2,pre3,pre4;
    Button bookBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_prewedding_photoes);
        pre1 = findViewById(R.id.imageView1);
        pre2 = findViewById(R.id.imageView2);
        pre3 = findViewById(R.id.imageView3);
        pre4 = findViewById(R.id.imageView4);
        bookBtn = findViewById(R.id.bookBtn);
        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(AllPreweddingPhotoes.this,AppointmentForm.class);
                startActivity(i3);
            }
        });

    }
    }

