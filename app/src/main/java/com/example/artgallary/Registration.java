package com.example.artgallary;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
    private EditText name, mobileNo, address1, password1, emailId;
    private Button registration;
    private TextView signin;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    DatabaseReference mDatabase;

    FirebaseAuth mAuth;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        signin = findViewById(R.id.login_txt);
        name = findViewById(R.id.ename);
        mobileNo = findViewById(R.id.mNo);
        address1 = findViewById(R.id.address);
        password1 = findViewById(R.id.password);
        emailId = findViewById(R.id.emailId);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Data");
        mDatabase.keepSynced(true);

        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);


        registration = findViewById(R.id.registerBtn);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    private void sendData() {

        String id = mDatabase.push().getKey();
        String mName = name.getText().toString().trim();
        String maddress = address1.getText().toString().trim();
        String mobile1 = mobileNo.getText().toString().trim();

        String mEmail = emailId.getText().toString().trim();
        String mPass = password1.getText().toString().trim();

        if (!TextUtils.isEmpty(mName)) {

            Data data = new Data(id, mName, maddress, mobile1);

            mDatabase.child(mName).setValue(data);

           /* if (TextUtils.isEmpty(mName)) {
                name.setError("Required Field..");
                return;
            }
            */
            if (TextUtils.isEmpty(maddress)) {
                address1.setError("Required Field..");
                return;
            }
            if (TextUtils.isEmpty(mobile1)) {
                mobileNo.setError("Required Field..");
                return;
            }
            if (TextUtils.isEmpty(mEmail)) {
                emailId.setError("Required Field..");
                return;
            }
            if (TextUtils.isEmpty(mPass)) {
                password1.setError("Required Field..");
                return;
            }
           /* if(emailId.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(),"enter email address",Toast.LENGTH_SHORT).show();
            }else {
                if (emailId.getText().toString().trim().matches(emailPattern)) {
                   // Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));

                } else {
                    Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                }
            }
        }

            */
            mDialog.setMessage("Processing..");
            mDialog.show();

            mAuth.createUserWithEmailAndPassword(mEmail, mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
                        mDialog.dismiss();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Failed..", Toast.LENGTH_SHORT).show();
                        mDialog.dismiss();
                    }

                }
            });

        }
    }
}
