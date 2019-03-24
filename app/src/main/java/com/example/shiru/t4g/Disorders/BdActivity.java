package com.example.shiru.t4g.Disorders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shiru.t4g.ListTests;
import com.example.shiru.t4g.MainActivity;
import com.example.shiru.t4g.R;

public class BdActivity extends AppCompatActivity {
    TextView output;
    char yes ='y';


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd2);
        output = findViewById(R.id.description);

        if(countChar(Bd.resultvalue,yes) == 0 || countChar(Bd.resultvalue,yes)==1){
            output.setText("Based on your answers for the Bipolar Disorder questionnaire, you do not meet the criteria for diagnosis for Bipolar Disorder.It is not likely that you arecurrently suffering from a bipolar disorder. However if you are concerned, we suggest that you proceed to speak to a mental health specialist.");
        }
        else if(countChar(Bd.resultvalue,yes) == 2 || countChar(Bd.resultvalue,yes)==3){
            output.setText("Based on your answers for the Bipolar Disorder questionnaire, you do not meet the criteria for diagnosis for Bipolar Disorder. It is not likely that you are currently suffering from a bipolar disorder but you have some symptoms of mood disorders. For this reason, we suggest that you proceed to speak to a mental health specialist.");
        }
        else if(countChar(Bd.resultvalue,yes) == 4 || countChar(Bd.resultvalue,yes)==5){
            output.setText("Based on your answers for the Bipolar Disorder questionnaire, you meet the criteria for diagnosis for Bipolar Disorder.You seem to be suffering from severe symptoms associated with bipolar disorder. We suggest that you proceed and talk to a mental health professional.");
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
