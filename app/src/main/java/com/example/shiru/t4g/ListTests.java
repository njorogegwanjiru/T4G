package com.example.shiru.t4g;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.shiru.t4g.Disorders.Anx;
import com.example.shiru.t4g.Disorders.Bd;
import com.example.shiru.t4g.Disorders.Dep;
import com.example.shiru.t4g.Disorders.Psy;
import com.example.shiru.t4g.Disorders.Test;

public class ListTests extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tests);
    }

    public void testing(View view) {
        Intent intent = new Intent(ListTests.this, Test.class);
        startActivity(intent);
    }
    public void testing1(View view) {
        Intent intent = new Intent(ListTests.this, Dep.class);
        startActivity(intent);
    } public void testing2(View view) {
        Intent intent = new Intent(ListTests.this, Anx.class);
        startActivity(intent);
    } public void testing3(View view) {
        Intent intent = new Intent(ListTests.this, Bd.class);
        startActivity(intent);
    } public void testing4(View view) {
        Intent intent = new Intent(ListTests.this, Psy.class);
        startActivity(intent);
    }
}
