package com.example.artgallary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {
   ImageView imageView;
   Button babyP,preweddingP,weddingp,modelingP,babyshowerP,marathilookP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        imageView = findViewById(R.id.imageView1);
        modelingP = findViewById(R.id.modelingBtn);
        babyshowerP = findViewById(R.id.babyshowerBtn);
        marathilookP = findViewById(R.id.marathiBtn);
        preweddingP =  findViewById(R.id.prewediingBtn);
        weddingp = findViewById(R.id.wediingBtn);
        babyP = findViewById(R.id.babyBtn);

        babyP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1  = new Intent(HomeActivity.this, Babyphotos.class);
                startActivity(i1);
            }
        });
        preweddingP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1  = new Intent(HomeActivity.this, AllPreweddingPhotoes.class);
                startActivity(i1);            }
        });
        weddingp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1  = new Intent(HomeActivity.this, WeddingPhotoes.class);
                startActivity(i1);
            }
        });
        modelingP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1  = new Intent(HomeActivity.this, ModelingPhotoes.class);
                startActivity(i1);
            }
        });
        babyshowerP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1  = new Intent(HomeActivity.this, BabyshowerPhotos.class);
                startActivity(i1);
            }
        });
        marathilookP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1  = new Intent(HomeActivity.this, MarathilookPhotos.class);
                startActivity(i1);
            }
        });

    }
}
