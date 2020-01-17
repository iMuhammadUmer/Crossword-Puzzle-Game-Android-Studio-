package com.aar.app.wordsearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText txtLoginUsername,txtLoginPass;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLoginUsername = (EditText) findViewById(R.id.txtLoginUsername);
        txtLoginPass = (EditText) findViewById(R.id.txtLoginPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtLoginUsername.getText().toString().trim().length() == 0 && txtLoginPass.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(),"Enter complete details",Toast.LENGTH_LONG).show();
                }
                else{
                    Intent i = new Intent(login.this, adminDashboard.class);
                    startActivity(i);
                }
            }
        });

    }
}
