package com.example.artgallary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Babyphotos extends AppCompatActivity {
      ImageView baby1,baby2,baby3,baby4;
      Button bookBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_photos);

        baby1 = findViewById(R.id.imageView1);
        baby2 = findViewById(R.id.imageView2);
        baby3 = findViewById(R.id.imageView3);
        baby4 = findViewById(R.id.imageView4);
        bookBtn = findViewById(R.id.bookBtn);
        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Babyphotos.this,AppointmentForm.class);
                startActivity(i3);
            }
        });

    }
}
