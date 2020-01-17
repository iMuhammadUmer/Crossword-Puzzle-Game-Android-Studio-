package com.aar.app.wordsearch;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class signup extends AppCompatActivity {

    EditText txtName,txtEmail, txtUsername, txtPass;
    CardView cvSignUp;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txtName = (EditText) findViewById(R.id.txtName);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPass = (EditText) findViewById(R.id.txtPass);
        cvSignUp = (CardView) findViewById(R.id.cvSignUp);

        final String name = txtName.getText().toString();
        final String email = txtEmail.getText().toString();
        final String username = txtUsername.getText().toString();
        final String password = txtPass.getText().toString();

        db = openOrCreateDatabase("MasterMindDB", Context.MODE_PRIVATE,null);

        db.execSQL("create table if not exists tbl_users(" +
                "usr_id int primary key autoincrement not null," +
                "usr_name varchar not null," +
                "usr_email varchar unique not null," +
                "usr_username varchar unique not null ," +
                "password varchar not null);");

        cvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.trim().length() == 0 || !name.matches("[a-zA-Z]+"))
                {
                    txtName.requestFocus();
                    txtName.setError("Invalid Name");
                }
                if(email.trim().length() == 0 || !email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))
                {
                    txtEmail.requestFocus();
                    txtEmail.setError("Invalid Email");
                }
                if(username.trim().length() == 0)
                {
                    txtUsername.requestFocus();
                    txtUsername.setError("Username required");
                }
                if(password.trim().length() == 0)
                {
                    txtPass.requestFocus();
                    txtPass.setError("Password required");
                }
                else
                {
                    db.execSQL("insert into tbl_users values('" + txtName.getText() + "','" + txtEmail.getText() + "','" + txtUsername.getText() + "','" + txtPass.getText() + "');");
                    Toast.makeText(getApplicationContext(), "Data inserted", Toast.LENGTH_SHORT).show();
                    Intent obj = new Intent(getApplicationContext(), login.class);
                    startActivity(obj);
                }
            }
        });


    }
}
