package com.example.artgallary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {
    private EditText email, password;
    private Button login;
    private TextView signUp;
    private FirebaseAuth mAuth;
    private ProgressDialog mDialog;
   //DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mDatabase.keepSynced(true);
        mAuth = FirebaseAuth.getInstance();

        mDialog = new ProgressDialog(this);

        email = findViewById(R.id.emailid);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginBtn);
        signUp = findViewById(R.id.signup_txt);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = email.getText().toString().trim();
                String mpassword = password.getText().toString().trim();
                if (TextUtils.isEmpty(mEmail)) {
                    email.setError("Required Field...");
                    return;
                }
                if (TextUtils.isEmpty(mpassword)) {
                    password.setError("Required Field...");
                    return;
                }
                mDialog.setMessage("procesing....");
                mDialog.show();
                mAuth.signInWithEmailAndPassword(mEmail, mpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                            Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();

                            mDialog.dismiss();
                        } else {

                            Toast.makeText(getApplicationContext(), "Failed.", Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();
                        }

                    }
                });
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(),Registration.class);
                startActivity(i1);
            }
        });

    }
}

