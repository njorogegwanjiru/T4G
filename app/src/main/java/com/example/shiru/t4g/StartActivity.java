package com.example.shiru.t4g;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {

TextView login, register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

    }

    public void gologin(View view) {
        Intent i = new Intent(StartActivity.this, LoginActivity.class);
        startActivity(i);
    }

    public void goregister(View view) {
        Intent j = new Intent(StartActivity.this, RegisterActivity.class);
        startActivity(j);
    }
}
