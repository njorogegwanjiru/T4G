package com.example.shiru.t4g.Disorders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shiru.t4g.ListTests;
import com.example.shiru.t4g.MainActivity;
import com.example.shiru.t4g.R;

public class PsyActivity extends AppCompatActivity {
    TextView output;
    char yes ='y';


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psy2);
        output = findViewById(R.id.description);

        if(countChar(Psy.resultvalue,yes) == 0 || countChar(Psy.resultvalue,yes)==1){
            output.setText("Based on your answers for the Psychoses questionnaire, you do not meet the criteria for diagnosis for psychopathic characteristics.You do not show any signs of a personality with psychopathic characteristics.");
        }
        else if(countChar(Psy.resultvalue,yes) == 2 || countChar(Psy.resultvalue,yes)==3){
            output.setText("Based on your answers for the Psychoses questionnaire, you do not meet the criteria for diagnosis for psychopathic characteristics. This implies that you may show precense of some psychopathic characteristics but not extreme. However, if you are concerned, proceed and talk to a mental health professional for evaluation");
        }
        else if(countChar(Psy.resultvalue,yes) == 4 || countChar(Psy.resultvalue,yes)==5){
            output.setText("Based on your answers for the Psychoses questionnaire, you meet the criteria for diagnosis for psychopathic characteristics.You seem to have strong psychopathic characteristics. You need to learn to handle your emotions adequately. We recommend that you proceed to seek advice of a mental health specialist here.");
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
