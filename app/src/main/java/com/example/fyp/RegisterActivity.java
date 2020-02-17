package com.example.fyp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mDatabase = FirebaseDatabase.getInstance().getReference("user");

    }

    public void basicWrite(View view){
        //message to the database
        String email = ((EditText) findViewById(R.id.editText_UserEmail)) .getText().toString();
        String password = ((EditText) findViewById(R.id.editText_Password)) .getText() .toString();
        String fullname = ((EditText) findViewById(R.id.editText_fullname)) .getText() .toString();

        mDatabase.child("email").setValue(email);
        mDatabase.child("password").setValue(password);
        mDatabase.child("fullname") .setValue(fullname);
        // end write message

        //checking if fields are empty
        if (TextUtils.isEmpty(fullname)){
            Toast.makeText(this, "Please enter Fullname", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter Password",Toast.LENGTH_LONG).show();
            return;
        }





    }

    //if email and password are not empty, diplay a progress bar


}
