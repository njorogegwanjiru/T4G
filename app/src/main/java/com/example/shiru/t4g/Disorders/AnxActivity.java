package com.example.shiru.t4g.Disorders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shiru.t4g.ListTests;
import com.example.shiru.t4g.MainActivity;
import com.example.shiru.t4g.R;

public class AnxActivity extends AppCompatActivity {
    TextView output;
    char yes ='y';


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anx2);
        output = findViewById(R.id.description);

        if(countChar(Anx.resultvalue,yes) == 0 || countChar(Anx.resultvalue,yes)==1){
            output.setText("Based on your answers for the Anxiety questionnaire, you do not meet the criteria for diagnosis for Anxiety. Although sometimes you may feel more anxious than usual, your response to this anxiety is appropriate and falls within expected reactions. Remember to always recognize when your levels of anxiety increase and note their causes and triggers in order to be able to lead a healthy life..");
        }
        else if(countChar(Anx.resultvalue,yes) == 2 || countChar(Anx.resultvalue,yes)==3){
            output.setText("Based on your answers for the Anxiety questionnaire, you do not meet the criteria for diagnosis for Anxiety. This implies that your anxiety levels are normal . Be careful and try to control your anxiety and relax when you feel your anxiety levels increasing.");
        }
        else if(countChar(Anx.resultvalue,yes) == 4 || countChar(Anx.resultvalue,yes)==5){
            output.setText("Based on your answers for the Anxiety questionnaire, you meet the criteria for diagnosis for Anxiety. Your levels of anxiety are too high. It is important that you learn to co ntrol your anxiety because it may lead to serious emotional and health problems. Start by taking life in a more relaxed way and if you cannot do this, proceed to seek advice of a mental health specialist here.");
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
