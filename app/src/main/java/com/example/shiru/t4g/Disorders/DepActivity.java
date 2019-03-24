package com.example.shiru.t4g.Disorders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shiru.t4g.ListTests;
import com.example.shiru.t4g.MainActivity;
import com.example.shiru.t4g.R;

public class DepActivity extends AppCompatActivity {
    TextView output;
    char yes ='y';


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dep2);
        output = findViewById(R.id.description);

        if(countChar(Dep.resultvalue,yes) == 0 || countChar(Dep.resultvalue,yes)==1){
            output.setText("Based on your answers for the Depression questionnaire, you do not meet the criteria for diagnosis for Depressive Disorder.There are no relevant symptoms for this disorder. However, if you are concerned, we suggest that you proceed and talk to a mental health specialist here so they can evaluate your case.");
        }
        else if(countChar(Dep.resultvalue,yes) == 2 || countChar(Dep.resultvalue,yes)==3){
            output.setText("Based on your answers for the Depression questionnaire, you do not meet the criteria for diagnosis for Depressive Disorder but you suffer from mood disturbance which should be consulted with a mental health professional who will decide whether you need treatment.");
        }
        else if(countChar(Dep.resultvalue,yes) == 4 || countChar(Dep.resultvalue,yes)==5){
            output.setText("Based on your answers for the Depression questionnaire, you meet the criteria for diagnosis for Depressive Disorder.Your mood causes you intense discomfort and seems to be affecting your daily life and relationships. We suggest that you proceed and consult a mental health professional.");
        }

    }

    public int countChar(String str, char c){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == c){
                count++;
            }
        }
        return  count;
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void takeTest(View view){
        Intent intent = new Intent(this, ListTests.class);
        startActivity(intent);
    }
}
