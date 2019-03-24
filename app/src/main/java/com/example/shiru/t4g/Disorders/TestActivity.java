package com.example.shiru.t4g.Disorders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shiru.t4g.ListTests;
import com.example.shiru.t4g.MainActivity;
import com.example.shiru.t4g.R;

public class TestActivity extends AppCompatActivity {
  TextView output;
  char yes ='y';


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        output = findViewById(R.id.description);

        if(countChar(Test.resultvalue,yes) == 0 || countChar(Test.resultvalue,yes)==1){
           output.setText("Based on your answers for the PTSD questionnaire, you do not meet the criteria for diagnosis for post-traumatic stress disorder. Although an event may affect us and cause anxiety, it doesn not necessarily cause PTSD. However, if you get too distressed, do not hesitate to consult the available specialists.");
        }
        else if(countChar(Test.resultvalue,yes) == 2 || countChar(Test.resultvalue,yes)==3){
            output.setText("Based on your answers for the PTSD questionnaire, you do not meet the criteria for diagnosis for post-traumatic stress disorder, you however show symptoms of anxiety that may interfere with your day to day life and relationships. We recommend that you proceed to consult a specialist about this.");
        }
        else if(countChar(Test.resultvalue,yes) == 4 || countChar(Test.resultvalue,yes)==5){
            output.setText("Based on your answers for the PTSD questionnaire, you meet the criteria for diagnosis for post-traumatic stress disorder. The event you experienced is significantly affecting your dailt life and activities. For this reason, we suggest that you proceed with the application and share your results  with a specialist to confirm these results.");
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
